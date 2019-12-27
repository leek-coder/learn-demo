package com.huatech.mall.controller;

import com.huatech.mall.category.ICategoryService;
import com.huatech.mall.common.response.ResponseResult;
import com.huatech.mall.param.category.CategoryListParam;
import com.huatech.mall.param.category.CategoryParam;
import com.huatech.mall.res.category.CategoryQueryRes;
import com.huatech.mall.res.user.MenusRes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 系统商品分类控制器
 *
 * @author like
 * @date 2019-12-20 11:52 下午
 **/
@RestController
@RequestMapping(value = "/category")
@Slf4j
@Api(value = "商品分类管理", tags = "商品分类操作接口")
public class CategoryController {


    @Autowired
    private ICategoryService categoryService;


    @PostMapping("/save")
    @ApiOperation(value = "增加商品分类", notes = "增加商品分类")
    public ResponseResult save(@RequestBody CategoryParam param) {
        log.info("=====添加商品分类====");
        categoryService.saveCategory(param);
        return ResponseResult.success();
    }


    @GetMapping(value = "/tree/{level}")
    @ApiOperation(value = "获取分类树", notes = "获取分类树")
    public ResponseResult tree(@PathVariable("level") Integer level) {
        log.info("=========获取所有的分类树");
        List<MenusRes> categoryTree = categoryService.findCategoryTree(level);
        return ResponseResult.success(categoryTree);
    }


    @GetMapping(value = "/list")
    @ApiOperation(value = "获取分类列表", notes = "获取分类列表")
    public ResponseResult list(CategoryListParam categoryParam) {
        log.info("=========获取分类列表");
        CategoryQueryRes queryRes = categoryService.findCategoryList(categoryParam);
        return ResponseResult.success(queryRes);
    }
}