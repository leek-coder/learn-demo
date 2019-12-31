package com.huatech.mall.mapper.product;


import com.huatech.mall.common.mapper.IBaseMapper;
import com.huatech.mall.entity.product.ProductAttributeCategory;
import com.huatech.mall.res.product.ProductAttributeCategoryList;

import java.util.List;

/**
 * @author  like
 */
public interface ProductAttributeCategoryMapper extends IBaseMapper<ProductAttributeCategory,Long> {

    /**
     *
     * * 根据商品类型名称查询是否有该类型
     * *
     * * @param name
     * * @return
     */
    ProductAttributeCategory findProductAttributeCategoryByName(String name);

    /**
     * 查询商品类型列表
     * @return
     */
    List<ProductAttributeCategoryList> findProductAttributeCategorys();
}