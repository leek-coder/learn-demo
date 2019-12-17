package com.huatech.mall.log.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huatech.mall.common.mapper.IBaseMapper;
import com.huatech.mall.common.service.impl.BaseServiceImpl;
import com.huatech.mall.entity.log.Log;
import com.huatech.mall.log.ILogService;
import com.huatech.mall.mapper.log.LogMapper;
import com.huatech.mall.param.log.LogParam;
import com.huatech.mall.res.log.LogList;
import com.huatech.mall.res.log.LogQueryRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 系统日志实现类
 *
 * @author like
 * @date 2019-12-17 7:26 下午
 **/
@Service
public class LogServiceImpl extends BaseServiceImpl<Log, Long> implements ILogService {

    @Autowired
    private LogMapper logMapper;

    @Override
    public IBaseMapper<Log, Long> getBaseMapper() {
        return this.logMapper;
    }


    @Override
    public LogQueryRes findLogLists(LogParam logParam) {
        PageHelper.startPage(logParam.getPage(), logParam.getSize());
        List<LogList> logLists = logMapper.findLogLists(logParam);
        PageInfo<LogList> pageInfo = new PageInfo<>(logLists);
        return new LogQueryRes(pageInfo.getTotal(),pageInfo.getList());
    }
}