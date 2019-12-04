package com.huatech.mall.common.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * 基础请求类
 *
 * @author like
 * @date 2019-12-03 4:05 下午
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BaseParam implements Serializable {

    /**
     * 起始页
     */
    private Integer page = 1;
    /**
     * 一页显示个数
     */
    private Integer size = 10;
}