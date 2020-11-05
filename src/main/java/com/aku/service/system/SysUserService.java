package com.aku.service.system;

import com.aku.model.system.SysUser;

import java.util.Map;

/**
 * 系统用户管理
 */
public interface SysUserService {
    /**
     * 系统用户注册
     */
    Map registerSysUser(SysUser sysUser);
}
