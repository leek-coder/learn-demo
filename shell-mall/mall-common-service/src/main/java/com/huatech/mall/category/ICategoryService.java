package com.huatech.mall.category;

import com.huatech.mall.common.service.IBaseService;
import com.huatech.mall.entity.category.Category;
import com.huatech.mall.param.category.CategoryParam;


/**
 * @Author leek
 * @Date 2019-12-18 下午10:18
 * @Version 1.0
 * @Description
 */
public interface ICategoryService extends IBaseService<Category, Integer> {


    /**
     * 删除类目
     *
     * @param id
     */
    void deleteCategory(Integer id);


    /**
     * 添加类目
     *
     * @param param
     */
    public void saveCategory(CategoryParam param);

    /**
     * 根据名称查询类目
     *
     * @param categoryName
     * @return
     */
    public Category findCategoryByName(String categoryName);

}
