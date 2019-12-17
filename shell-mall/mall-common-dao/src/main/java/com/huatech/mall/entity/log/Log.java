package com.huatech.mall.entity.log;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 *  
 * 表:t_log 
 * @author like 
 * @date 2019-12-17 
 */
public class Log {
    /**
     * 主键标示
     * 表字段:id
     */
    private Long id;

    /**
     * 操作用户
     * 表字段:user_name
     */
    private String userName;

    /**
     * 请求uri
     * 表字段:uri
     */
    private String uri;

    /**
     * 操作资源
     * 表字段:operation
     */
    private String operation;

    /**
     * 请求ip
     * 表字段:ip
     */
    private String ip;

    /**
     * 请求入参
     * 表字段:input
     */
    private String input;

    /**
     * 请求出参
     * 表字段:output
     */
    private String output;

    /**
     * 响应时间
     * 表字段:response_time
     */
    private Long responseTime;

    /**
     * 响应结果
     * 表字段:status
     */
    private Integer status;

    /**
     * 创建时间
     * 表字段:create_time
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:dd",timezone = "GMT+8")
    private Date createTime;

    /**
     * 获取主键标示
     * @return id Long
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键标示
     * @param id 主键标示
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取操作用户
     * @return userName String
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置操作用户
     * @param userName 操作用户
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 获取请求uri
     * @return uri String
     */
    public String getUri() {
        return uri;
    }

    /**
     * 设置请求uri
     * @param uri 请求uri
     */
    public void setUri(String uri) {
        this.uri = uri == null ? null : uri.trim();
    }

    /**
     * 获取操作资源
     * @return operation String
     */
    public String getOperation() {
        return operation;
    }

    /**
     * 设置操作资源
     * @param operation 操作资源
     */
    public void setOperation(String operation) {
        this.operation = operation == null ? null : operation.trim();
    }

    /**
     * 获取请求ip
     * @return ip String
     */
    public String getIp() {
        return ip;
    }

    /**
     * 设置请求ip
     * @param ip 请求ip
     */
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    /**
     * 获取请求入参
     * @return input String
     */
    public String getInput() {
        return input;
    }

    /**
     * 设置请求入参
     * @param input 请求入参
     */
    public void setInput(String input) {
        this.input = input == null ? null : input.trim();
    }

    /**
     * 获取请求出参
     * @return output String
     */
    public String getOutput() {
        return output;
    }

    /**
     * 设置请求出参
     * @param output 请求出参
     */
    public void setOutput(String output) {
        this.output = output == null ? null : output.trim();
    }

    /**
     * 获取响应时间
     * @return responseTime Long
     */
    public Long getResponseTime() {
        return responseTime;
    }

    /**
     * 设置响应时间
     * @param responseTime 响应时间
     */
    public void setResponseTime(Long responseTime) {
        this.responseTime = responseTime;
    }

    /**
     * 获取响应结果
     * @return status Integer
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置响应结果
     * @param status 响应结果
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取创建时间
     * @return createTime Date
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}