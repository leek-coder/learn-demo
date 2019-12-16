package com.huatech.mall.res.resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author like
 * @date 2019-12-16 3:01 下午
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourceQueryRes implements Serializable {

    private Long total;
    private List<ResourceList> resourceList;
}