package com.huatech.mall.controller;

import com.huatech.mall.common.response.ResponseResult;
import com.huatech.mall.feign.IUploadFeignService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 上传控制器
 *
 * @author like
 * @date 2019-12-30 1:48 下午
 **/
@RestController
@RequestMapping(value = "/upload")
@Slf4j
@Api(value = "图片上传", tags = "图片上传接口")
public class UploadController {

    @Autowired
    private IUploadFeignService uploadFeignService;

    @PostMapping(value = "/pic")
    @ApiOperation(value = "图片上传", notes = "图片上传")
    public ResponseResult productUpload(MultipartFile file) {
        log.info("======图片上传开始=======");
        ResponseResult responseResult = uploadFeignService.uploadFile(file);
        return responseResult;
    }
}