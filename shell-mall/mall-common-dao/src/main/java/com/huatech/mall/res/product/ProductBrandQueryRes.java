package com.huatech.mall.res.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 商品品类组装数据返回
 *
 * @author like
 * @date 2019-12-30 4:36 下午
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductBrandQueryRes implements Serializable {

    private Long total;
    private List<ProductBrandList> productBrands;
}