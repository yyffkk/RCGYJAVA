package com.api.manage.controller.system;

import com.api.model.businessManagement.SysUser;
import com.api.manage.service.system.SysLoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("manage/sysLogin")
@Slf4j
public class SysLoginController {
    @Resource
    SysLoginService sysLoginService;


    /**
     * 系统用户注册
     * @param sysUser 系统用户model
     * @return map {message 消息, status 状态}
     */
    @PostMapping("/registerSysUser")
    public Map<String,Object> registerSysUser(@RequestBody SysUser sysUser){
        return sysLoginService.registerSysUser(sysUser);
    }

    /**
     * 系统用户登录
     * @param sysUser 系统用户model
     * @return map {message 消息, status 状态}
     */
    @PostMapping("/loginSysUser")
    public Map<String,Object> loginSysUser(@RequestBody SysUser sysUser){
        log.info(sysUser.getUserName()+"已登录");
        return sysLoginService.loginSysUser(sysUser);
    }

    /**
     * 发送短信验证码
     * @param sysUser 系统用户model
     * @return map {message 消息, status 状态}
     */
    @PostMapping("/sendMMSLogin")
    public Map<String,Object> sendMMSLogin (@RequestBody SysUser sysUser){
        return sysLoginService.sendMMSLogin (sysUser);
    }

    /**
     * 系统用户短信登录
     * @param sysUser 系统用户model
     * @return map {message 消息, status 状态}
     */
    @PostMapping("/loginSMSSysUser")
    public Map<String,Object> loginSMSSysUser(@RequestBody SysUser sysUser){
        return sysLoginService.loginSMSSysUser(sysUser);
    }

    /**
     * 系统用户登出
     * @return map {message 消息, status 状态}
     */
    @GetMapping("/logout")
    public Map<String,Object> logout(){
        return sysLoginService.logout();
    }



}
