package com.huatech.mall.resource.impl;

import com.github.pagehelper.PageHelper;
import com.huatech.mall.common.enums.ApiBaseErrorCore;
import com.huatech.mall.common.exception.ExceptionCustomer;
import com.huatech.mall.common.mapper.IBaseMapper;
import com.huatech.mall.common.service.impl.BaseServiceImpl;
import com.huatech.mall.entity.resource.Resource;
import com.huatech.mall.mapper.resource.ResourceMapper;
import com.huatech.mall.param.resource.ResourceParam;
import com.huatech.mall.resource.IResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 系统资源service实现
 *
 * @author like
 * @date 2019-12-04 4:54 下午
 **/
@Service
public class ResourceServiceImpl extends BaseServiceImpl<Resource, Long> implements IResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public IBaseMapper<Resource, Long> getBaseMapper() {
        return this.resourceMapper;
    }

    /**
     * 只是为了添加资源成功，便于测试，直接落库，不进行数据验证
     *
     * @param entity
     * @return
     */
    @Override
    public int insert(Resource entity) {
        //更新
        if (entity.getId() != null) {
            Resource resource = find(entity.getId());
            if (resource == null) {
                throw new ExceptionCustomer(ApiBaseErrorCore.RESOURCE_NOT_EXISTS);
            }
            resource.setDescription(entity.getDescription());
            resource.setLevel(entity.getLevel());
            resource.setIsHide(entity.getIsHide());
            resource.setName(entity.getName());
            resource.setParentId(entity.getParentId());
            resource.setSourceKey(entity.getSourceKey());
            resource.setSourceUrl(entity.getSourceUrl());
            resource.setType(entity.getType());
            resource.setSort(entity.getSort());
            resource.setUpdateTime(new Date());
            return updateByPrimaryKey(resource);

        } else {
            //添加
            entity.setCreateTime(new Date());
            return insertSelective(entity);
        }
    }


    @Override
    public List<Resource> findResourcesList(ResourceParam param) {
        PageHelper.startPage(param.getPage(),param.getSize());
        return resourceMapper.findResourcesList(param);
    }
}