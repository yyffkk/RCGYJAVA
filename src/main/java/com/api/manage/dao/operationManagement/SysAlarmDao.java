package com.api.manage.dao.operationManagement;

import com.api.vo.operationManagement.VoFireAlarm;
import com.api.vo.operationManagement.VoOneButtonAlarm;

import java.util.List;

public interface SysAlarmDao {
    /**
     * 查询所有的火灾报警记录
     * @return 火灾报警记录
     */
    List<VoFireAlarm> fireAlarmList();

    /**
     * 查询所有的一键报警记录
     * @return 一键报警记录
     */
    List<VoOneButtonAlarm> oneButtonAlarmList();

}
