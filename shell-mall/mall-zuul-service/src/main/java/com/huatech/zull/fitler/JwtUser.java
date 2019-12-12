package com.huatech.zull.fitler;


/**
 * @ClassName JwtUser
 * @Description TODO
 * @Author like
 * @Date 2019-12-11 13:33
 * @Version 1.0
 **/
public class JwtUser {

    private Long id;
    private String userName;
    private String nickName;

    @Override
    public String toString() {
        return "JwtUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
