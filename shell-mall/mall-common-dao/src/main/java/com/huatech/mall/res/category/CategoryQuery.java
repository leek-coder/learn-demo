package com.huatech.mall.res.category;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 分类查询数据
 *
 * @author like
 * @date 2019-12-27 7:17 下午
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryQuery implements Serializable {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 级别
     */
    private Integer level;

    /**
     * 父级分类
     */
    private String parentName;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 分类图片
     */
    private String imgUrl;

}