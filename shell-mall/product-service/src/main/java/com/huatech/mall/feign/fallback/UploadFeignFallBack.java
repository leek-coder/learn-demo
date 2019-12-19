package com.huatech.mall.feign.fallback;

import com.huatech.mall.common.response.ResponseResult;
import com.huatech.mall.feign.IUploadFeignService;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * 远程调用熔断
 *
 * @author like
 * @date 2019-12-19 8:35 下午
 **/
@Component
public class UploadFeignFallBack implements IUploadFeignService {
    @Override
    public ResponseResult uploadFile(MultipartFile file) {
        return ResponseResult.failure(-1, "调用远程图片服务器失败");
    }
}