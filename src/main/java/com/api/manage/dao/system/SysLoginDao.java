package com.api.manage.dao.system;

import com.api.model.businessManagement.SysUser;
import org.springframework.stereotype.Component;

/**
 * 系统用户管理
 */
@Component
public interface SysLoginDao {
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

    /**
     * 将验证码和验证码发送时间存入数据库
     * @param sysUser
     * @return
     */
    int updateCodeByTel(SysUser sysUser);

    /**
     * 根据手机号查询用户信息
     * @param tel 手机号
     * @return 用户信息
     */
    SysUser findByTel(String tel);


    /**
     * 给验证码 发送时间减去过期时间（防止一个验证码多次登录）
     * @param sysUser 手机号 和 减完后的时间
     */
    void updateCodeDateByTel(SysUser sysUser);
}
