package com.huatech.mall.product;

import com.huatech.mall.common.service.IBaseService;
import com.huatech.mall.entity.product.ProductBrand;
import com.huatech.mall.param.product.ProductBrandParam;
import com.huatech.mall.param.product.ProductBrandQueryParam;
import com.huatech.mall.res.product.ProductBrandQueryRes;


/**
 * 商品品牌service
 *
 * @author like
 * @date 2019-12-30 1:57 下午
 **/
public interface IProductBrandService extends IBaseService<ProductBrand, Long> {
    /**
     * 保存商品品牌数据
     *
     * @param productBrandParam
     */
    void saveProductBrand(ProductBrandParam productBrandParam);

    /**
     * 根据商品品牌名称查询是否有该品牌
     *
     * @param name
     * @return
     */
    ProductBrand findProductBrandByName(String name);

    /**
     * 查询商品品类列表
     * @param  productBrandQueryParam
     * @return
     */
    ProductBrandQueryRes findProductBrandList(ProductBrandQueryParam productBrandQueryParam);
}