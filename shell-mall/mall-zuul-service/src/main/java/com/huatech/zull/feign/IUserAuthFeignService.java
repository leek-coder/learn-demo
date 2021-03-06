package com.huatech.zull.feign;

import com.huatech.zull.feign.impl.UserAuthFeignServiceFallback;
import com.huatech.zull.utils.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 调用远程用户鉴权服务
 *
 * @author like
 * @date 2019-12-11 11:41 上午
 **/
@FeignClient(name = "user-auth-service", fallback = UserAuthFeignServiceFallback.class)
public interface IUserAuthFeignService {


    /**
     * 验证token合法性
     *
     * @param token
     * @return
     */
    @GetMapping(value = "/token/parse")
    ResponseResult parseToken(@RequestParam("token") String token);

}