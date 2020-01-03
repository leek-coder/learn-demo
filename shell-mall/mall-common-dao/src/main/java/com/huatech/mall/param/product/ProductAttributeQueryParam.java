package com.huatech.mall.param.product;

import com.huatech.mall.common.base.BaseParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 商品分类类型查询请求类
 *
 * @author like
 * @date 2020-01-03 1:51 下午
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductAttributeQueryParam extends BaseParam {

    private Integer type;
    private Long productCategoryId;
}