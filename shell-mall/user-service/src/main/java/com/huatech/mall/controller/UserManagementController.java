package com.huatech.mall.controller;

import com.huatech.mall.common.response.ResponseResult;
import com.huatech.mall.common.utils.BeanValidator;
import com.huatech.mall.entity.user.User;
import com.huatech.mall.param.user.UserParam;
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
    @PostMapping(value = "/delete/{id}")
    @ApiOperation(value = "删除用户", notes = "根据用户id标示删除用户")
    public ResponseResult delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return ResponseResult.success();
    }


    @GetMapping(value = "/query")
    @ApiOperation(value = "查询用户列表", notes = "查询系统所有符合条件的用户")
    public ResponseResult list(@RequestBody UserParam userParam) {
        log.info("=========query===============");
        List<User> users = userService.findUserList(userParam);
        return ResponseResult.success(users);
    }


    @PostMapping(value = "/update")
    @ApiOperation(value = "用户信息修改", notes = "用户信息修改")
    public ResponseResult update(@RequestBody User user) {
        log.info("=========用户信息修改===========");
        userService.insert(user);
        return ResponseResult.success();
    }


}