package com.huatech.mall.param.category;


import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Author leek
 * @Date 2019-12-21 下午10:21
 * @Version 1.0
 * @Description 用于接收参数的实体类
 */
@Data
@Builder
@ToString
public class CategoryParam implements Serializable {


    /**
     * 类目标示
     */
    private Integer id;
    /**
     * 类目名称
     */
    @NotBlank(message = "类目名称不能为空")
    private String name;

    /**
     * 类目图片
     */
    @NotBlank(message = "请上传图片")
    private String imgUrl;

    /**
     * 类目父节点
     */
    private Long parentId = 0L;

    /**
     * 类目描述
     */
    private String description;
    /**
     * 类目级别
     */
    private String level;


}
