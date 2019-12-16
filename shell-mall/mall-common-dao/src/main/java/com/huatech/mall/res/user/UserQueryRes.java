package com.huatech.mall.res.user;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 用户列表查询返回
 *
 * @author like
 * @date 2019-12-14 3:23 下午
 **/
@Data
@Builder
public class UserQueryRes implements Serializable {

    private Long total;
    private List<UserList> users;
}