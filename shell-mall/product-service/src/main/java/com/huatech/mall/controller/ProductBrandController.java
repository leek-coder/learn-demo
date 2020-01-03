package com.huatech.mall.controller;

import com.huatech.mall.common.response.ResponseResult;
import com.huatech.mall.param.product.ProductBrandParam;
import com.huatech.mall.param.product.ProductBrandQueryParam;
import com.huatech.mall.product.IProductBrandService;
import com.huatech.mall.res.product.ProductBrandQueryRes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 商品品牌管理
 *
 * @author like
 * @date 2019-12-30 1:53 下午
 **/
@RestController
@RequestMapping(value = "/product/brand")
@Slf4j
@Api(value = "商品品牌管理", tags = "商品品牌操作接口")
public class ProductBrandController {


   @Autowired
    private IProductBrandService productBrandService;

    @PostMapping("/save")
    @ApiOperation(value = "增加商品分类", notes = "增加商品分类")
    public ResponseResult save(@RequestBody ProductBrandParam productBrandParam) {
        log.info("=====添加商品分类====");
        productBrandService.saveProductBrand(productBrandParam);
        return ResponseResult.success();
    }


    @GetMapping("/list")
    @ApiOperation(value = "商品分类列表", notes = "商品分类列表")
    public ResponseResult list(ProductBrandQueryParam productBrandQueryParam) {
        log.info("=====商品分类列表====");
        ProductBrandQueryRes queryRes = productBrandService.findProductBrandList(productBrandQueryParam);
        return ResponseResult.success(queryRes);
    }

}