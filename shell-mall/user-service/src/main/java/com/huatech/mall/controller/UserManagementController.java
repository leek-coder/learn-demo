package com.huatech.mall.controller;

import com.huatech.mall.common.response.ResponseResult;
import com.huatech.mall.common.utils.BeanValidator;
import com.huatech.mall.entity.user.User;
import com.huatech.mall.param.user.UserParam;
import com.huatech.mall.param.user.UserRoleParam;
import com.huatech.mall.res.user.UserList;
import com.huatech.mall.res.user.UserQueryRes;
import com.huatech.mall.user.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 后台管理系统user控制器
 *
 * @author like
 * @date 2019-12-03 10:12 上午
 * 增，删，改，查
 **/
@RestController
@RequestMapping(value = "/web/user")
@Slf4j
@Api(value = "web用户管理", tags = "web用户操作接口")
public class UserManagementController {


    @Autowired
    private IUserService userService;

    @PostMapping(value = "/save")
    @ApiOperation(value = "创建用户", notes = "根据user对象创建用户")
    public ResponseResult save(@Valid @RequestBody User user) {
        //验证参数的合法性
        BeanValidator.check(user);
        log.info("======创建用户请求参数====={}", user.toString());
        //插入系统用户
        userService.insert(user);
        return ResponseResult.success();
    }

    /**
     * 根据用户id删除
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/delete/{id}")
    @ApiOperation(value = "删除用户", notes = "根据用户id标示删除用户")
    public ResponseResult delete(@PathVariable("id") Long id) {
        log.info("====删除用户请求参数:{}=====", id);
        userService.delete(id);
        return ResponseResult.success();
    }


    @GetMapping(value = "/recovery/{id}")
    @ApiOperation(value = "恢复用户状态", notes = "根据用户id标示恢复用户")
    public ResponseResult recovery(@PathVariable("id") Long id) {
        log.info("====恢复用户请求参数:{}=====", id);
        userService.recovery(id);
        return ResponseResult.success();
    }
    @GetMapping(value = "/info/{id}")
    @ApiOperation(value = "获取用户信息", notes = "根据用户id获取用户信息")
    public ResponseResult info(@PathVariable("id") Long id) {
        log.info("====获取用户信息请求参数:{}=====", id);
        User user = userService.find(id);
        return ResponseResult.success(user);
    }


    @GetMapping(value = "/query")
    @ApiOperation(value = "查询用户列表", notes = "查询系统所有符合条件的用户", tags = "查询用户列表")
    public ResponseResult list(UserParam userParam) {
        log.info("=========查询用户列表:{}", userParam.toString());
        UserQueryRes query = userService.findUserList(userParam);
        return ResponseResult.success(query);
    }


    @PostMapping(value = "/update")
    @ApiOperation(value = "用户信息修改", notes = "用户信息修改")
    public ResponseResult update(@RequestBody User user) {
        log.info("=========用户信息修改:{}", user.toString());
        userService.insert(user);
        return ResponseResult.success();
    }


    @GetMapping(value = "/grant")
    @ApiOperation(value = "用户分配角色", notes = "用户分配角色", tags = "用户分配角色")
    public ResponseResult grant(UserRoleParam userRoleParam) {
        log.info("=========用户分配角色:{}", userRoleParam.toString());
         userService.grantRole(userRoleParam);
        return ResponseResult.success();
    }



}