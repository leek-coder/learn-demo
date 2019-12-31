package com.huatech.mall.res.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * 商品分类响应实体
 *
 * @author like
 * @date 2019-12-31 11:14 上午
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductAttributeCategoryList implements Serializable {
    /**
     * 商品类型id
     */
    private Long id;
    /**
     * 名称
     */
    private String name;

    /**
     * 属性数量
     */
    private Integer attributeCount;


    /**
     * 参数数量
     */
    private Integer paramCount;
}