package com.huatech.mall.res.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户列表
 *
 * @author like
 * @date 2019-12-14 3:11 下午
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserList implements Serializable {

    /**
     *
     * 表字段:id
     */
    private Long id;

    /**
     *
     * 表字段:user_name
     */
    private String userName;

    /**
     *
     * 表字段:nick_name
     */
    private String nickName;

    /**
     *
     * 表字段:sex
     */
    private Integer sex;


    /**
     *
     * 表字段:telephone
     */
    private String telephone;
    /**
     *
     * 表字段:status
     */
    private Integer status;

    /**
     *
     * 表字段:email
     */
    private String email;

    /**
     *
     * 表字段:create_time
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:dd",timezone = "GMT+8")
    private Date createTime;

    /**
     *
     * 表字段:update_time
     */
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date updateTime;

    private String roleName;
}