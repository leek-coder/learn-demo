package com.huatech.mall.controller.auth;

import com.huatech.mall.common.jwt.JwtUser;
import com.huatech.mall.common.jwt.Token;
import com.huatech.mall.common.response.ResponseResult;
import com.huatech.mall.entity.user.User;
import com.huatech.mall.service.IJwtAuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 用户鉴权控制类
 *
 * @author like
 * @date 2019-12-11 11:11 上午
 **/
@RestController
@RequestMapping(value = "/token")
@Slf4j
public class AuthUserController {

    @Autowired
    private IJwtAuthService jwtAuthService;

    /**
     * 根据用户信息生成token
     *
     * @param user
     * @return
     */
    @PostMapping(value = "/create")
    public ResponseResult<Token> createToken(@Valid @RequestBody User user) {
        Token token = jwtAuthService.createToken(user);
        return ResponseResult.success(token);
    }

    /**
     * 解析token中的用户
     *
     * @param token
     * @return
     */
    @GetMapping(value = "/parse")
    public ResponseResult<JwtUser> parseToken(String token) {
        JwtUser jwtUser = jwtAuthService.parseToken(token);
        return ResponseResult.success(jwtUser);
    }
}