package com.huatech.mall.mapper.product;


import com.huatech.mall.common.mapper.IBaseMapper;
import com.huatech.mall.entity.product.ProductBrand;
import com.huatech.mall.res.product.ProductBrandList;

import java.util.List;

/**
 * @author  like
 */
public interface ProductBrandMapper  extends IBaseMapper<ProductBrand,Long> {

    /**
     * 根据商品品牌名称查询是否有该品牌
     * @param name
     * @return
     */
    ProductBrand findProductBrandByName(String name);

    /**
     * 查询所有商品品类
     * @return
     */
    List<ProductBrandList> findProductBrandList();
}