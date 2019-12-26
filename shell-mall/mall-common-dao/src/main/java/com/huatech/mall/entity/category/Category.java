package com.huatech.mall.entity.category;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 *  
 * 表:t_category 
 * @author like 
 * @date 2019-12-21 
 */
@Data
@Builder
public class Category {
    /**
     * 类别主键
     * 表字段:id
     */
    private Integer id;

    /**
     * 商品类目编号
     * 表字段:category_no
     */
    private String categoryNo;

    /**
     * 父节点
     * 表字段:parent_id
     */
    private Long parentId;

    /**
     * 类目名称
     * 表字段:name
     */
    private String name;

    /**
     * 分类图片
     * 表字段:img_url
     */
    private String imgUrl;

    /**
     * 分类层级0:顶级1:二级2:三级
     * 表字段:level
     */
    private String level;

    /**
     * 状态（1：正常    2：删除）
     * 表字段:status
     */
    private String status;

    /**
     * 分类描述
     * 表字段:description
     */
    private String description;

    /**
     * 
     * 表字段:create_time
     */
    private Date createTime;

    /**
     * 
     * 表字段:update_time
     */
    private Date updateTime;

    /**
     * 获取类别主键
     * @return id Integer
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置类别主键
     * @param id 类别主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取商品类目编号
     * @return categoryNo String
     */
    public String getCategoryNo() {
        return categoryNo;
    }

    /**
     * 设置商品类目编号
     * @param categoryNo 商品类目编号
     */
    public void setCategoryNo(String categoryNo) {
        this.categoryNo = categoryNo == null ? null : categoryNo.trim();
    }

    /**
     * 获取父节点
     * @return parentId Long
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置父节点
     * @param parentId 父节点
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取类目名称
     * @return name String
     */
    public String getName() {
        return name;
    }

    /**
     * 设置类目名称
     * @param name 类目名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取分类图片
     * @return imgUrl String
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * 设置分类图片
     * @param imgUrl 分类图片
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    /**
     * 获取分类层级0:顶级1:二级2:三级
     * @return level String
     */
    public String getLevel() {
        return level;
    }

    /**
     * 设置分类层级0:顶级1:二级2:三级
     * @param level 分类层级0:顶级1:二级2:三级
     */
    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    /**
     * 获取状态（1：正常    2：删除）
     * @return status String
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态（1：正常    2：删除）
     * @param status 状态（1：正常    2：删除）
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 获取分类描述
     * @return description String
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置分类描述
     * @param description 分类描述
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