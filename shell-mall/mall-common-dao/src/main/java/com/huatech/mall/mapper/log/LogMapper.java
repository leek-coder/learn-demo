package com.huatech.mall.mapper.log;

import com.huatech.mall.common.mapper.IBaseMapper;
import com.huatech.mall.entity.log.Log;
import com.huatech.mall.param.log.LogParam;
import com.huatech.mall.res.log.LogList;

import java.util.List;

/**
 * 系统日志mapper
 *
 * @author like
 * @date 2019-12-17 7:26 下午
 **/
public interface LogMapper extends IBaseMapper<Log, Long> {

    /**
     * 查询系统日志列表
     *
     * @param logParam
     * @return
     */
    List<LogList> findLogLists(LogParam logParam);
}