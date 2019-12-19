package com.huatech.mall.res.product;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author leek
 * @Date 2019-12-01 下午3:04
 * @Version 1.0
 * @Description
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductList implements Serializable {
    /**
     * 商品主键
     */
    private String productId;
    /**
     * 所属商品分类
     */
    private String categoryNo;
    /**
     * 所属分类名称
     */
    private String categoryName;
    /**
     * 商品标记图
     */
    private String productImage;
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 商品上架状态  1已上架 2 已下架 3未上架
     */
    private Integer productStatus;
    /**
     * 库存
     */
    private Integer productStock;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss ", timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss ", timezone = "GMT+8")
    private Date updateTime;
    private String productDescription;
    private Date productStartTime;
    private Date productEndTime;
    private Integer productSalesType;
    /**
     * 是否推荐 0：否 1：是
     */
    private Integer productIfRecommend;
    private Double productNowPrice;
    private String productNowPriceDescription;
    private Double productOriginalPrice;
    /**
     * 已售数量
     */
    private Integer productSoldNum;
    /**
     * 商品简介
     */
    private String productSummary;
    /**
     * 是否是否可以开发票
     */
    private Integer productIfCanInvoice;
    private Integer productGoodsType;
    private String productUpdateUser;
    private String productCreateUser;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss ", timezone = "GMT+8")
    /**
     * 推荐商品结束时间
     */
    private Date productCommendStartTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss ", timezone = "GMT+8")
    private Date productCommendEndTime;


}
