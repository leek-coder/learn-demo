package com.huatech.mall.controller;

import com.huatech.mall.common.response.ResponseResult;
import com.huatech.mall.entity.log.Log;
import com.huatech.mall.log.ILogService;
import com.huatech.mall.param.log.LogParam;
import com.huatech.mall.res.log.LogQueryRes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系统日志控制器类
 *
 * @author like
 * @date 2019-12-17 7:24 下午
 **/
@RestController
@RequestMapping(value = "/web/log")
@Slf4j
@Api(value = "web日志管理", tags = "web日志操作接口")
public class LogController {

    @Autowired
    private ILogService logService;

    @GetMapping(value = "/query")
    @ApiOperation(value = "查询日志列表", notes = "查询系统日志列表")
    public ResponseResult list(LogParam param) {
        log.info("=========查询日志列表:{}", param.toString());
        LogQueryRes logLists = logService.findLogLists(param);
        return ResponseResult.success(logLists);
    }

    @GetMapping(value = "/info/{id}")
    @ApiOperation(value = "查询日志详情", notes = "查询系统日志详情")
    public ResponseResult info(@PathVariable("id") Long id) {
        log.info("=========查询日志详情:{}", id);
        Log log = logService.find(id);
        return ResponseResult.success(log);
    }

}