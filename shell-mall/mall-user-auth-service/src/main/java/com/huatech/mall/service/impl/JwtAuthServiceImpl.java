package com.huatech.mall.service.impl;

import com.huatech.mall.dto.Token;
import com.huatech.mall.entity.JwtUser;
import com.huatech.mall.service.IJwtAuthService;
import com.huatech.mall.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

//    @Override
//    public Token createToken(Long userId, String openId, String cardNum, String unionId) {
//        JwtUser jwtUser = JwtUser.builder().userId(userId).openId(openId).cardNum(cardNum).unionId(unionId).build();
//        Token token = jwtUtils.createToken(jwtUser);
//        return token;
//    }


}
