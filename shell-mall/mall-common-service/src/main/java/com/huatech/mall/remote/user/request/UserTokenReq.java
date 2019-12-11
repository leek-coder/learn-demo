package com.huatech.mall.remote.user.request;

import lombok.*;

import java.io.Serializable;

/**
 * 远程鉴权请求类
 *
 * @author like
 * @date 2019-12-11 4:09 下午
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserTokenReq implements Serializable {

    private Long id;
    private String userName;
    private String nickName;
}