package com.huatech.mall.controller.upload;

import com.huatech.mall.common.response.ResponseResult;
import com.huatech.mall.config.FastDFSClientWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

/**
 * 图片上传控制器
 *
 * @author like
 * @date 2019-12-19 7:57 下午
 **/
@RestController
@RequestMapping(value = "/pic")
@Slf4j
public class PicUploadController {

    @Autowired
    private FastDFSClientWrapper clientWrapper;

    @PostMapping(value = "/upload")
    @ResponseBody
    public ResponseResult productUpload(MultipartFile file) {
        Map<String, String> map = null;
        if (file != null) {
            try {
                map = clientWrapper.uploadFile(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ResponseResult.success(map);
    }

}