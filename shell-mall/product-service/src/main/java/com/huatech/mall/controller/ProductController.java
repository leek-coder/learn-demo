package com.huatech.mall.controller;

import com.huatech.mall.common.response.ResponseResult;
import com.huatech.mall.param.product.ProductParam;
import com.huatech.mall.product.IProductService;
import com.huatech.mall.res.product.ProductQueryRes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 商品控制器类
 *
 * @author like
 * @date 2019-11-30 2:15 下午
 **/
@RestController
@RequestMapping(value = "/product")
@Slf4j
@Api(value = "商品管理", tags = "商品操作接口")
public class ProductController {

    @Autowired
    private IProductService productService;


    @GetMapping(value = "/list")
    @ApiOperation(value = "查询商品列表", notes = "查询商品列表")
    public ResponseResult bannerList(ProductParam param) {
        ProductQueryRes product = productService.findProductList(param);
        return ResponseResult.success(product);
    }

}