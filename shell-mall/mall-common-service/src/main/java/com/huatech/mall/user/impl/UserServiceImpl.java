package com.huatech.mall.user.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.github.pagehelper.PageHelper;
import com.huatech.mall.common.constants.ApiBaseConstants;
import com.huatech.mall.common.enums.ApiBaseErrorCore;
import com.huatech.mall.common.exception.ExceptionCustomer;
import com.huatech.mall.common.jwt.Token;
import com.huatech.mall.common.mapper.IBaseMapper;
import com.huatech.mall.common.response.ResponseResult;
import com.huatech.mall.common.service.impl.BaseServiceImpl;
import com.huatech.mall.common.utils.*;
import com.huatech.mall.entity.user.User;
import com.huatech.mall.mapper.user.UserMapper;
import com.huatech.mall.param.user.LoginParam;
import com.huatech.mall.param.user.UserParam;
import com.huatech.mall.remote.user.IAuthUserFeignService;
import com.huatech.mall.remote.user.request.UserTokenReq;
import com.huatech.mall.res.user.LoginUserRes;
import com.huatech.mall.res.user.MenusRes;
import com.huatech.mall.res.user.UserResourcesRes;
import com.huatech.mall.res.user.UserRoleRes;
import com.huatech.mall.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 用户管理service实现
 *
 * @author like
 * @date 2019-12-03 11:28 上午
 **/
@Service
public class UserServiceImpl extends BaseServiceImpl<User, Long> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IAuthUserFeignService authUserFeignService;

    @Autowired
    private ICacheService cacheService;

    @Value("${redis.token.prefix}")
    private String USER_PREFIX;

    @Override
    public IBaseMapper<User, Long> getBaseMapper() {
        return this.userMapper;
    }


    /**
     * 新增&&更新用户
     *
     * @param entity
     * @return
     */
    @Override
    public int insert(User entity) {

        //修改
        if (entity.getId() != null) {
            //根据用户id查询用户是否存在
            User user = userMapper.selectByPrimaryKey(entity.getId());
            if (user == null) {
                throw new ExceptionCustomer(ApiBaseErrorCore.USER_NOT_EXISTS);
            }
            user.setAddress(entity.getAddress());
            user.setBirthday(entity.getBirthday());
            user.setEmail(entity.getEmail());
            user.setNickName(entity.getNickName());
            user.setLocked(entity.getLocked());
            user.setDescription(entity.getDescription());
            user.setUpdateTime(new Date());
            return userMapper.updateByPrimaryKey(user);
        } else {
            //根据用户名查询系统中是否有重复的用户
            User user = userMapper.findUserByUserName(entity.getUserName());
            if (user != null) {
                throw new ExceptionCustomer(ApiBaseErrorCore.USER_EXISTS);
            }
            User user1 = userMapper.findUserByPhone(entity.getTelephone());
            if (user1 != null) {
                throw new ExceptionCustomer(ApiBaseErrorCore.USER_EXISTS);
            }
            entity.setCreateTime(new Date());
            entity.setLocked(ApiBaseConstants.NOT_LOCKED);
            entity.setDeleteStatus(ApiBaseConstants.NOT_DELETE_STATUS);
            //设置密码
            String md5_password = MD5Utils.md5(ApiBaseConstants.ORIGIN_PASSWORD);
            entity.setPassword(md5_password);
            return userMapper.insertSelective(entity);
        }

    }

    /**
     * 查询用户列表
     *
     * @param userParam
     * @return
     */
    @Override
    public List<User> findUserList(UserParam userParam) {
        PageHelper.startPage(userParam.getPage(), userParam.getSize());
        return userMapper.findUserList(userParam);
    }

    /**
     * @description: 用户登陆
     * @Param
     * @return:
     * @author: leek
     * @time: 2019/12/11 3:10 下午
     */
    @Override
    public LoginUserRes login(LoginParam loginParam) {
        //检查参数合法性
        BeanValidator.check(loginParam);
        //根据用户名查询用户是否存在
        User user = userMapper.findUserByUserName(loginParam.getUserName());
        if (null == user) {
            throw new ExceptionCustomer(ApiBaseErrorCore.USER_NOT_EXISTS);
        }
        //检测密码是否一致
        String input_password = MD5Utils.md5(loginParam.getPassword());
        if (!input_password.equals(user.getPassword())) {
            throw new ExceptionCustomer(ApiBaseErrorCore.PASSWORD_ERROR);
        }
        //验证通过生成token，并保存到redis里
        UserTokenReq tokenReq = UserTokenReq.builder().id(user.getId()).nickName(user.getNickName()).userName(user.getUserName()).build();
        ResponseResult<Token> response = authUserFeignService.createToken(JsonUtils.toString(tokenReq));
        if (response.getCode() != ApiBaseConstants.REMOTE_SUCCESS || response.getData() == null) {
            //调用鉴权接口失败
            throw new ExceptionCustomer(ApiBaseErrorCore.AUTH_REMOTE_FAIL);
        }

        Token token = response.getData();
        String tokenStr = token.getToken();
        //保存redis
        cacheService.set(USER_PREFIX + user.getId(), tokenStr, token.getExpiration());
        LoginUserRes login = LoginUserRes.builder().email(user.getEmail()).id(user.getId()).mobile(user.getTelephone()).token(tokenStr).userName(user.getUserName()).build();

        return login;
    }

    @Override
    public UserRoleRes findUserRoles(Long userId) {
        return userMapper.findUserRoles(userId);
    }

    @Override
    public List<MenusRes> findRoleMenus(Long roleId) {
        //查询所有的角色权限
        List<UserResourcesRes> resList = userMapper.findRoleResources(roleId);
        List<ITreeNode> list = new ArrayList<>();
        resList.forEach(e -> {
            list.add(e);
        });
        Tree tree = new Tree(list);
        List<TreeNode> tree1 = tree.getTree();
        SimplePropertyPreFilter filter = new SimplePropertyPreFilter();
        filter.getExcludes().add("parent");
        List<MenusRes> menusRes = JSONArray.parseArray(JSONObject.toJSONString(tree1, filter), MenusRes.class);

        return menusRes;

    }


}