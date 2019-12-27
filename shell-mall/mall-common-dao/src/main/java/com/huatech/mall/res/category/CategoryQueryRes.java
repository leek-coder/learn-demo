package com.huatech.mall.res.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分类数据返回响应
 *
 * @author like
 * @date 2019-12-27 7:20 下午
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryQueryRes {
    /**
     * 总数
     */
    private Long total;
    /**
     * 返回数据
     */
    private List<CategoryQuery> queries;
}