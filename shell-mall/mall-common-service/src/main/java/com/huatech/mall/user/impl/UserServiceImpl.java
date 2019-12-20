package com.huatech.mall.user.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huatech.mall.common.constants.ApiBaseConstants;
import com.huatech.mall.common.enums.ApiBaseErrorCore;
import com.huatech.mall.common.exception.ExceptionCustomer;
import com.huatech.mall.common.jwt.Token;
import com.huatech.mall.common.mapper.IBaseMapper;
import com.huatech.mall.common.response.ResponseResult;
import com.huatech.mall.common.service.impl.BaseServiceImpl;
import com.huatech.mall.common.utils.*;
import com.huatech.mall.entity.role.Role;
import com.huatech.mall.entity.user.User;
import com.huatech.mall.mapper.user.UserMapper;
import com.huatech.mall.param.user.LoginParam;
import com.huatech.mall.param.user.UserParam;
import com.huatech.mall.param.user.UserRoleParam;
import com.huatech.mall.remote.user.IAuthUserFeignService;
import com.huatech.mall.remote.user.request.UserTokenReq;
import com.huatech.mall.res.user.*;
import com.huatech.mall.role.IRoleService;
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
    private IRoleService roleService;

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
            if (!entity.getTelephone().equals(user.getTelephone())) {
                User user1 = userMapper.findUserByPhone(entity.getTelephone());
                if (user1 != null) {
                    throw new ExceptionCustomer(ApiBaseErrorCore.PHONE_EXISTS);
                }
            }
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
                throw new ExceptionCustomer(ApiBaseErrorCore.PHONE_EXISTS);
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
    public UserQueryRes findUserList(UserParam userParam) {
        PageHelper.startPage(userParam.getPage(), userParam.getSize());
        PageInfo pageInfo = new PageInfo(userMapper.findUserList(userParam));
        return UserQueryRes.builder().total(pageInfo.getTotal()).users(pageInfo.getList()).build();
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
    public List<MenusRes> findRoleMenus(Long userId) {
        UserRoleRes roleRes = findUserRoles(userId);
        //查询所有的角色权限
        List<UserResourcesRes> resList = userMapper.findRoleResources(roleRes.getRid());
        List<ITreeNode> list = new ArrayList<>();
        resList.forEach(e -> {
            list.add(e);
        });
        Tree tree = new Tree(list);
        List<TreeNode> tree1 = tree.getTree();
        SimplePropertyPreFilter filter = new SimplePropertyPreFilter();
        filter.getExcludes().add("parent");
        List<MenusRes> menusRes = JSONArray.parseArray(JSONObject.toJSONString(tree1, filter), MenusRes.class);
        return menusRes.stream().sorted(Comparator.comparing(MenusRes::getOrderNum)).collect(Collectors.toList());

    }

    @Override
    public void recovery(Long id) {
        User user = find(id);
        if (null == user) {
            throw new ExceptionCustomer(ApiBaseErrorCore.USER_NOT_EXISTS);
        }
        user.setDeleteStatus(ApiBaseConstants.NOT_DELETE_STATUS);
        updateByPrimaryKey(user);
    }

    /**
     * 给用户分配角色
     *
     * @param userRoleParam
     */
    @Override
    public void grantRole(UserRoleParam userRoleParam) {

        User user = find(userRoleParam.getUId());
        if (null == user) {
            throw new ExceptionCustomer(ApiBaseErrorCore.USER_NOT_EXISTS);
        }
        Role role = roleService.find(userRoleParam.getRId());
        if (role == null) {
            throw new ExceptionCustomer(ApiBaseErrorCore.ROLE_NOT_EXISTS);
        }
        UserRoleParam roleParam = userMapper.findUserRoleByUserId(userRoleParam.getUId());
        if (roleParam != null) {
            roleParam.setRId(userRoleParam.getRId());
            userMapper.updateUserRoleByUserId(roleParam);
            return;
        }

        userMapper.insertUserRole(userRoleParam);

    }


    /**
     * 删除用户  逻辑删除
     *
     * @param userId
     * @return
     */
    @Override
    public int delete(Long userId) {
        User user = find(userId);
        if (null == user) {
            throw new ExceptionCustomer(ApiBaseErrorCore.USER_NOT_EXISTS);
        }
        user.setDeleteStatus(ApiBaseConstants.HAD_DELETE_STATUS);
        return updateByPrimaryKey(user);
    }
}