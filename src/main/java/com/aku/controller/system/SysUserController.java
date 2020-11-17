package com.aku.controller.system;

import com.aku.model.system.SysUser;
import com.aku.service.system.SysUserService;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("sysUser")
public class SysUserController {
    @Resource
    SysUserService sysUserService;


    /**
     * 系统用户注册
     * @param sysUser 系统用户model
     * @return map {message 消息, status 状态}
     */
    @PostMapping("/registerSysUser")
    public Map<String,Object> registerSysUser(@RequestBody SysUser sysUser){

        return sysUserService.registerSysUser(sysUser);
    }

    /**
     * 系统用户登录
     * @param sysUser 系统用户model
     * @return map {message 消息, status 状态}
     */
    @PostMapping("/loginSysUser")
    public Map<String,Object> loginSysUser(@RequestBody SysUser sysUser){
        System.out.println(sysUser.getPwd());
        System.out.println(sysUser.getUserName());
        return sysUserService.loginSysUser(sysUser);
    }

    /**
     * 发送短信验证码
     * @param sysUser 系统用户model
     * @return map {message 消息, status 状态}
     */
    @PostMapping("/sendMMSLogin")
    public Map<String,Object> sendMMSLogin (@RequestBody SysUser sysUser){
        return sysUserService.sendMMSLogin (sysUser);
    }

    /**
     * 系统用户短信登录
     * @param sysUser 系统用户model
     * @return map {message 消息, status 状态}
     */
    @PostMapping("/loginSMSSysUser")
    public Map<String,Object> loginSMSSysUser(@RequestBody SysUser sysUser,@RequestBody String captcha){
        return sysUserService.loginSMSSysUser(sysUser,captcha);
    }

    /**
     * 系统用户登出
     * @return map {message 消息, status 状态}
     */
    @GetMapping("/logout")
    public Map<String,Object> logout(){
        return sysUserService.logout();
    }



}
