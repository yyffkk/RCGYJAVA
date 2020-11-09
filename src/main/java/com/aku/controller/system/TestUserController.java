package com.aku.controller.system;

import com.aku.model.system.TestUser;
import com.aku.service.system.TestUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("testUser")
public class TestUserController {
    @Autowired
    TestUserService testUserService;

    /**
     * 系统用户注册
     * @param testUser 系统用户model
     * @return map {message 消息, status 状态}
     */
    @PostMapping("/registerSysUser")
    public Map<String,Object> registerSysUser(TestUser testUser){
        return testUserService.registerSysUser(testUser);
    }

    /**
     * 系统用户登录
     * @param testUser 系统用户model
     * @return map {message 消息, status 状态}
     */
    @RequiresPermissions("insert")
    @PostMapping("/loginSysUser")
    public Map<String,Object> loginSysUser(TestUser testUser){
        return testUserService.loginSysUser(testUser);
    }

    /**
     * 发送短信验证码
     * @param testUser 系统用户model
     * @return map {message 消息, status 状态}
     */
    @PostMapping("/sendMMSLogin")
    public Map<String,Object> sendMMSLogin (TestUser testUser){
        return testUserService.sendMMSLogin (testUser);
    }

    /**
     * 系统用户短信登录
     * @param testUser 系统用户model
     * @return map {message 消息, status 状态}
     */
    @PostMapping("/loginSMSSysUser")
    public Map<String,Object> loginSMSSysUser(TestUser testUser,String captcha){
        return testUserService.loginSMSSysUser(testUser,captcha);
    }



}
