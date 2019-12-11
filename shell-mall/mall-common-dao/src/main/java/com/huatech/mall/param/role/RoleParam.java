package com.huatech.mall.param.role;

import com.huatech.mall.common.base.BaseParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 角色请求类
 *
 * @author like
 * @date 2019-12-04 4:40 下午
 **/
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class RoleParam extends BaseParam {

    private String name;
}