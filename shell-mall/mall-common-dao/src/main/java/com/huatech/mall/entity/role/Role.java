package com.huatech.mall.entity.role;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 *  
 * 表:t_role 
 * @author like 
 * @date 2019-12-04 
 */
public class Role {
    /**
     * 
     * 表字段:id
     */
    private Long id;

    /**
     * 
     * 表字段:name
     */
    @NotBlank(message = "角色名称不为空")
    private String name;

    /**
     * 
     * 表字段:role_key
     */
    @NotBlank(message = "角色key不为空")
    private String roleKey;

    /**
     * 
     * 表字段:status
     */
    private Integer status;

    /**
     * 
     * 表字段:description
     */
    private String description;

    /**
     * 
     * 表字段:create_time
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    /**
     * 
     * 表字段:update_time
     */
    @JsonFormat(pattern="yyyy-MM-dd  HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;

    /**
     * 获取
     * @return id Long
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取
     * @return name String
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name 
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取
     * @return roleKey String
     */
    public String getRoleKey() {
        return roleKey;
    }

    /**
     * 设置
     * @param roleKey 
     */
    public void setRoleKey(String roleKey) {
        this.roleKey = roleKey == null ? null : roleKey.trim();
    }

    /**
     * 获取
     * @return status Integer
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置
     * @param status 
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取
     * @return description String
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置
     * @param description 
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 获取
     * @return createTime Date
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置
     * @param createTime 
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取
     * @return updateTime Date
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置
     * @param updateTime 
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}