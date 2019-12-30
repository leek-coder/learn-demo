package com.huatech.mall.res.product;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品品类数据返回
 *
 * @author like
 * @date 2019-12-30 4:35 下午
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductBrandList implements Serializable {

    /**
     * 品牌主键
     */
    private Long id;

    /**
     * 品牌名称
     */
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
    private String logo;

    /**
     * 专区大图
     * 表字段:big_pic
     */
    private String bigPic;

    /**
     * 品牌描述
     */
    private String description;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss ", timezone = "GMT+8")
    private Date createTime;

}