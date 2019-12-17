package com.huatech.mall.log;

import com.huatech.mall.common.service.IBaseService;
import com.huatech.mall.entity.log.Log;
import com.huatech.mall.param.log.LogParam;
import com.huatech.mall.res.log.LogQueryRes;

/**
 * 系统日志service
 *
 * @author like
 * @date 2019-12-17 7:26 下午
 **/
public interface ILogService extends IBaseService<Log,Long> {
    /**
     * 查询日志列表
     *
     * @param logParam
     * @return
     */
    LogQueryRes findLogLists(LogParam logParam);
}