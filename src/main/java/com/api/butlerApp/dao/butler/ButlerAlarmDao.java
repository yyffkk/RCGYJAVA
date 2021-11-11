package com.api.butlerApp.dao.butler;

import com.api.model.butlerApp.ButlerAppAlarm;

public interface ButlerAlarmDao {
    /**
     * 添加管家app 一键报警记录
     * @param butlerAppAlarm 管家app 报警model 信息
     * @return 影响行数
     */
    int insertAlarmRecord(ButlerAppAlarm butlerAppAlarm);

    /**
     * 根据用户主键id查询部门名称
     * @param createId 用户主键id
     * @return 部门名称
     */
    String findOrganizationByUserId(Integer createId);

    /**
     * 根据用户主键id查询用户名称
     * @param createId 用户主键id
     * @return 用户名称
     */
    String findNameByUserId(Integer createId);

    /**
     * 根据用户主键id查询用户手机号
     * @param createId 用户主键id
     * @return 用户名称
     */
    String findTelByUserId(Integer createId);
}
