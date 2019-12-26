package com.huatech.mall.controller;

import com.huatech.mall.common.base.BaseController;
import com.huatech.mall.common.jwt.JwtUser;
import com.huatech.mall.common.response.ResponseResult;
import com.huatech.mall.common.utils.ICacheService;
import com.huatech.mall.param.user.LoginParam;
import com.huatech.mall.res.user.LoginUserRes;
import com.huatech.mall.res.user.MenusRes;
import com.huatech.mall.res.user.UserRoleRes;
import com.huatech.mall.user.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * 用户相关业务控制器
 *
 * @author like
 * @date 2019-11-30 9:18 上午
 **/
@RestController
@RequestMapping(value = "/user")
@Slf4j
@RefreshScope
@Api(value = "用户管理", tags = "用户操作接口")
public class UserController extends BaseController {


    @Autowired
    private IUserService userService;

    @Autowired
    private ICacheService cacheService;


    @Value("${redis.token.prefix}")
    private String USER_PREFIX;


    @PostMapping(value = "/login")
    @ApiOperation(value = "用户登陆", notes = "用户登陆")
    public ResponseResult login(@RequestBody LoginParam loginParam) {
        log.info("=========用户登陆:{}", loginParam.toString());
        LoginUserRes login = userService.login(loginParam);
        return ResponseResult.success(login);
    }


    @GetMapping(value = "/logout")
    @ApiOperation(value = "用户登出", notes = "用户登出")
    public ResponseResult logout(HttpServletRequest servletRequest) {
        final JwtUser userInfo = getUserInfo(servletRequest);
        cacheService.remove(USER_PREFIX + userInfo.getId());
        return ResponseResult.success("退出成功");
    }

    @ApiOperation(value = "获取系统权限树", notes = "获取系统权限树")
    @GetMapping(value = "/menus")
    public ResponseResult menus(HttpServletRequest servletRequest) {
        final JwtUser userInfo = getUserInfo(servletRequest);
        List<MenusRes> roleMenus = userService.findRoleMenus(userInfo.getId());
        return ResponseResult.success(roleMenus);
    }


    @ApiOperation(value = "获取用户所有角色", notes = "获取用户所有角色")
    @GetMapping(value = "/roles")
    public ResponseResult getRoles(HttpServletRequest request, Long userId) {

        UserRoleRes roleRes = userService.findUserRoles(userId);
        return ResponseResult.success(roleRes);
    }


    @ApiOperation(value = "获取角色所有的资源权限列表", notes = "获取角色所有的资源权限列表")
    @GetMapping(value = "/resources", consumes = "application/json")
    public ResponseResult getResources(HttpServletRequest request, Long userId) {
        List<MenusRes> roleMenus = userService.findRoleMenus(userId);
        return ResponseResult.success(roleMenus);
    }




}