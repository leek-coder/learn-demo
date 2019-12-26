package com.huatech.mall.mapper.category;

import com.huatech.mall.common.mapper.IBaseMapper;
import com.huatech.mall.entity.category.Category;

/**
 * 商品分类mapper
 *
 * @author like
 * @date 2019-12-17 7:26 下午
 **/
public interface CategoryMapper extends IBaseMapper<Category, Integer> {

    /**
     * 根据分类名称查询分类信息
     * @param categoryName
     * @return
     */
    Category findCategoryByName(String categoryName);
}