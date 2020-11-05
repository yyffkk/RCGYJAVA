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

    @PostMapping("/registerSysUser")
    public Map registerSysUser(SysUser sysUser){
        return sysUserService.registerSysUser(sysUser);
    }

    @PostMapping("/findSysUserToUserName")
    public Map findSysUserToUserName(SysUser sysUser){

        return null;
    }
}
