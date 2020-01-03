package com.huatech.mall.param.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 商品属性请求类
 *
 * @author like
 * @date 2020-01-02 2:51 下午
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductAttributeParam implements Serializable {


    private Long id;
    /**
     * 属性名称
     */
    @NotBlank(message = "属性名不能为空")
    private String name;

    /**
     * 商品类型id
     */
    @NotNull(message = "关联商品类型不能为空")
    private Long productAttributeCategoryId;

    /**
     * 属性是否可选
     */
    private Integer selectType;

    /**
     * 属性录入方式
     */
    private Integer inputType;

    /**
     * 属性值可选值列表
     */
    private String inputList;

    private Integer type;

    private Integer sort;

}