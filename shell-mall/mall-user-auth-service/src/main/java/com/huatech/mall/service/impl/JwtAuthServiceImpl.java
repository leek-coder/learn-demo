package com.huatech.mall.service.impl;

import com.huatech.mall.common.enums.ApiBaseErrorCore;
import com.huatech.mall.common.exception.ExceptionCustomer;
import com.huatech.mall.common.jwt.JwtUser;
import com.huatech.mall.common.jwt.JwtUtils;
import com.huatech.mall.common.jwt.Token;
import com.huatech.mall.common.utils.ICacheService;
import com.huatech.mall.entity.user.User;
import com.huatech.mall.service.IJwtAuthService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @ClassName JwtAuthServiceImpl
 * @Description TODO
 * @Author like
 * @Date 2019-07-31 13:18
 * @Version 1.0
 **/
@Service
public class JwtAuthServiceImpl implements IJwtAuthService {


    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private ICacheService cacheService;

    @Value("${redis.token.prefix}")
    private String token_user;

    /**
     * 创建token信息
     *
     * @param user
     * @return
     */
    @Override
    public Token createToken(User user) {
        JwtUser jwtUser = JwtUser.builder().id(user.getId()).userName(user.getUserName()).nickName(user.getNickName()).build();
        Token token = jwtUtils.createToken(jwtUser);
        return token;
    }

    @Override
    public JwtUser parseToken(String token) {
        JwtUser user = jwtUtils.getUserFromToken(token);
        //从redis中查看用户是否存在
        String tokenStr = cacheService.get(token_user + user.getId());
        if (StringUtils.isBlank(tokenStr)) {
            //token已经过期
            throw new ExceptionCustomer(ApiBaseErrorCore.TOKEN_IS_EXPIRED);
        }
        //
        if (!token.equals(tokenStr)) {
            //token不合法
            throw new ExceptionCustomer(ApiBaseErrorCore.TOKEN_IS_VALID);
        }
        return user;
    }


}
