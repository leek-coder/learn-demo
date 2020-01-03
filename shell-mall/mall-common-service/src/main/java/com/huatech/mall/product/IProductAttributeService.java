package com.huatech.mall.product;

import com.huatech.mall.common.service.IBaseService;
import com.huatech.mall.entity.product.ProductAttribute;
import com.huatech.mall.param.product.ProductAttributeParam;
import com.huatech.mall.param.product.ProductAttributeQueryParam;
import com.huatech.mall.res.product.ProductAttributeQueryRes;

import java.util.List;

/**
 * 商品属性service
 *
 * @author like
 * @date 2020-01-02 3:03 下午
 **/
public interface IProductAttributeService extends IBaseService<ProductAttribute, Long> {

    /**
     * 保存商品品牌数据
     *
     * @param productAttributeParam
     */
    void saveProductAttribute(ProductAttributeParam productAttributeParam);

    /**
     * 根据类型名称和商品类别id查询是否存在商品属性
     *
     * @param name
     * @param productCategoryId
     * @return
     */
    List<ProductAttribute> findProductAttributeByNameAndCategoryId(String name, Long productCategoryId);

    /**
     * 查询商品属性列表
     *
     * @param productAttributeQueryParam
     * @return
     */
    ProductAttributeQueryRes findProductAttributeLists(ProductAttributeQueryParam productAttributeQueryParam);
}