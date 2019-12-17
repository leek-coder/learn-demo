package com.huatech.mall.entity.resource;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 表:t_resource
 *
 * @author like
 * @date 2019-12-04
 */
public class Resource {
    /**
     * 表字段:id
     */
    private Long id;

    /**
     * 表字段:name
     */
    @NotBlank(message = "资源名不为空")
    private String name;

    /**
     * 表字段:parent_id
     */
    private Integer parentId;

    /**
     * 表字段:type
     */
    @NotNull(message = "资源类型不为空")
    private Integer type;

    /**
     * 表字段:icon
     */
    private String icon;

    /**
     * 表字段:level
     */
    @NotNull(message = "资源级别不为空")
    private Integer level;

    /**
     * 表字段:sort
     */
    @NotNull(message = "资源排序不为空")
    private Integer sort;

    /**
     * 表字段:source_key
     */
    @NotBlank(message = "资源key不为空")
    private String sourceKey;

    /**
     * 表字段:source_url
     */
    @NotBlank(message = "资源url不为空")
    private String sourceUrl;

    /**
     * 表字段:description
     */
    private String description;

    /**
     * 表字段:create_time
     */
    @JsonFormat(pattern = "yyyy-MM-dd  HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 表字段:update_time
     */
    @JsonFormat(pattern = "yyyy-MM-dd  HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    /**
     * 获取
     *
     * @return id Long
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取
     *
     * @return name String
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取
     *
     * @return parentId Integer
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置
     *
     * @param parentId
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取
     *
     * @return type Integer
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置
     *
     * @param type
     */
    public void setType(Integer type) {
        this.type = type;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * 获取
     *
     * @return level Integer
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 设置
     *
     * @param level
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * 获取
     *
     * @return sort Integer
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置
     *
     * @param sort
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取
     *
     * @return sourceKey String
     */
    public String getSourceKey() {
        return sourceKey;
    }

    /**
     * 设置
     *
     * @param sourceKey
     */
    public void setSourceKey(String sourceKey) {
        this.sourceKey = sourceKey == null ? null : sourceKey.trim();
    }

    /**
     * 获取
     *
     * @return sourceUrl String
     */
    public String getSourceUrl() {
        return sourceUrl;
    }

    /**
     * 设置
     *
     * @param sourceUrl
     */
    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl == null ? null : sourceUrl.trim();
    }

    /**
     * 获取
     *
     * @return description String
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 获取
     *
     * @return createTime Date
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置
     *
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取
     *
     * @return updateTime Date
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置
     *
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentId=" + parentId +
                ", type=" + type +
                ", icon='" + icon + '\'' +
                ", level=" + level +
                ", sort=" + sort +
                ", sourceKey='" + sourceKey + '\'' +
                ", sourceUrl='" + sourceUrl + '\'' +
                ", description='" + description + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}