package com.huatech.mall.entity.product;

import lombok.AllArgsConstructor;
import lombok.Builder;

import java.io.Serializable;
import java.util.Date;

/**
 *  
 * 表:t_product_attribute_category 
 * @author like 
 * @date 2019-12-31 
 */
@Builder
@AllArgsConstructor
public class ProductAttributeCategory implements Serializable {
    /**
     * 主键id
     * 表字段:id
     */
    private Long id;

    /**
     * 名称
     * 表字段:name
     */
    private String name;

    /**
     * 属性数量
     * 表字段:attribute_count
     */
    private Integer attributeCount;

    /**
     * 参数数量
     * 表字段:param_count
     */
    private Integer paramCount;

    /**
     * 创建时间
     * 表字段:create_time
     */
    private Date createTime;

    /**
     * 获取主键id
     * @return id Long
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键id
     * @param id 主键id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取名称
     * @return name String
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取属性数量
     * @return attributeCount Integer
     */
    public Integer getAttributeCount() {
        return attributeCount;
    }

    /**
     * 设置属性数量
     * @param attributeCount 属性数量
     */
    public void setAttributeCount(Integer attributeCount) {
        this.attributeCount = attributeCount;
    }

    /**
     * 获取参数数量
     * @return paramCount Integer
     */
    public Integer getParamCount() {
        return paramCount;
    }

    /**
     * 设置参数数量
     * @param paramCount 参数数量
     */
    public void setParamCount(Integer paramCount) {
        this.paramCount = paramCount;
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