package com.huatech.mall.res.resource;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 资源返回
 *
 * @author like
 * @date 2019-12-16 3:01 下午
 **/
@Data
public class ResourceList implements Serializable{

    private Long id;
    /**
     * 资源名称
     */
    private String name;
    /**
     * 父节点
     */
    private Integer parentId;
    /**
     * 资源类型
     */
    private Integer type;
    /**
     * 资源icon
     */
    private String icon;
    /**
     * 资源等级
     */
    private Integer level;
    /**
     * 资源访问路径
     */
    private String sourceUrl;

    private Integer sort;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:dd",timezone = "GMT+8")
    private Date createTime;

}