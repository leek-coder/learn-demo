package com.huatech.mall.res.log;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * 系统日志响应类
 *
 * @author like
 * @date 2019-12-17 7:47 下午
 **/
@Data
@ToString
@AllArgsConstructor
public class LogQueryRes implements Serializable {

    private Long total;
    private List<LogList> logLists;


}