package com.huatech.mall.param.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * 用户角色请求类
 *
 * @author like
 * @date 2019-12-20 9:34 下午
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserRoleParam implements Serializable {

    private Long uId;
    private Long rId;
}