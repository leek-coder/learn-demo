package com.huatech.mall.common.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author like
 * @date 2019-12-13 3:49 下午
 **/
public class TreeNode {

    /**
     * 节点id
     */
    private String nodeId;
    /**
     * 节点名称
     */
    private String name;
    /**
     * 父节点id
     */
    private String parentId;
    /**
     * 节点在排序号
     */
    private int orderNum;
    /**
     * 节点所在层级
     */
    private int level;
    private TreeNode parent;
    private String sourceKey;
    private String sourceUrl;

    public String getSourceKey() {
        return sourceKey;
    }

    public void setSourceKey(String sourceKey) {
        this.sourceKey = sourceKey;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    private List<TreeNode> children = new ArrayList<TreeNode>();


    public TreeNode(ITreeNode obj) {
        this.nodeId = obj.getNodeId();
        this.name = obj.getName();
        this.parentId = obj.getParentId();
        this.orderNum = obj.getOrderNum();
        this.sourceKey = obj.getSourceKey();
        this.sourceUrl = obj.getSourceUrl();
    }

    public void addChild(TreeNode treeNode) {
        this.children.add(treeNode);
    }

    public void removeChild(TreeNode treeNode) {
        this.children.remove(treeNode);
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }


    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}