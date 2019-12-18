package com.huatech.mall.role.impl;

import com.github.pagehelper.PageHelper;
import com.huatech.mall.common.constants.ApiBaseConstants;
import com.huatech.mall.common.enums.ApiBaseErrorCore;
import com.huatech.mall.common.exception.ExceptionCustomer;
import com.huatech.mall.common.mapper.IBaseMapper;
import com.huatech.mall.common.service.impl.BaseServiceImpl;
import com.huatech.mall.entity.role.Role;
import com.huatech.mall.mapper.resource.ResourceMapper;
import com.huatech.mall.mapper.role.RoleMapper;
import com.huatech.mall.param.role.RoleParam;
import com.huatech.mall.res.role.ResourceQuery;
import com.huatech.mall.res.role.RoleQuery;
import com.huatech.mall.role.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 角色service实现类
 *
 * @author like
 * @date 2019-12-04 4:31 下午
 **/
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role, Long> implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public IBaseMapper<Role, Long> getBaseMapper() {
        return this.roleMapper;
    }

    /**
     * 查询所有角色
     *
     * @param param
     * @return
     */
    @Override
    public List<RoleQuery> findRoleList(RoleParam param) {
        PageHelper.startPage(param.getPage(), param.getSize());
        //先查出最顶级的权限
        List<RoleQuery> roles = roleMapper.findRoleList(param);
        roles.forEach(e -> {
            List<ResourceQuery> children = e.getChildren();
            children.forEach(e1 -> {
                //查询第二层数据
                List<ResourceQuery> resourceQueries = resourceMapper.selectResourceByParentId(e1.getId(), e.getId());
                e1.setChildren(resourceQueries);
                resourceQueries.forEach(e2 -> {
                    List<ResourceQuery> resource = resourceMapper.selectResourceByParentId(e2.getId(), e.getId());
                    e2.setChildren(resource);
                });
            });

        });

        return roles;
    }

    /**
     * save or update
     *
     * @param entity
     * @return
     */
    @Override
    public int insert(Role entity) {
        if (entity.getId() != null) {
            //更新
            Role role = roleMapper.selectByPrimaryKey(entity.getId());
            if (role == null) {
                throw new ExceptionCustomer(ApiBaseErrorCore.ROLE_NOT_EXISTS);
            }
            checkRole(entity);
            role.setUpdateTime(new Date());
            role.setName(entity.getName());
            role.setRoleKey(entity.getRoleKey());
            role.setDescription(entity.getDescription());
            //更新
            return roleMapper.updateByPrimaryKey(role);

        } else {
            //新增
            checkRole(entity);
            entity.setCreateTime(new Date());
            entity.setStatus(ApiBaseConstants.NOT_DELETE_STATUS);
            return roleMapper.insertSelective(entity);
        }
    }

    /**
     * 坚持角色是否存在
     *
     * @param role
     */
    public void checkRole(Role role) {
        Role byName = roleMapper.findRoleByName(role.getName());
        if (byName != null) {
            throw new ExceptionCustomer(ApiBaseErrorCore.ROLE_EXISTS);
        }
        Role byKey = roleMapper.findRoleByKey(role.getRoleKey());
        if (byKey != null) {
            throw new ExceptionCustomer(ApiBaseErrorCore.ROLE_EXISTS);
        }
    }

}