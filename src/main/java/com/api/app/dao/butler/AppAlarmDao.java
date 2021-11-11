package com.api.app.dao.butler;

import com.api.model.app.AppAlarm;

public interface AppAlarmDao {
    /**
     * 添加app报警记录
     * @param appAlarm app 报警model 信息
     * @return 影响行数
     */
    int insertAlarmRecord(AppAlarm appAlarm);

    /**
     * 根据房产主键id查询房产名称
     * @param estateId 房产主键id
     * @return 房产名称
     */
    String findRoomNameByEstateId(Integer estateId);

    /**
     * 根据住户主键id查询住户名称
     * @param createId 住户主键id
     * @return 住户名称
     */
    String findNameByResidentId(Integer createId);

    /**
     * 根据住户主键id查询住户手机号
     * @param createId 住户主键id
     * @return 住户名称
     */
    String findTelByResidentId(Integer createId);
}
