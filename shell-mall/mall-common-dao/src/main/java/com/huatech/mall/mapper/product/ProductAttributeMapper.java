package com.huatech.mall.mapper.product;

import com.huatech.mall.common.mapper.IBaseMapper;
import com.huatech.mall.entity.product.ProductAttribute;
import com.huatech.mall.param.product.ProductAttributeQueryParam;
import com.huatech.mall.res.product.ProductAttributeList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author like
 */
public interface ProductAttributeMapper extends IBaseMapper<ProductAttribute, Long> {

    /**
     * 根据类型名称和商品类别id查询是否存在商品属性
     *
     * @param name
     * @param productCategoryId
     * @return
     */
    List<ProductAttribute> findProductAttributeByNameAndCategoryId(@Param("name") String name, @Param("productAttributeCategoryId") Long productCategoryId);

    /**
     * 查询商品属性列表
     *
     * @param productAttributeQueryParam
     * @return
     */
    List<ProductAttributeList> findProductAttributeLists(ProductAttributeQueryParam productAttributeQueryParam);
}