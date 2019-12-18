package com.huatech.mall.mapper.resource;

import com.huatech.mall.common.mapper.IBaseMapper;
import com.huatech.mall.entity.resource.Resource;
import com.huatech.mall.param.resource.ResourceParam;
import com.huatech.mall.res.resource.ResourceList;
import com.huatech.mall.res.role.ResourceQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author like
 */
public interface ResourceMapper extends IBaseMapper<Resource, Long> {

    /**
     * 查询所有资源列表
     *
     * @param param
     * @return
     */
    List<ResourceList> findResourcesList(ResourceParam param);

    /**
     * 根据角色id查询资源
     *
     * @param rId
     * @return
     */
    List<ResourceQuery> selectResourceByRoleId(Long rId);

    /**
     * 根据父节点查询资源
     *
     * @param parentId
     * @return
     */
    List<ResourceQuery> selectResourceByParentId(@Param("parentId") Long parentId,@Param("roleId") Long roleId);
}