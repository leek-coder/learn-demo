package com.huatech.mall.entity.product;

import lombok.Builder;

import java.util.Date;

/**
 *  
 * 表:t_product_attribute 
 * @author like 
 * @date 2020-01-02 
 */
@Builder
public class ProductAttribute {
    /**
     * 主键id
     * 表字段:id
     */
    private Long id;

    /**
     * 商品属性分类id
     * 表字段:product_attribute_category_id
     */
    private Long productAttributeCategoryId;

    /**
     * 名称
     * 表字段:name
     */
    private String name;

    /**
     * 属性选择类型：0->唯一；1->单选；2->多选
     * 表字段:select_type
     */
    private Integer selectType;

    /**
     * 属性录入方式：0->手工录入；1->从列表中选取
     * 表字段:input_type
     */
    private Integer inputType;

    /**
     * 可选值列表，以逗号隔开
     * 表字段:input_list
     */
    private String inputList;

    /**
     * 排序字段
     * 表字段:sort
     */
    private Integer sort;

    /**
     * 属性的类型；0->规格；1->参数
     * 表字段:type
     */
    private Integer type;

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
     * 获取商品属性分类id
     * @return productAttributeCategoryId Long
     */
    public Long getProductAttributeCategoryId() {
        return productAttributeCategoryId;
    }

    /**
     * 设置商品属性分类id
     * @param productAttributeCategoryId 商品属性分类id
     */
    public void setProductAttributeCategoryId(Long productAttributeCategoryId) {
        this.productAttributeCategoryId = productAttributeCategoryId;
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
     * 获取属性选择类型：0->唯一；1->单选；2->多选
     * @return selectType Integer
     */
    public Integer getSelectType() {
        return selectType;
    }

    /**
     * 设置属性选择类型：0->唯一；1->单选；2->多选
     * @param selectType 属性选择类型：0->唯一；1->单选；2->多选
     */
    public void setSelectType(Integer selectType) {
        this.selectType = selectType;
    }

    /**
     * 获取属性录入方式：0->手工录入；1->从列表中选取
     * @return inputType Integer
     */
    public Integer getInputType() {
        return inputType;
    }

    /**
     * 设置属性录入方式：0->手工录入；1->从列表中选取
     * @param inputType 属性录入方式：0->手工录入；1->从列表中选取
     */
    public void setInputType(Integer inputType) {
        this.inputType = inputType;
    }

    /**
     * 获取可选值列表，以逗号隔开
     * @return inputList String
     */
    public String getInputList() {
        return inputList;
    }

    /**
     * 设置可选值列表，以逗号隔开
     * @param inputList 可选值列表，以逗号隔开
     */
    public void setInputList(String inputList) {
        this.inputList = inputList == null ? null : inputList.trim();
    }

    /**
     * 获取排序字段
     * @return sort Integer
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序字段
     * @param sort 排序字段
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取属性的类型；0->规格；1->参数
     * @return type Integer
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置属性的类型；0->规格；1->参数
     * @param type 属性的类型；0->规格；1->参数
     */
    public void setType(Integer type) {
        this.type = type;
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