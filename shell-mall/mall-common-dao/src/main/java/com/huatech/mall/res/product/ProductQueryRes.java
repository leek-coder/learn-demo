package com.huatech.mall.res.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * 商品列表返回响应
 *
 * @author like
 * @date 2019-12-19 8:56 下午
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductQueryRes implements Serializable {

    private Long total;
    private List<ProductList> products;
}