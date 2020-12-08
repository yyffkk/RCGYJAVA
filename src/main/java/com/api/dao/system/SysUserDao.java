package com.api.dao.system;

import com.api.model.system.SysUser;
import org.springframework.stereotype.Component;

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

    /**
     * 根据用户名查询系统用户信息
     * @param userName 用户名
     * @return 系统用户信息
     */
    SysUser findByUserName(String userName);

    /**
     * 根据id查询系统用户信息
     * @param createId 系统用户主键id
     * @return 系统用户信息
     */
    SysUser findById(Integer createId);
}
