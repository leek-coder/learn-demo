package com.huatech.mall.common.utils;

import java.util.List;

/**
 * @author like
 * @date 2019-12-13 3:50 下午
 **/
public interface ITree {
    /**
     * 获取组织树
     *
     * @return
     */
    List<TreeNode> getTree();

    /**
     * 获取根节点
     *
     * @return
     */
    List<TreeNode> getRoot();

    /**
     * 获取某个节点下的树结构
     *
     * @param nodeId
     * @return
     */
    TreeNode getTreeNode(String nodeId);


}