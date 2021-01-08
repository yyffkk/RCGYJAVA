package com.api.app.dao.login;

import com.api.model.app.UserCode;
import com.api.model.app.UserLoginToken;
import com.api.model.basicArchives.UserResident;

public interface AppLoginDao {
    /**
     * 根据手机号查询用户验证码
     * @param tel 手机号
     * @return app用户验证码
     */
    UserCode findUserCodeByTel(String tel);

    /**
     * 修改验证码和验证码发送时间
     * @param userCode app用户验证码
     * @return 影响行数
     */
    int updateUserCode(UserCode userCode);

    /**
     * 添加验证码和验证码发送时间
     * @param userCode app用户验证码
     * @return 影响行数
     */
    int insertUserCode(UserCode userCode);

    /**
     * 根据手机号删除手机验证码信息
     * @param tel 手机号
     * @return 影响行数
     */
    int deleteUserCodeByTel(String tel);

    /**
     * 根据手机号查询住户信息
     * @param tel 手机号
     * @return 住户信息
     */
    UserResident findUserResidentByTel(String tel);

    int insertLoginToken(UserLoginToken userLoginToken);
}
