package com.huatech.mall.mapper.user;

import com.huatech.mall.common.mapper.IBaseMapper;
import com.huatech.mall.entity.user.User;
import com.huatech.mall.param.user.UserParam;
import com.huatech.mall.param.user.UserRoleParam;
import com.huatech.mall.res.user.UserList;
import com.huatech.mall.res.user.UserResourcesRes;
import com.huatech.mall.res.user.UserRoleRes;
import org.apache.ibatis.annotations.Param;

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
    List<UserList> findUserList(UserParam userParam);

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

    /**
     * 根据用户id，查询用户角色
     *
     * @param userId
     * @return
     */
    UserRoleRes findUserRoles(Long userId);

    /**
     * 角色下所有资源列表
     *
     * @param roleId
     * @return
     */
    List<UserResourcesRes> findRoleResources(Long roleId);

    /**
     * 查找用户角色
     *
     * @param userId
     * @return
     */
    UserRoleParam findUserRoleByUserId(Long userId);

    /**
     * 更新用户角色
     * @param userRoleParam
     * @return
     */
    int updateUserRoleByUserId(UserRoleParam userRoleParam);

    /**
     * 添加用户角色
     * @param userRoleParam
     * @return
     */
    int insertUserRole(UserRoleParam userRoleParam);

}