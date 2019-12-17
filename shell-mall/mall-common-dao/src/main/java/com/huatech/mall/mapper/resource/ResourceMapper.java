package com.huatech.mall.mapper.resource;

import com.huatech.mall.common.mapper.IBaseMapper;
import com.huatech.mall.entity.resource.Resource;
import com.huatech.mall.param.resource.ResourceParam;
import com.huatech.mall.res.resource.ResourceList;

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
}