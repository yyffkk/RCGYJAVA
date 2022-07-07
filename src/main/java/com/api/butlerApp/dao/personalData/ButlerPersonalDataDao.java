package com.api.butlerApp.dao.personalData;

import com.api.model.app.UpdateTel;
import com.api.model.businessManagement.SysUser;
import com.api.model.butlerApp.ButlerUpdateTel;
import com.api.vo.butlerApp.ButlerPersonalDataVo;

public interface ButlerPersonalDataDao {
    /**
     * 查询管家用户个人资料信息
     * @param id 管家用户id
     * @return
     */
    ButlerPersonalDataVo findById(Integer id);

    /**
     * 修改用户昵称
     * @param sysUser 系统用户表
     * @return 影响行数
     */
    int updateNickName(SysUser sysUser);

    /**
     * 根据新手机号查询用户手机号修改验证码
     * @param newTel 新手机号
     * @return 修改手机号信息
     */
    ButlerUpdateTel findTelUpdateCodeByTel(String newTel);


    /**
     * 修改验证码和验证码发送时间
     * @param butlerUpdateTel 管家app修改手机号信息
     * @return 影响行数
     */
    int updateTelUpdateCode(ButlerUpdateTel butlerUpdateTel);

    /**
     * 验证码和验证码发送时间存入数据库
     * @param butlerUpdateTel 管家app修改手机号信息
     * @return 影响行数
     */
    int insertTelUpdateCode(ButlerUpdateTel butlerUpdateTel);

    /**
     * 根据新手机号查询手机验证码信息
     * @param newTel 新手机号
     * @return 修改手机号信息
     */
    ButlerUpdateTel findUserTelUpdateByTel(String newTel);

    /**
     * 删除手机验证码信息（防止一个验证码多次登录）
     * @param newTel 新号码
     * @return 影响行数
     */
    int deleteUserTelUpdateByTel(String newTel);

    /**
     * 修改用户手机号
     * @param butlerUpdateTel 管理用户修改手机号信息
     * @return 影响行数
     */
    int updateTel(ButlerUpdateTel butlerUpdateTel);
}
