package com.huatech.mall.res.log;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Date;

/**
 * 系统日志返回类
 *
 * @author like
 * @date 2019-12-17 7:47 下午
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LogList implements Serializable {
    private Long id;
    private String userName;
    private String uri;
    private String operation;
    private String ip;
    private Long responseTime;
    private Long status;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:dd",timezone = "GMT+8")
    private Date createTime;


}