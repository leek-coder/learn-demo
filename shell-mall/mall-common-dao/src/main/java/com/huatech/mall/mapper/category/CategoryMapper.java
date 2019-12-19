package com.huatech.mall.mapper.category;

import com.huatech.mall.entity.category.Category;

public interface CategoryMapper {
    /**
     * 根据主键删除 
     * @param id Integer
     * @return int
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存
     * @param record Category
     * @return int
     */
    int insert(Category record);

    /**
     * 根据字段是否为空保存 
     * @param record Category
     * @return int
     */
    int insertSelective(Category record);

    /**
     * 根据主键查询 
     * @param id Integer
     * @return Category
     */
    Category selectByPrimaryKey(Integer id);

    /**
     * 根据字段是否为空更新 
     * @param record Category
     * @return int
     */
    int updateByPrimaryKeySelective(Category record);

    /**
     * 根据主键更新所有字段 
     * @param record Category
     * @return int
     */
    int updateByPrimaryKey(Category record);
}