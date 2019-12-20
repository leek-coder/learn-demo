package com.huatech.mall.param.role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

/**
 * 角色授权请求参数
 *
 * @author like
 * @date 2019-12-20 10:14 上午
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RoleGrantParam implements Serializable {

    /**
     * 角色id
     */
    @NotBlank(message = "角色id不为空")
    private Long roleId;
    /**
     * 资源数组
     */
    private List<Long> resIds;
}