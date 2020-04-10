package com.huatech.mall.controller;

import com.huatech.mall.common.response.ResponseResult;
import com.huatech.mall.param.product.ProductAttributeCategoryParam;
import com.huatech.mall.param.product.ProductAttributeParam;
import com.huatech.mall.param.product.ProductAttributeQueryParam;
import com.huatech.mall.param.product.ProductParam;
import com.huatech.mall.product.IProductAttributeCategoryService;
import com.huatech.mall.product.IProductAttributeService;
import com.huatech.mall.product.IProductService;
import com.huatech.mall.res.product.ProductAttributeCategoryList;
import com.huatech.mall.res.product.ProductAttributeCategoryQueryRes;
import com.huatech.mall.res.product.ProductAttributeQueryRes;
import com.huatech.mall.res.product.ProductQueryRes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @Autowired
    private IProductAttributeCategoryService productAttributeCategoryService;

    @Autowired
    private IProductAttributeService productAttributeService;

    @GetMapping(value = "/list")
    @ApiOperation(value = "查询商品列表", notes = "查询商品列表")
    public ResponseResult bannerList(ProductParam param) {
        ProductQueryRes product = productService.findProductList(param);
        return ResponseResult.success(product);
    }


    @PostMapping("/type/save")
    @ApiOperation(value = "增加商品类型", notes = "增加商品类型")
    public ResponseResult saveType(@RequestBody ProductAttributeCategoryParam productAttributeCategoryParam) {
        log.info("=====增加商品类型====");
        productAttributeCategoryService.saveProductAttributeCategory(productAttributeCategoryParam);
        return ResponseResult.success();
    }


    @GetMapping(value = "/type/list")
    @ApiOperation(value = "分页查询商品类型列表", notes = "分页查询商品类型列表")
    public ResponseResult attributeList(ProductAttributeCategoryParam productAttributeCategoryParam) {
        log.info("=====分页查询商品类型列表====");
        ProductAttributeCategoryQueryRes queryRes = productAttributeCategoryService.findProductAttributeList(productAttributeCategoryParam);
        return ResponseResult.success(queryRes);
    }

    @GetMapping(value = "/type/select/list")
    @ApiOperation(value = "查询商品类型列表", notes = "查询商品类型列表")
    public ResponseResult attributeSelectList() {
        log.info("=====查询商品类型列表====");
        List<ProductAttributeCategoryList> categoryLists = productAttributeCategoryService.queryProductAttributeList();
        return ResponseResult.success(categoryLists);
    }

    @PostMapping(value = "/attribute/save")
    @ApiOperation(value = "查询商品类型列表", notes = "查询商品类型列表")
    public ResponseResult attributeSave(@RequestBody ProductAttributeParam productAttributeParam) {
        log.info("=====保存商品类型属性====");
        productAttributeService.saveProductAttribute(productAttributeParam);
        return ResponseResult.success();
    }


    @GetMapping(value = "/attribute/list")
    @ApiOperation(value = "查询商品属性列表", notes = "查询商品属性列表")
    public ResponseResult attributeList(ProductAttributeQueryParam productAttributeQueryParam) {
        ProductAttributeQueryRes queryRes = productAttributeService.findProductAttributeLists(productAttributeQueryParam);
        return ResponseResult.success(queryRes);
    }


    /**
     * 测试提交
     *
     * @return
     */
    @GetMapping(value = "/demo01")
    public ResponseResult demo1() {
        log.info("demo01");
        return ResponseResult.success("demo1");
    }


    /**
     * 测试提交02
     *
     * @return
     */
    @GetMapping(value = "/demo02")
    public ResponseResult demo2() {
        log.info("java");
        log.info("我是leek");
        log.info("demo02");
        log.info("lisi");
        log.info("测试冲突0002");
        return ResponseResult.success("demo2");
    }


}