package com.huatech.mall.entity.category;

import java.util.Date;

/**
 *  
 * 表:t_category 
 * @author like 
 * @date 2019-12-19 
 */
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
     * 类目名称
     * 表字段:name
     */
    private String name;

    /**
     * 状态（1：正常    2：删除）
     * 表字段:status
     */
    private Boolean status;

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
     * 
     * 表字段:img_url
     */
    private String imgUrl;

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
     * 获取状态（1：正常    2：删除）
     * @return status Boolean
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 设置状态（1：正常    2：删除）
     * @param status 状态（1：正常    2：删除）
     */
    public void setStatus(Boolean status) {
        this.status = status;
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

    /**
     * 获取
     * @return imgUrl String
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * 设置
     * @param imgUrl 
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }
}