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
    Role findRoleByName(String roleName);

    /**
     * 根据角色key查询实体
     *
     * @param key
     * @return
     */
    Role findRoleByKey(String key);

    /**
     * 根据条件查询role列表
     * @param roleParam
     * @return
     */
    List<RoleQuery> findRoleList(RoleParam roleParam);
}