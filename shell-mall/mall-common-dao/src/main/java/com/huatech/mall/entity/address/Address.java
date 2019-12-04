package com.huatech.mall.entity.address;

import java.util.Date;

/**
 *  
 * 表:t_address 
 * @author like 
 * @date 2019-12-02 
 */
public class Address {
    /**
     * 
     * 表字段:id
     */
    private Long id;

    /**
     * 用户userId
     * 表字段:user_id
     */
    private Long userId;

    /**
     * 联系人
     * 表字段:contact_name
     */
    private String contactName;

    /**
     * 联系人手机号
     * 表字段:contact_phone
     */
    private String contactPhone;

    /**
     * 省
     * 表字段:province
     */
    private String province;

    /**
     * 市
     * 表字段:city
     */
    private String city;

    /**
     * 区
     * 表字段:area
     */
    private String area;

    /**
     * 详细地址
     * 表字段:address
     */
    private String address;

    /**
     * 0:不是默认 1：默认
     * 表字段:is_default
     */
    private String isDefault;

    /**
     * 1:未删除 0：已删除
     * 表字段:status
     */
    private String status;

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
     * 邮政编码
     * 表字段:code
     */
    private Integer code;

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
     * 获取用户userId
     * @return userId Long
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户userId
     * @param userId 用户userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取联系人
     * @return contactName String
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * 设置联系人
     * @param contactName 联系人
     */
    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    /**
     * 获取联系人手机号
     * @return contactPhone String
     */
    public String getContactPhone() {
        return contactPhone;
    }

    /**
     * 设置联系人手机号
     * @param contactPhone 联系人手机号
     */
    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone == null ? null : contactPhone.trim();
    }

    /**
     * 获取省
     * @return province String
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置省
     * @param province 省
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * 获取市
     * @return city String
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置市
     * @param city 市
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * 获取区
     * @return area String
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置区
     * @param area 区
     */
    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    /**
     * 获取详细地址
     * @return address String
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置详细地址
     * @param address 详细地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取0:不是默认 1：默认
     * @return isDefault String
     */
    public String getIsDefault() {
        return isDefault;
    }

    /**
     * 设置0:不是默认 1：默认
     * @param isDefault 0:不是默认 1：默认
     */
    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault == null ? null : isDefault.trim();
    }

    /**
     * 获取1:未删除 0：已删除
     * @return status String
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置1:未删除 0：已删除
     * @param status 1:未删除 0：已删除
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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
     * 获取邮政编码
     * @return code Integer
     */
    public Integer getCode() {
        return code;
    }

    /**
     * 设置邮政编码
     * @param code 邮政编码
     */
    public void setCode(Integer code) {
        this.code = code;
    }
}