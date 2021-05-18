package com.api.app.dao.butler;

import com.api.model.app.AppAlarm;

public interface AppAlarmDao {
    /**
     * 添加app报警记录
     * @param appAlarm app 报警model 信息
     * @return 影响行数
     */
    int insertAlarmRecord(AppAlarm appAlarm);
}
