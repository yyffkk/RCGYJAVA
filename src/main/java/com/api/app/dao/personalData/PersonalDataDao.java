package com.api.app.dao.personalData;

import com.api.model.app.PersonalData;
import com.api.model.app.UpdateTel;
import com.api.model.basicArchives.UserResident;
import com.api.vo.app.PersonalDataVo;

public interface PersonalDataDao {
    /**
     * 根据用户主键id查询个人资料信息
     * @param id 用户主键id
     * @return 个人资料信息
     */
    PersonalDataVo findById(Integer id);

    /**
     * 修改用户昵称
     * @param userResident 住户信息表
     * @return 影响行数
     */
    int updateNickName(UserResident userResident);

    /**
     * 修改用户手机号
     * @param updateTel 修改手机号信息
     * @return 影响行数
     */
    int updateTel(UpdateTel updateTel);


    /**
     * 根据新手机号查询用户手机号修改验证码
     * @param newTel 新手机号
     * @return 修改手机号信息
     */
    UpdateTel findTelUpdateCodeByTel(String newTel);

    /**
     * 修改验证码和验证码发送时间
     * @param updateTel 修改手机号信息
     * @return 影响行数
     */
    int updateTelUpdateCode(UpdateTel updateTel);

    /**
     * 验证码和验证码发送时间存入数据库
     * @param updateTel 修改手机号信息
     * @return 影响行数
     */
    int insertTelUpdateCode(UpdateTel updateTel);

    /**
     * 根据新手机号查询手机验证码信息
     * @param newTel 新手机号
     * @return 修改手机号信息
     */
    UpdateTel findUserTelUpdateByTel(String newTel);

    /**
     * 删除手机验证码信息（防止一个验证码多次登录）
     * @param newTel 新号码
     * @return 影响行数
     */
    int deleteUserTelUpdateByTel(String newTel);

    /**
     * 修改用户性别信息
     * @param personalData 个人资料信息
     * @return 影响行数
     */
    int updateSex(PersonalData personalData);

    /**
     * 修改用户出生日期信息
     * @param personalData 个人资料信息
     * @return 影响行数
     */
    int updateBirthday(PersonalData personalData);
}
