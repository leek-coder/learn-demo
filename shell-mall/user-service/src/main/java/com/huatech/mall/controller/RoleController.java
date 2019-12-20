package com.huatech.mall.controller;

import com.huatech.mall.common.response.ResponseResult;
import com.huatech.mall.common.utils.BeanValidator;
import com.huatech.mall.entity.role.Role;
import com.huatech.mall.param.role.RoleGrantParam;
import com.huatech.mall.param.role.RoleParam;
import com.huatech.mall.res.role.RoleQuery;
import com.huatech.mall.role.IRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 角色控制器类
 *
 * @author like
 * @date 2019-12-04 4:35 下午
 **/

@RestController
@RequestMapping(value = "/web/role")
@Slf4j
@Api(value = "web角色管理", tags = "web角色操作接口")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @PostMapping(value = "/save")
    @ApiOperation(value = "创建角色", notes = "根据user对象创建角色")
    public ResponseResult save(@Valid @RequestBody Role role) {
        //验证参数的合法性
        BeanValidator.check(role);
        //插入系统角色
        roleService.insert(role);
        return ResponseResult.success();
    }

    /**
     * 根据角色id删除
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/delete/{id}")
    @ApiOperation(value = "删除角色", notes = "根据用户id标示删除角色")
    public ResponseResult delete(@PathVariable("id") Long id) {
        roleService.delete(id);
        return ResponseResult.success();
    }


    @GetMapping(value = "/query")
    @ApiOperation(value = "查询角色列表", notes = "查询系统所有符合条件的角色")
    public ResponseResult list(RoleParam param) {
        log.info("=========query===============");
        List<RoleQuery> roles = roleService.findRoleList(param);
        return ResponseResult.success(roles);
    }

    @PostMapping(value = "/update")
    @ApiOperation(value = "角色信息修改", notes = "角色信息修改")
    public ResponseResult update(@RequestBody Role role) {
        log.info("=========角色信息修改===========");
        roleService.insert(role);
        return ResponseResult.success();
    }

    @GetMapping(value = "/info/{id}")
    @ApiOperation(value = "获取角色详情", notes = "根据角色id获取角色信息")
    public ResponseResult info(@PathVariable("id") Long id) {
        log.info("====获取角色信息请求参数:{}=====", id);
        Role role = roleService.find(id);
        return ResponseResult.success(role);
    }

    @GetMapping(value = "/list")
    @ApiOperation(value = "获取系统角色列表", notes = "获取系统角色列表")
    public ResponseResult roles() {
        log.info("====获取系统角色列表:=====");
        List<Role> roles = roleService.findAll();
        return ResponseResult.success(roles);
    }

    @PostMapping(value = "/grant")
    @ApiOperation(value = "为角色授权", notes = "为角色授权")
    public ResponseResult grant(@RequestBody  RoleGrantParam grantParam) {
        log.info("====为系统角色授权:=====");
        roleService.grant(grantParam);
        return ResponseResult.success();
    }


}