package com.aku.dao.system;

import com.aku.model.system.TestUser;
import org.springframework.stereotype.Component;

/**
 * 系统用户管理
 */
@Component
public interface TestDao {
    /**
     * 系统用户注册
     */
    int registerSysUser(TestUser testUser);
    /**
     * 系统用户登录
     */
    TestUser loginSysUser(TestUser testUser);
}
