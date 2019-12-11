package com.huatech.mall.service.impl;

import com.huatech.mall.dto.Token;
import com.huatech.mall.entity.JwtUser;
import com.huatech.mall.entity.user.User;
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

    /**
     * 创建token信息
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
        return jwtUtils.getUserFromToken(token);
    }


}
