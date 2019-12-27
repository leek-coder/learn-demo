package com.huatech.mall.res.category;

import com.huatech.mall.common.utils.ITreeNode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author like
 * @date 2019-12-26 9:37 下午
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryRes implements Serializable, ITreeNode {

    private Integer id;
    private String name;
    private Long parentId;
    private String level;
    private String imgUrl;
    private List<CategoryRes> children;


    @Override
    public String getNodeId() {
        return this.id +"";
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getParentId() {
        return this.parentId+"";
    }

    @Override
    public Integer getOrderNum() {
        return  this.id;
    }

    @Override
    public String getIcon() {
        return this.imgUrl;
    }

    @Override
    public String getSourceUrl() {
        return null;
    }
}