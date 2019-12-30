package com.huatech.mall.param.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 商品品牌请求参数
 *
 * @author like
 * @date 2019-12-30 2:02 下午
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductBrandParam implements Serializable {


    /**
     * 品牌主键
     * 表字段:id
     */
    private Long id;

    /**
     * 品牌名称
     */
    @NotBlank(message = "品牌名称不为空")
    private String name;

    /**
     * 品牌首字母
     */
    private String firstLetter;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 状态0： 显示1:不显示
     */
    private String status;

    /**
     * 品牌logo
     */
    @NotBlank(message = "品牌logo不为空")
    private String logo;

    /**
     * 专区大图
     */
    private String bigPic;

    /**
     * 品牌描述
     */
    private String description;
}