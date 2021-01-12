package com.api.app.dao.login;

import com.api.model.app.UserCode;
import com.api.model.app.UserLoginToken;
import com.api.model.basicArchives.ResidentIdAndEstateId;
import com.api.model.basicArchives.UserResident;
import com.api.vo.app.UserLoginTokenVo;

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

    /**
     * 添加app用户登录login_token进数据库
     * @param userLoginToken app用户登录login_token
     * @return 影响行数
     */
    int insertLoginToken(UserLoginToken userLoginToken);

    /**
     * 添加住户房产审核信息
     * @param residentIdAndEstateId 房产id 和 业主id
     * @return 影响行数
     */
    int insertResidentEstateExamine(ResidentIdAndEstateId residentIdAndEstateId);

    /**
     * 根据token Id查询登录信息 (user_login_token)
     * @param tokenId 登录返回的token
     * @return app用户登录login_token Vo
     */
    UserLoginTokenVo findULTByTokenId(Long tokenId);

    /**
     * 根据主键id查询住户信息
     * @param id 主键id
     * @return 住户信息
     */
    UserResident findUserResidentById(Integer id);

    /**
     * 更新登录token时间
     * @param userLoginTokenVo app用户登录login_token Vo
     * @return 影响行数
     */
    int updateULTById(UserLoginTokenVo userLoginTokenVo);
}
