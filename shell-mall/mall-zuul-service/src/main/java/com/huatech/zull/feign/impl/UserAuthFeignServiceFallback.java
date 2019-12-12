package com.huatech.zull.feign.impl;

import com.huatech.zull.feign.IUserAuthFeignService;
import com.huatech.zull.utils.ResponseResult;
import org.springframework.stereotype.Component;

/**
 * @author like
 * @date 2019-12-12 10:09 上午
 **/
@Component
public class UserAuthFeignServiceFallback implements IUserAuthFeignService {
    @Override
    public ResponseResult parseToken(String token) {
        return ResponseResult.failure(-1, "调用远程服务失败");
    }
}