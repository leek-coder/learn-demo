package com.huatech.mall.user;

import com.huatech.mall.common.service.IBaseService;
import com.huatech.mall.entity.user.User;
import com.huatech.mall.param.user.UserParam;

import java.util.List;


/**
 * 用户管理service
 *
 * @author like
 * @date 2019-12-03 11:27 上午
 **/
public interface IUserService extends IBaseService<User,Long> {

    /**
     * 查询条件用户列表
     * @param userParam
     * @return
     */
    List<User> findUserList(UserParam userParam);
}