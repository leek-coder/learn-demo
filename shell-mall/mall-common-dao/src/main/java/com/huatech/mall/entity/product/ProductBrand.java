package com.huatech.mall.entity.product;

import lombok.Builder;

import java.io.Serializable;
import java.util.Date;

/**
 *  
 * 表:t_product_brand 
 * @author like 
 * @date 2019-12-30 
 */
@Builder
public class ProductBrand  implements Serializable {
    /**
     * 品牌主键
     * 表字段:id
     */
    private Long id;

    /**
     * 品牌名称
     * 表字段:name
     */
    private String name;

    /**
     * 品牌首字母
     * 表字段:first_letter
     */
    private String firstLetter;

    /**
     * 排序
     * 表字段:sort
     */
    private Integer sort;

    /**
     * 状态0： 显示1:不显示
     * 表字段:status
     */
    private String status;

    /**
     * 品牌logo
     * 表字段:logo
     */
    private String logo;

    /**
     * 专区大图
     * 表字段:big_pic
     */
    private String bigPic;

    /**
     * 品牌描述
     * 表字段:description
     */
    private String description;

    /**
     * 创建时间
     * 表字段:create_time
     */
    private Date createTime;

    /**
     * 更新时间
     * 表字段:update_time
     */
    private Date updateTime;

    /**
     * 获取品牌主键
     * @return id Long
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置品牌主键
     * @param id 品牌主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取品牌名称
     * @return name String
     */
    public String getName() {
        return name;
    }

    /**
     * 设置品牌名称
     * @param name 品牌名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取品牌首字母
     * @return firstLetter String
     */
    public String getFirstLetter() {
        return firstLetter;
    }

    /**
     * 设置品牌首字母
     * @param firstLetter 品牌首字母
     */
    public void setFirstLetter(String firstLetter) {
        this.firstLetter = firstLetter == null ? null : firstLetter.trim();
    }

    /**
     * 获取排序
     * @return sort Integer
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序
     * @param sort 排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取状态0： 显示1:不显示
     * @return status String
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态0： 显示1:不显示
     * @param status 状态0： 显示1:不显示
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 获取品牌logo
     * @return logo String
     */
    public String getLogo() {
        return logo;
    }

    /**
     * 设置品牌logo
     * @param logo 品牌logo
     */
    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }

    /**
     * 获取专区大图
     * @return bigPic String
     */
    public String getBigPic() {
        return bigPic;
    }

    /**
     * 设置专区大图
     * @param bigPic 专区大图
     */
    public void setBigPic(String bigPic) {
        this.bigPic = bigPic == null ? null : bigPic.trim();
    }

    /**
     * 获取品牌描述
     * @return descrption String
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置品牌描述
     * @param description 品牌描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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

    /**
     * 获取更新时间
     * @return updateTime Date
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}