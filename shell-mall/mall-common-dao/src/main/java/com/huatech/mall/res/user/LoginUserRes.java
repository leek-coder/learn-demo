package com.huatech.mall.res.user;

import lombok.Builder;

import java.io.Serializable;

/**
 * 用户登陆响应
 *
 * @author like
 * @date 2019-12-11 2:51 下午
 **/
@Builder
public class LoginUserRes implements Serializable {

    /**
     * 用户id
     */
    private Long id;

    /**
     * 角色id
     */
    private Long rid;
    /**
     * 用户姓名
     */
    private String userName;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 邮箱
     */
    private String email;

    /**
     * token
     */
    private String token;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "LoginUserRes{" +
                "id=" + id +
                ", rid=" + rid +
                ", userName='" + userName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}