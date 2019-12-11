package com.huatech.mall.remote.user;

import com.huatech.mall.common.response.ResponseResult;
import com.huatech.mall.remote.user.fallback.AuthUserFeignServiceFallBack;
import com.huatech.mall.token.Token;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 调用远程鉴权服务
 *
 * @author like
 * @date 2019-12-11 3:29 下午
 **/
@FeignClient(name = "user-auth-service", fallback = AuthUserFeignServiceFallBack.class)
public interface IAuthUserFeignService {


    /**
     * 调用远程服务生成token
     *
     * @param userJson
     * @return
     */
    @PostMapping(value = "/token/create", consumes = "application/json")
    ResponseResult<Token> createToken(@RequestBody String userJson);


}