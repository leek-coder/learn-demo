package com.huatech.mall.common.utils;

/**
 * @author like
 * @date 2019-12-13 3:52 下午
 **/
public interface ITreeNode {
    /**
     * 获取节点id
     *
     * @return
     */
     String getNodeId();

    /**
     * 节点名称
     *
     * @return
     */
     String getName();

    /**
     * 父节点
     *
     * @return
     */
     String getParentId();

    /**
     * 序号
     *
     * @return
     */
     Integer getOrderNum();

    /**
     * 资源key
     *
     * @return
     */
     String getSourceKey();

    /**
     * 资源url
     *
     * @return
     */
     String getSourceUrl();

}