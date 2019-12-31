package com.huatech.mall.product;

import com.huatech.mall.common.service.IBaseService;
import com.huatech.mall.entity.product.ProductAttributeCategory;
import com.huatech.mall.param.product.ProductAttributeCategoryParam;
import com.huatech.mall.res.product.ProductAttributeCategoryList;
import com.huatech.mall.res.product.ProductAttributeCategoryQueryRes;

import java.util.List;

/**
 * 商品类型service
 *
 * @author like
 * @date 2019-12-31 10:48 上午
 **/
public interface IProductAttributeCategoryService extends IBaseService<ProductAttributeCategory, Long> {

    /**
     * 保存商品类型数据
     *
     * @param productAttributeCategoryParam
     */
    void saveProductAttributeCategory(ProductAttributeCategoryParam productAttributeCategoryParam);

    /**
     * /**
     * * 根据商品类型名称查询是否有该类型
     * *
     * * @param name
     * * @return
     */
    ProductAttributeCategory findProductAttributeCategoryByName(String name);

    /**
     * 分页查询商品类型列表
     *
     * @param productAttributeCategoryParam
     * @return
     */
    ProductAttributeCategoryQueryRes findProductAttributeList(ProductAttributeCategoryParam productAttributeCategoryParam);

    /**
     * 查询商品类型列表
     * @return
     */
    List<ProductAttributeCategoryList> queryProductAttributeList();
}