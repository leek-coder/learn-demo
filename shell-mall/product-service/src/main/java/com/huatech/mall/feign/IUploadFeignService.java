package com.huatech.mall.feign;

import com.huatech.mall.common.response.ResponseResult;
import com.huatech.mall.feign.fallback.UploadFeignFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * 图片远程调用feign
 *
 * @author like
 * @date 2019-12-19 8:34 下午
 **/
@FeignClient(value = "user-auth-service", fallback = UploadFeignFallBack.class)
public interface IUploadFeignService {

    /**
     * 调用远程图片服务
     *
     * @param file
     * @return
     */
    @RequestMapping(value = "/pic/upload", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ResponseResult uploadFile(@RequestPart("file") MultipartFile file);
}