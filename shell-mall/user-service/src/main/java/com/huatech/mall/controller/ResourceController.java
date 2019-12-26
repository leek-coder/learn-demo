package com.huatech.mall.controller;

import com.huatech.mall.common.response.ResponseResult;
import com.huatech.mall.common.utils.BeanValidator;
import com.huatech.mall.entity.resource.Resource;
import com.huatech.mall.param.resource.ResourceParam;
import com.huatech.mall.res.resource.ResourceQueryRes;
import com.huatech.mall.res.user.MenusRes;
import com.huatech.mall.resource.IResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 资源控制器类
 *
 * @author like
 * @date 2019-12-04 4:57 下午
 **/

@RestController
@RequestMapping(value = "/web/resource")
@Slf4j
@Api(value = "web资源管理", tags = "web资源操作接口")
public class ResourceController {

    @Autowired
    private IResourceService resourceService;

    @PostMapping(value = "/save")
    @ApiOperation(value = "创建资源", notes = "根据user对象创建资源")
    public ResponseResult save(@RequestBody Resource resource) {
        //验证参数的合法性
        BeanValidator.check(resource);
        log.info("=========创建资源:{}", resource.toString());
        //插入系统资源

        resourceService.insert(resource);
        return ResponseResult.success();
    }

    /**
     * 根据资源id删除
     *
     * @param id
     * @return
     */
    @PostMapping(value = "/delete/{id}")
    @ApiOperation(value = "删除资源", notes = "根据用户id标示删除资源")
    public ResponseResult delete(@PathVariable("id") Long id) {
        resourceService.delete(id);
        return ResponseResult.success();
    }


    @GetMapping(value = "/query")
    @ApiOperation(value = "查询资源列表", notes = "查询系统所有符合条件的资源")
    public ResponseResult list(ResourceParam param) {
        log.info("=========查询资源列表:{}", param.toString());
        ResourceQueryRes resourcesList = resourceService.findResourcesList(param);
        return ResponseResult.success(resourcesList);
    }


    @PostMapping(value = "/update")
    @ApiOperation(value = "资源信息修改", notes = "资源信息修改")
    public ResponseResult update(@RequestBody Resource resource) {
        log.info("=========资源信息修改:{}", resource.toString());
        resourceService.insert(resource);
        return ResponseResult.success();
    }


    @GetMapping(value = "/tree")
    @ApiOperation(value = "获取资源树", notes = "获取资源树")
    public ResponseResult tree() {
        log.info("=========获取所有的资源树");
        List<MenusRes> roleMenus = resourceService.findTrees();
        return ResponseResult.success(roleMenus);
    }
}