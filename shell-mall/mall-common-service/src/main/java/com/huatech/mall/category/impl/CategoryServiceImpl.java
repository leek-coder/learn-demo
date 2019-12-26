package com.huatech.mall.category.impl;

import com.huatech.mall.category.ICategoryService;
import com.huatech.mall.common.constants.ApiBaseConstants;
import com.huatech.mall.common.enums.ApiBaseErrorCore;
import com.huatech.mall.common.exception.ExceptionCustomer;
import com.huatech.mall.common.mapper.IBaseMapper;
import com.huatech.mall.common.service.impl.BaseServiceImpl;
import com.huatech.mall.common.utils.BeanValidator;
import com.huatech.mall.entity.category.Category;
import com.huatech.mall.mapper.category.CategoryMapper;
import com.huatech.mall.param.category.CategoryParam;
import com.huatech.mall.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * @Author leek
 * @Date 2019-12-18 下午10:19
 * @Version 1.0
 * @Description
 */
@Service
public class CategoryServiceImpl extends BaseServiceImpl<Category, Integer> implements ICategoryService {


    @Autowired
    private CategoryMapper categoryMapper;


    @Autowired
    private IProductService productService;

    @Override
    public IBaseMapper<Category, Integer> getBaseMapper() {
        return this.categoryMapper;
    }


    @Override
    public void deleteCategory(Integer id) {

    }

    /**
     * 添加类目
     *
     * @param param
     */
    @Override
    public void saveCategory(CategoryParam param) {

        //验证参数的合法性
        BeanValidator.check(param);

        if (param.getId() != null) {
            //先查询类目是否存在
            Category category = categoryMapper.selectByPrimaryKey(param.getId());
            if (category == null) {
                throw new ExceptionCustomer(ApiBaseErrorCore.ADMIN_ROLE_NOT);
            }
            category.setUpdateTime(new Date());
            category.setImgUrl(param.getImgUrl());
            category.setName(param.getName());
            categoryMapper.updateByPrimaryKey(category);

        } else {
            //查询有没有同名的类目
            Category db_category = findCategoryByName(param.getName());
            if (db_category != null) {
                throw new ExceptionCustomer(ApiBaseErrorCore.CATEGORY_EXISTS);
            }
            Category category = Category.builder().name(param.getName()).status(ApiBaseConstants.CATEGORY_NORMAL_STATUS).imgUrl(param.getImgUrl()).
                    categoryNo(UUID.randomUUID().toString()).parentId(param.getParentId()).level(param.getLevel()).description(param.getDescription()).
                    createTime(new Date()).build();
            categoryMapper.insertSelective(category);
        }
    }

    /**
     * 根据分类名称查询分类
     *
     * @param categoryName
     * @return
     */
    @Override
    public Category findCategoryByName(String categoryName) {
        return categoryMapper.findCategoryByName(categoryName);
    }
}
