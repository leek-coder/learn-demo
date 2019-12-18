package com.huatech.mall.mapper.role;

import com.huatech.mall.common.mapper.IBaseMapper;
import com.huatech.mall.entity.role.Role;
import com.huatech.mall.param.role.RoleParam;
import com.huatech.mall.res.role.RoleQuery;

import java.util.List;

/**
 * @author leek
 */
public interface RoleMapper extends IBaseMapper<Role, Long> {

    /**
     * 根据角色名查询实体
     *
     * @param roleName
     * @return
     */
    List<Role> findRoleByName(String roleName);

    /**
     * 根据角色key查询实体
     *
     * @param key
     * @return
     */
    List<Role> findRoleByKey(String key);

    /**
     * 根据条件查询role列表
     *
     * @param roleParam
     * @return
     */
    List<RoleQuery> findRoleList(RoleParam roleParam);

    /**
     * 根据roleId解除用户-角色关联
     *
     * @param roleId
     * @return
     */
    int deleteUserRoleByRoleId(Long roleId);

    /**
     * 根据roleId解除角色-资源关联
     *
     * @param roleId
     * @return
     */
    int deleteRoleResourceByRoleId(Long roleId);
}