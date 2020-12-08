package com.api.service.system;

import com.api.model.system.TestUser;

import java.util.Map;

/**
 * 系统用户管理
 */
public interface TestUserService {
    /**
     * 系统用户注册
     * @param testUser 系统用户model
     * @return map {message 消息, status 状态}
     */
    Map<String,Object> registerSysUser(TestUser testUser);
    /**
     * 系统用户登录
     * @param testUser 系统用户model
     * @return map {message 消息, status 状态}
     */
    Map<String,Object> loginSysUser(TestUser testUser);

    /**
     * 系统用户短信登录
     * @param testUser 系统用户model
     * @param captcha
     * @return map {message 消息, status 状态}
     */
    Map<String, Object> loginSMSSysUser(TestUser testUser, String captcha);

    /**
     * 发送短信验证码
     * @param testUser 系统用户model
     * @return map {message 消息, status 状态}
     */
    Map<String, Object> sendMMSLogin(TestUser testUser);
}
