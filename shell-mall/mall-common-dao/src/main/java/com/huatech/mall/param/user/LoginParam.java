package com.huatech.mall.param.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

/**
 * 用户登陆请求
 *
 * @author like
 * @date 2019-12-11 11:54 上午
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginParam {

    @NotBlank(message = "用户名不能为空")
    private String userName;
    @NotBlank(message = "密码不能为空")
    private String password;
}