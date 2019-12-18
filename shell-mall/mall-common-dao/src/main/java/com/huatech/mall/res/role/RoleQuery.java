package com.huatech.mall.res.role;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 角色返回
 *
 * @author like
 * @date 2019-12-18 2:19 下午
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RoleQuery implements Serializable {
    /**
     * 角色id
     */
    private Long id;
    /**
     * 角色名称
     */
    private String name;
    /**
     * 角色描述
     */
    private String description;

    private String roleKey;

    /**
     * 创建时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:dd",timezone = "GMT+8")
    private Date createTime;
    /**
     * 资源列表
     */
    List<ResourceQuery> children;
}