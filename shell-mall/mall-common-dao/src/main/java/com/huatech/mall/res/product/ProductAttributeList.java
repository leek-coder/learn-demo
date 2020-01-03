package com.huatech.mall.res.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 商品分类数据
 *
 * @author like
 * @date 2020-01-03 1:53 下午
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductAttributeList implements Serializable {

    private String name;
    /**
     * 商品类型
     */
    private String productCategoryName;

    /**
     * 属性是否多选
     */
    private Integer selectType;

    /**
     * 属性值录入方式
     */
    private Integer inputType;

    /**
     * 可选值列表
     */
    private String inputList;

    /**
     * 排序
     */
    private Integer sort;


}