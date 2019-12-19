package com.huatech.mall.resource.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huatech.mall.common.enums.ApiBaseErrorCore;
import com.huatech.mall.common.exception.ExceptionCustomer;
import com.huatech.mall.common.mapper.IBaseMapper;
import com.huatech.mall.common.service.impl.BaseServiceImpl;
import com.huatech.mall.common.utils.ITreeNode;
import com.huatech.mall.common.utils.Tree;
import com.huatech.mall.common.utils.TreeNode;
import com.huatech.mall.entity.resource.Resource;
import com.huatech.mall.mapper.resource.ResourceMapper;
import com.huatech.mall.param.resource.ResourceParam;
import com.huatech.mall.res.resource.ResourceList;
import com.huatech.mall.res.resource.ResourceQueryRes;
import com.huatech.mall.res.user.MenusRes;
import com.huatech.mall.res.user.UserResourcesRes;
import com.huatech.mall.resource.IResourceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
            resource.setIcon(entity.getIcon());
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
    public ResourceQueryRes findResourcesList(ResourceParam param) {
        PageHelper.startPage(param.getPage(), param.getSize());
        List<ResourceList> resourcesList = resourceMapper.findResourcesList(param);
        PageInfo<ResourceList> pageInfo = new PageInfo<>(resourcesList);
        return new ResourceQueryRes(pageInfo.getTotal(), pageInfo.getList());
    }

    /**
     * 获取系统资源树
     *
     * @return
     */
    @Override
    public List<MenusRes> findTrees() {

        //查询系统所有的资源
        List<ResourceList> resourcesList = resourceMapper.findResourcesList(new ResourceParam());
        List<ITreeNode> list = new ArrayList<>();
        resourcesList.forEach(e -> {
            UserResourcesRes userResourcesRes = new UserResourcesRes();
            BeanUtils.copyProperties(e, userResourcesRes);
            list.add(userResourcesRes);
        });
        Tree tree = new Tree(list);
        List<TreeNode> tree1 = tree.getTree();
        SimplePropertyPreFilter filter = new SimplePropertyPreFilter();
        filter.getExcludes().add("parent");
        List<MenusRes> menusRes = JSONArray.parseArray(JSONObject.toJSONString(tree1, filter), MenusRes.class);
        return menusRes.stream().sorted(Comparator.comparing(MenusRes::getOrderNum)).collect(Collectors.toList());

    }
}