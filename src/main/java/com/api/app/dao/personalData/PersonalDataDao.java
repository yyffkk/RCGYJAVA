package com.api.app.dao.personalData;

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
     * @param userResident 住户信息表
     * @return 影响行数
     */
    int updateTel(UserResident userResident);

    /**
     * 根据手机号查询是否有该手机号
     * @param tel 手机号
     * @return 住户信息表
     */
    UserResident findUserResidentByTel(String tel);

    /**
     * 修改 手机号修改验证码 和 手机号修改验证码发送时间
     * @param userResident 住户信息表
     * @return 影响行数
     */
    int sendTelUpdateCode(UserResident userResident);
}
