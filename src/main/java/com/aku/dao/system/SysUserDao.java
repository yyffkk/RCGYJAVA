package com.aku.dao.system;

import com.aku.model.system.SysUser;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 系统用户管理
 */
@Component
public interface SysUserDao {
    /**
     * 系统用户注册
     */
    int registerSysUser(SysUser sysUser);
    /**
     * 系统用户登录
     */
    SysUser loginSysUser(SysUser sysUser);
}
