package com.huatech.zull.fitler;

import com.huatech.zull.feign.IUserAuthFeignService;
import com.huatech.zull.utils.JsonUtils;
import com.huatech.zull.utils.ResponseResult;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 新建zuul拦截器
 *
 * @author like
 * @date 2019-12-02 7:47 下午
 **/
@Component
public class ZuulCustomerFilter extends ZuulFilter {
    private static final Logger logger = LoggerFactory.getLogger(ZuulCustomerFilter.class);

    @Value("${url.ignores}")
    private String urlIgnores;

    @Value("${token.header}")
    private String tokenHeader;

    @Autowired
    private IUserAuthFeignService userAuthFeignService;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String requestURI = request.getRequestURI();
        //过滤登陆接口，直接放行
        if (requestURI.contains(urlIgnores)) {
            return null;
        }
        // 从请求head中获得token
        String requestHeaderToken = request.getHeader(tokenHeader);
        logger.info("=====requestHeaderToken===" + requestHeaderToken);
        if (StringUtils.isBlank(requestHeaderToken)) {
            context.setSendZuulResponse(false);
            context.setResponseBody(JsonUtils.toString(ResponseResult.failure(4004, "token不能为空")));
            context.getResponse().setContentType("application/json; charset=utf-8");
            return null;
        }
        ResponseResult<JwtUser> responseResult = userAuthFeignService.parseToken(requestHeaderToken);
        if (responseResult.getCode() != 0 || responseResult.getData() == null) {
            context.setSendZuulResponse(false);
            context.setResponseBody(JsonUtils.toString(responseResult));
            context.getResponse().setContentType("application/json; charset=utf-8");
            return null;
        }
        context.addZuulRequestHeader(tokenHeader, requestHeaderToken);
        context.getRequest().setAttribute("userInfo", JsonUtils.toString(responseResult.getData()));
        return null;
    }
}