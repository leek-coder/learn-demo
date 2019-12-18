package com.huatech.mall.res.role;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * 资源返回实体类
 *
 * @author like
 * @date 2019-12-18 2:21 下午
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class ResourceQuery implements Serializable {
    /**
     * 资源id
     */
    private Long id;
    /**
     * 资源名称
     */
    private String authName;
    /**
     * 资源访问路径
     */
    private String path;

    /**
     * 子资源数组
     */
    private List<ResourceQuery> children;


}