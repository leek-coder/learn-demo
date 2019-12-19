package com.huatech.mall.product;

import com.huatech.mall.common.service.IBaseService;
import com.huatech.mall.entity.product.Product;
import com.huatech.mall.param.product.ProductParam;
import com.huatech.mall.res.product.ProductQueryRes;

/**
 * 商品服务service
 *
 * @author like
 * @date 2019-11-30 2:09 下午
 **/
public interface IProductService extends IBaseService<Product, String> {

    /**
     * 保存或修改商品
     *
     * @param param
     */
    void saveOrUpdate(ProductParam param);

    /**
     * 查找商品列表
     *
     * @param param
     * @return
     */
    ProductQueryRes findProductList(ProductParam param);
}