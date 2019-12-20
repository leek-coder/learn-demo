package com.huatech.mall.role;

import com.huatech.mall.common.service.IBaseService;
import com.huatech.mall.entity.role.Role;
import com.huatech.mall.param.role.RoleGrantParam;
import com.huatech.mall.param.role.RoleParam;
import com.huatech.mall.res.role.RoleQuery;

import java.util.List;

/**
 * 角色service
 *
 * @author like
 * @date 2019-12-04 4:30 下午
 **/
public interface IRoleService extends IBaseService<Role, Long> {

    /**
     * 查询所有的角色列表
     *
     * @param param
     * @return
     */
    List<RoleQuery> findRoleList(RoleParam param);



    /**
     * 给角色授权
     *
     * @param grantParam
     */
    void grant(RoleGrantParam grantParam);
}