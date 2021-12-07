package com.api.manage.service.operationManagement;

import com.api.vo.operationManagement.VoButlerOneButtonAlarm;
import com.api.vo.operationManagement.VoFireAlarm;
import com.api.vo.operationManagement.VoOneButtonAlarm;
import com.api.vo.operationManagement.VoPlanAlarm;

import java.util.List;

public interface SysAlarmService {
    List<VoFireAlarm> fireAlarmList();


    List<VoOneButtonAlarm> oneButtonAlarmList();

    List<VoButlerOneButtonAlarm> butlerOneButtonAlarmList();

    List<VoPlanAlarm> planAlarmList();
}
