package com.huatech.mall.param.product;

import com.huatech.mall.common.base.BaseParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author leek
 * @Date 2019-12-18 下午3:04
 * @Version 1.0
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductParam extends BaseParam {

    private String productId;
    @NotBlank(message = "商品分类不能为空")
    /**
     * 所属商品分类
     */
    private String categoryNo;
    @NotBlank(message = "商品图片不能为空")
    /**
     * 商品标记图
     */
    private String productImage;
    @NotBlank(message = "商品名称不能为空")
    /**
     * 商品名称
     */
    private String productName;
    @NotNull(message = "商品上架状态不能为空")
    /**
     * 商品上架状态  1已上架 2 已下架 3未上架
     */
    private Integer productStatus;
    @NotNull(message = "商品库存不能为空")
    @Min(value = 1, message = "库存最小值为1")
    /**
     * 商品库存
     */
    private Integer productStock;
    /**
     * 商品描述
     */
    private String productDescription;
    @NotNull(message = "商品销售渠道不能为空")
    private Integer productSalesType;
    @NotNull(message = "商品推荐不能为空")
    /**
     * 是否推荐 0：否 1：是
     */
    private Integer productIfRecommend;
    @NotNull(message = "商品现价不能为空")
    private Double productNowPrice;
    private String productNowPriceDescription;
    @NotNull(message = "商品元价不能为空")
    @Min(value = 1, message = "原价最小值为1")
    private Double productOriginalPrice;
    /**
     * 商品简介
     */
    private String productSummary;
    @NotNull(message = "商品类型不能为空")
    private Integer productGoodsType;
    /**
     * 推荐商品结束时间
     */
    private String productCommendStartTime;

    private String productCommendEndTime;

    private String productCreateUser;

    /**
     * 是否能开发票
     */
    private Integer productIfCanInvoice;
}
