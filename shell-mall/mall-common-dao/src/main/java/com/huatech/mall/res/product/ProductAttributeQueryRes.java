package com.huatech.mall.res.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 商品属性类型响应类
 *
 * @author like
 * @date 2020-01-03 1:57 下午
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductAttributeQueryRes implements Serializable {

    private Long total;
    /**
     * 响应列表
     */
    private List<ProductAttributeList> attributeLists;
}