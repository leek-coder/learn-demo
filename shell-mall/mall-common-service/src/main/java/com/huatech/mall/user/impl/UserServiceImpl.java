package com.huatech.mall.user.impl;

import com.github.pagehelper.PageHelper;
import com.huatech.mall.common.constants.ApiBaseConstants;
import com.huatech.mall.common.enums.ApiBaseErrorCore;
import com.huatech.mall.common.exception.ExceptionCustomer;
import com.huatech.mall.common.mapper.IBaseMapper;
import com.huatech.mall.common.service.impl.BaseServiceImpl;
import com.huatech.mall.common.utils.MD5Utils;
import com.huatech.mall.entity.user.User;
import com.huatech.mall.mapper.user.UserMapper;
import com.huatech.mall.param.user.UserParam;
import com.huatech.mall.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
}