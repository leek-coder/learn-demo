package com.huatech.mall.user;

import com.huatech.mall.common.service.IBaseService;
import com.huatech.mall.common.utils.TreeNode;
import com.huatech.mall.entity.user.User;
import com.huatech.mall.param.user.LoginParam;
import com.huatech.mall.param.user.UserParam;
import com.huatech.mall.res.user.LoginUserRes;
import com.huatech.mall.res.user.MenusRes;
import com.huatech.mall.res.user.UserRoleRes;

import java.util.List;
import java.util.Map;


/**
 * 用户管理service
 *
 * @author like
 * @date 2019-12-03 11:27 上午
 **/
public interface IUserService extends IBaseService<User, Long> {

    /**
     * 查询条件用户列表
     *
     * @param userParam
     * @return
     */
    List<User> findUserList(UserParam userParam);

    /**
     * @description: 用户登陆
     * @Param
     * @return:
     * @author: leek
     * @time: 2019/12/11 3:10 下午
     */
    LoginUserRes login(LoginParam loginParam);


    /**
     * 查询用户角色
     *
     * @param userId
     * @return
     */
    UserRoleRes findUserRoles(Long userId);

    /**
     * 查询角色权限树
     *
     * @param roleId
     * @return
     */
    List<MenusRes> findRoleMenus(Long roleId);
}