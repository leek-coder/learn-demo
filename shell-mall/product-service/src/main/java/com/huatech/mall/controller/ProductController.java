package com.huatech.mall.controller;

import com.huatech.mall.address.IAddressService;
import com.huatech.mall.common.response.ResponseResult;
import com.huatech.mall.entity.address.Address;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 商品控制器类
 *
 * @author like
 * @date 2019-11-30 2:15 下午
 **/
@RestController
@RequestMapping(value = "/product")
@RefreshScope
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private IAddressService addressService;


    @RequestMapping(value = "/list")
    public ResponseResult<Address> findAddress() {

        Address address = addressService.find(12L);
        return ResponseResult.success(address);
    }


}