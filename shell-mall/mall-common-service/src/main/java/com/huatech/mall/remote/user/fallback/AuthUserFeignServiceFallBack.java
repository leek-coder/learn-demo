package com.huatech.mall.remote.user.fallback;

import com.huatech.mall.common.enums.ApiBaseErrorCore;
import com.huatech.mall.common.response.ResponseResult;
import com.huatech.mall.remote.user.IAuthUserFeignService;
import org.springframework.stereotype.Component;

/**
 * 调用远程鉴权服务-熔断
 *
 * @author like
 * @date 2019-12-11 3:30 下午
 **/
@Component
public class AuthUserFeignServiceFallBack implements IAuthUserFeignService {
    @Override
    public ResponseResult createToken(String userJson) {
        return ResponseResult.failure(ApiBaseErrorCore.REMOTE_SERVICE_FAIL);
    }
}