package com.huatech.mall.res.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * 商品类型返回响应
 *
 * @author like
 * @date 2019-12-31 11:17 上午
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductAttributeCategoryQueryRes implements Serializable {

    private Long total;
    private List<ProductAttributeCategoryList> attributes;
}