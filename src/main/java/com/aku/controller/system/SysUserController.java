package com.aku.controller.system;

import com.aku.model.system.SysUser;
import com.aku.service.system.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("sysUser")
public class SysUserController {
    @Autowired
    SysUserService sysUserService;

    /**
     * 系统用户注册
     * @param sysUser 系统用户model
     * @return map {message 消息, status 状态}
     */
    @PostMapping("/registerSysUser")
    public Map<String,Object> registerSysUser(SysUser sysUser){
        return sysUserService.registerSysUser(sysUser);
    }

    /**
     * 系统用户登录
     * @param sysUser 系统用户model
     * @return map {message 消息, status 状态}
     */
    @PostMapping("/loginSysUser")
    public Map<String,Object> loginSysUser(SysUser sysUser){
        return sysUserService.loginSysUser(sysUser);
    }

    /**
     * 系统用户短信登录
     * @param sysUser 系统用户model
     * @return map {message 消息, status 状态}
     */
    @PostMapping("/loginSMSSysUser")
    public Map<String,Object> loginSMSSysUser(SysUser sysUser){
        return sysUserService.loginSMSSysUser(sysUser);
    }

    /**
     * 发送短信登录
     * @param sysUser 系统用户model
     * @return map {message 消息, status 状态}
     */
    @PostMapping("/sendMMSLogin")
    public Map<String,Object> sendMMSLogin (SysUser sysUser){
        return sysUserService.sendMMSLogin (sysUser);
    }
}
