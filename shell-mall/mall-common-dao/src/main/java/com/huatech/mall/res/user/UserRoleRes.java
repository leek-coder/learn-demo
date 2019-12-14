package com.huatech.mall.res.user;

import lombok.*;

import java.io.Serializable;

/**
 * 用户角色响应
 *
 * @author like
 * @date 2019-12-13 11:52 上午
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserRoleRes implements Serializable {

    /**
     * 用户名称
     */
    private String userName;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 用户id
     */
    private Long uid;
    /**
     * 角色id
     */
    private Long rid;

}