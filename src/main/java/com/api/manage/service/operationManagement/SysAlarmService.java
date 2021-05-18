package com.api.manage.service.operationManagement;

import com.api.vo.operationManagement.VoFireAlarm;
import com.api.vo.operationManagement.VoOneButtonAlarm;

import java.util.List;

public interface SysAlarmService {
    List<VoFireAlarm> fireAlarmList();


    List<VoOneButtonAlarm> oneButtonAlarmList();
}
