package com.api.butlerApp.dao.login;

import com.api.model.app.UserLoginToken;
import com.api.model.businessManagement.SysUser;
import com.api.model.butlerApp.ButlerLoginToken;
import com.api.model.butlerApp.ButlerUserCode;

public interface ButlerLoginDao {

    /**
     * 根据手机号查询用户验证码
     * @param tel 手机号
     * @return app用户验证码
     */
    ButlerUserCode findUserCodeByTel(String tel);

    /**
     * 修改验证码和验证码发送时间
     * @param butlerUserCode 管家app用户验证码
     * @return 影响行数
     */
    int updateUserCode(ButlerUserCode butlerUserCode);

    /**
     * 添加验证码和验证码发送时间
     * @param butlerUserCode 管家app用户验证码
     * @return 影响行数
     */
    int insertUserCode(ButlerUserCode butlerUserCode);

    /**
     * 根据手机号删除手机验证码信息
     * @param tel 手机号
     * @return 影响行数
     */
    int deleteUserCodeByTel(String tel);

    /**
     * 根据手机号查询管家用户信息
     * @param tel 手机号
     * @return 管家用户信息
     */
    SysUser findUserResidentByTel(String tel);
    /**
     * 根据用户id删除登录token信息
     * @param butlerUserId 管家用户id
     * @return 影响行数
     */
    int deleteULTByUserId(Integer butlerUserId);

    /**
     * 添加app用户登录login_token进数据库
     * @param butlerLoginToken app管家用户登录login_token
     * @return 影响行数
     */
    int insertLoginToken(ButlerLoginToken butlerLoginToken);

    /**
     * 根据token Id查询登录信息 (butler_login_token)
     * @param tokenId 登录返回的token
     * @return app用户登录login_token Vo
     */
    ButlerLoginToken findBLTByTokenId(Long tokenId);

    /**
     * 根据主键id查询管家用户信息
     * @param sysUserId 主键id
     * @return 管家用户信息
     */
    SysUser findSysUserById(Integer sysUserId);

    /**
     * 更新登录token时间
     * @param butlerLoginToken 管家app用户登录login_token
     * @return 影响行数
     */
    int updateBLTById(ButlerLoginToken butlerLoginToken);
}
