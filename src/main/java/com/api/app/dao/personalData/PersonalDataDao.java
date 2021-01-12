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
}
