package com.huatech.mall.res.user;

import com.huatech.mall.common.utils.ITreeNode;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 资源列表返回
 *
 * @author like
 * @date 2019-12-13 2:24 下午
 **/

@Data
public class UserResourcesRes implements Serializable, ITreeNode {
    private Long id;
    private String name;
    private Integer parentId;
    private Integer type;
    private Integer sort;
    private String icon;
    private String sourceUrl;
    List<UserResourcesRes> children;
    @Override
    public String getNodeId() {
        return this.id + "";
    }


    @Override
    public Integer getOrderNum() {
        return this.sort;
    }

    @Override
    public String getIcon() {
        return this.icon;
    }

    @Override
    public String getSourceUrl() {
        return this.sourceUrl;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getParentId() {
        return parentId + "";
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}