package com.huatech.mall.param.user;

import com.huatech.mall.common.base.BaseParam;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 用户请求类
 *
 * @author like
 * @date 2019-12-03 4:06 下午
 **/
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserParam extends BaseParam {

    /**
     * 姓名
     */
    private String username;
}