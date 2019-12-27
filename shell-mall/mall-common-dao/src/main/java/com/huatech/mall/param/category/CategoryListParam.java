package com.huatech.mall.param.category;

import com.huatech.mall.common.base.BaseParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 分类树请求参数
 *
 * @author like
 * @date 2019-12-27 5:07 下午
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryListParam implements Serializable {

    private Integer level;
    private Integer parentId;
    private Integer page;
    private Integer size;

}