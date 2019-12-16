package com.huatech.mall.resource;

import com.huatech.mall.common.service.IBaseService;
import com.huatech.mall.entity.resource.Resource;
import com.huatech.mall.param.resource.ResourceParam;
import com.huatech.mall.res.resource.ResourceQueryRes;

import java.util.List;

/**
 * 系统资源service
 *
 * @author like
 * @date 2019-12-04 4:53 下午
 **/
public interface IResourceService extends IBaseService<Resource, Long> {
    /**
     * 查询所有的资源
     *
     * @param param
     * @return
     */
    ResourceQueryRes findResourcesList(ResourceParam param);
}