package com.api.app.dao.login;

import com.api.model.app.AppRequestLog;
import com.api.model.app.UserCode;
import com.api.model.app.UserLoginToken;
import com.api.model.basicArchives.ResidentIdAndEstateId;
import com.api.model.basicArchives.UserResident;
import com.api.model.my.MyHouse;
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
     * @param myHouse 房产认证model
     * @return 影响行数
     */
    int insertResidentEstateExamine(MyHouse myHouse);

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

    /**
     * 根据用户id删除登录token信息
     * @param residentId 用户id
     * @return 影响行数
     */
    int deleteULTByResidentId(Integer residentId);

    /**
     * 根据住户id和当前时间查询今日是否有操作记录
     * @param appRequestLog1 app用户请求日志
     * @return app用户请求日志
     */
    AppRequestLog findRequestLog(AppRequestLog appRequestLog1);

    /**
     * 更新当日用户请求日志
     * @param appRequestLog1 app用户请求日志
     */
    void updateRequestLog(AppRequestLog appRequestLog1);

    /**
     * 添加当日用户请求日志
     * @param appRequestLog1 app用户请求日志
     */
    void insertRequestLog(AppRequestLog appRequestLog1);
}
