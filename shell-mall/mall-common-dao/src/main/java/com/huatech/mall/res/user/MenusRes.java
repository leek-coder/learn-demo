package com.huatech.mall.res.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

/**
 * @author like
 * @date 2019-12-13 5:41 下午
 **/
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class MenusRes {

    private String nodeId;
    /**
     * 节点名称
     */
    private String name;
    /**
     * 父节点id
     */
    private String parentId;
    private String icon;
    private String sourceUrl;
    private Integer orderNum;
    private List<MenusRes> children;


}