package com.huatech.mall.mapper.category;

import com.huatech.mall.common.mapper.IBaseMapper;
import com.huatech.mall.entity.category.Category;
import com.huatech.mall.param.category.CategoryListParam;
import com.huatech.mall.res.category.CategoryList;
import com.huatech.mall.res.category.CategoryQuery;

import java.util.List;

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

    /**
     * 获取所有未删除的分类列表
     * @param level
     * @return
     */
    List<CategoryList> findCategoryList(Integer level);

    /**
     * 分页查询所有分类数据
     * @param categoryParam
     * @return
     */
    List<CategoryQuery> findCategoryListByPage(CategoryListParam categoryParam);
}