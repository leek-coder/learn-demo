package com.huatech.mall.common.base;

import com.huatech.mall.common.jwt.JwtUser;
import com.huatech.mall.common.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author leek
 * @Date 2019-10-25 上午9:58
 * @Version 1.0
 * @Description
 */
public class BaseController {
    @Autowired
    protected HttpServletResponse response;

    @Autowired
    private JwtUtils jwtUtils;

    /**
     * 获取用户userId
     *
     * @param request
     * @return
     */
    public JwtUser getUserInfo(HttpServletRequest request) {
        //从请求header中获取token
        String header = request.getHeader("Authorization");
        JwtUser jwtUser = jwtUtils.getUserFromToken(header);
        return jwtUser;
    }
}
