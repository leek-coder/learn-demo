//package com.huatech.mall.aspect;
//
//import com.alibaba.fastjson.JSON;
//import com.huatech.mall.common.exception.ExceptionCustomer;
//import com.huatech.mall.common.jwt.JwtUser;
//import com.huatech.mall.common.jwt.JwtUtils;
//import com.huatech.mall.common.response.ResponseResult;
//import com.huatech.mall.common.utils.IpUtils;
//import com.huatech.mall.common.utils.JsonUtils;
//import com.huatech.mall.entity.log.Log;
//import com.huatech.mall.mapper.log.LogMapper;
//import com.huatech.mall.param.user.LoginParam;
//import io.swagger.annotations.ApiOperation;
//import org.apache.commons.lang3.StringUtils;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//import java.lang.reflect.Method;
//import java.util.Date;
//import java.util.Objects;
//
///**
// * 控制器切面
// * 定义切面用于日志统计
// *
// * @author like
// * @date 2019-11-29 9:40 下午
// **/
//@Aspect
//@Component
//public class ControllerAspect {
//
//    public static final Logger logger = LoggerFactory.getLogger(ControllerAspect.class);
//    private static final String LOGIN_URL = "user/login";
//
//    @Autowired
//    private LogMapper logMapper;
//
//    @Autowired
//    private JwtUtils jwtUtils;
//
//    @Pointcut(value = "execution(* com.huatech.mall.controller.*.*(..)) && !execution(* com.huatech.mall.controller.LogController.*(..))")
//    public void pointCut() {
//    }
//
//    @Around(value = "pointCut()")
//    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
//        Object[] args = pjp.getArgs();
//        String param = (null != args && args.length > 0) ? args[0].toString() : null;
//        logger.info("anyAPi接口请求参数:{}", param);
//        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
//        //用户访问uri地址
//        String uri = request.getRequestURI();
//        String queryString = request.getQueryString();
//        String userName = "";
//        if (uri.contains(LOGIN_URL)) {
//            //用户登陆
//            LoginParam loginParam = (LoginParam) args[0];
//            userName = loginParam.getUserName();
//        } else {
//            //从header中获取操作用户
//            String requestHeaderToken = request.getHeader("Authorization");
//            if (StringUtils.isNotBlank(requestHeaderToken)) {
//                JwtUser userFromToken = jwtUtils.getUserFromToken(requestHeaderToken);
//                userName = userFromToken.getUserName();
//            }
//        }
//        //用户的ip地址
//        String ipAddress = IpUtils.getIpAddress(request);
//        logger.info("uri=={},=====ipAddress={},", uri, ipAddress);
//        MethodSignature signature = (MethodSignature) pjp.getSignature();
//        Method method = signature.getMethod();
//        ApiOperation apiOperation = method.getAnnotation(ApiOperation.class);
//        //获取访问的资源接口描述
//        String value = apiOperation.value();
//        Long startTime = System.currentTimeMillis();
//        logger.info("执行开始时间为:{}", startTime);
//        //执行该方法
//        ResponseResult responseResult = null;
//        try {
//            responseResult = (ResponseResult) pjp.proceed();
//        } catch (Exception e) {
//            if (e instanceof ExceptionCustomer) {
//                ExceptionCustomer customer = (ExceptionCustomer) e;
//                responseResult = ResponseResult.failure(customer.getCode(), customer.getMessage());
//            }
//        }
//        Long endTime = System.currentTimeMillis();
//        logger.info("执行结束时间为:{}", endTime);
//        logger.info("anyAPi接口响应参数:{}", responseResult.toString());
//        Log log = new Log();
//        //ip地址
//        log.setIp(ipAddress);
//        //请求uri路径
//        log.setUri(uri);
//        //资源描述
//        log.setOperation(value);
//        //操作人
//        log.setUserName(userName);
//        //入参
//        log.setInput(JSON.toJSONString(queryString != null ? queryString : param));
//        //出参
//        log.setOutput(JsonUtils.toString(responseResult));
//        //响应时间
//        log.setResponseTime((endTime - startTime));
//        //响应结果
//        log.setStatus(responseResult.getCode());
//        //创建时间
//        log.setCreateTime(new Date());
//        //插入日志数据
//        logMapper.insert(log);
//        return responseResult;
//    }
//
//
//}
