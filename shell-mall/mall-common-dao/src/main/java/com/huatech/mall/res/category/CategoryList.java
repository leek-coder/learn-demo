package com.huatech.mall.res.category;

import lombok.*;

import java.io.Serializable;

/**
 * 分类返回响应
 *
 * @author like
 * @date 2019-12-26 9:29 下午
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CategoryList implements Serializable {

    /**
     * 类别主键
     */
    private Integer id;

    /**
     * 商品类目编号
     */
    private String categoryNo;

    /**
     * 父节点
     */
    private Long parentId;

    /**
     * 类目名称
     */
    private String name;

    /**
     * 分类图片
     */
    private String imgUrl;

    /**
     * 分类层级0:顶级1:二级2:三级
     */
    private String level;
}