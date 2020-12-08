package com.api.controller.system;

import com.api.model.system.TestUser;
import com.api.service.system.TestUserService;
import com.api.shiro.ShiroExceptions;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("testUser")
public class TestUserController extends ShiroExceptions {
    @Resource
    TestUserService testUserService;

    /**
     * 系统用户注册
     * @param testUser 系统用户model
     * @return map {message 消息, status 状态}
     */
    @RequiresPermissions(value = {"insert2","insert"},logical = Logical.AND)
    @PostMapping("/registerSysUser")
    public Map<String,Object> registerSysUser(@RequestBody TestUser testUser){
        return testUserService.registerSysUser(testUser);
    }

    /**
     * 系统用户登录
     * @param testUser 系统用户model
     * @return map {message 消息, status 状态}
     */
    @RequiresPermissions("insert")
    @PostMapping("/loginSysUser")
    public Map<String,Object> loginSysUser(@RequestBody TestUser testUser){
        return testUserService.loginSysUser(testUser);
    }

    /**
     * 发送短信验证码
     * @param testUser 系统用户model
     * @return map {message 消息, status 状态}
     */
    @PostMapping("/sendMMSLogin")
    public Map<String,Object> sendMMSLogin (@RequestBody TestUser testUser){
        return testUserService.sendMMSLogin (testUser);
    }

    /**
     * 系统用户短信登录
     * @param testUser 系统用户model
     * @return map {message 消息, status 状态}
     */
    @PostMapping("/loginSMSSysUser")
    public Map<String,Object> loginSMSSysUser(@RequestBody TestUser testUser,@RequestBody String captcha){
        return testUserService.loginSMSSysUser(testUser,captcha);
    }



}
