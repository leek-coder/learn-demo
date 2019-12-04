package com.huatech.zull.fitler;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

        logger.info("=====run======");
        return null;
    }
}