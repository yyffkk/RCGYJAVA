package com.api.manage.service.system;

import com.api.model.system.SysUser;

import java.util.Map;

/**
 * 系统用户管理
 */
public interface SysLoginService {
    /**
     * 系统用户注册
     * @param sysUser 系统用户model
     * @return map {message 消息, status 状态}
     */
    Map<String,Object> registerSysUser(SysUser sysUser);
    /**
     * 系统用户登录
     * @param sysUser 系统用户model
     * @return map {message 消息, status 状态}
     */
    Map<String,Object> loginSysUser(SysUser sysUser);

    /**
     * 系统用户短信登录
     * @param sysUser 系统用户model
     * @return map {message 消息, status 状态}
     */
    Map<String, Object> loginSMSSysUser(SysUser sysUser);

    /**
     * 发送短信验证码
     * @param sysUser 系统用户model
     * @return map {message 消息, status 状态}
     */
    Map<String, Object> sendMMSLogin(SysUser sysUser);

    /**
     * 根据userName查找用户信息
     * @param userName 系统用户名称
     * @return sysUser 系统用户model
     */
    SysUser findByUserName(String userName);

    /**
     * 系统用户登出
     * @return map {message 消息, status 状态}
     */
    Map<String, Object> logout();
}
