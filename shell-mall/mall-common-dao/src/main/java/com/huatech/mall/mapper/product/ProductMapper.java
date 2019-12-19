package com.huatech.mall.mapper.product;

import com.huatech.mall.common.mapper.IBaseMapper;
import com.huatech.mall.entity.product.Product;
import com.huatech.mall.param.product.ProductParam;
import com.huatech.mall.res.product.ProductList;

import java.util.List;

/**
 * @author like
 */
public interface ProductMapper extends IBaseMapper<Product, String> {

    /**
     * 查询所有商品列表
     *
     * @param param
     * @return
     */
    List<ProductList> findProductList(ProductParam param);
}