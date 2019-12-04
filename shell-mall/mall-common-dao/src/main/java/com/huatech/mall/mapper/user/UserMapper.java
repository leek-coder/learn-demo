package com.huatech.mall.mapper.user;

import com.huatech.mall.common.mapper.IBaseMapper;
import com.huatech.mall.entity.user.User;
import com.huatech.mall.param.user.UserParam;

import java.util.List;

/**
 * @author like
 * @Version 1.0
 */
public interface UserMapper extends IBaseMapper<User, Long> {

    /**
     * 查询所有用户
     *
     * @param userParam
     * @return
     */
    List<User> findUserList(UserParam userParam);

    /**
     * 根据用户姓名查询
     *
     * @param userName
     * @return
     */
    User findUserByUserName(String userName);

    /**
     * 根据手机号查询
     *
     * @param telephone
     * @return
     */
    User findUserByPhone(String telephone);
}