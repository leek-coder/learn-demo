package com.huatech.mall.param.product;

import com.huatech.mall.common.base.BaseParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 商品类型请求参数
 *
 * @author like
 * @date 2019-12-31 10:51 上午
 **/
@Data
@AllArgsConstructor
@Builder
@ToString
public class ProductAttributeCategoryParam extends BaseParam {

    /**
     * 商品类型名称
     */
    private String name;
    /**
     * 商品类型主键
     */
    private Long id;
}
