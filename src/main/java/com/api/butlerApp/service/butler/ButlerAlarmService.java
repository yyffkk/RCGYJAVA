package com.api.butlerApp.service.butler;

import com.api.model.butlerApp.ButlerAppAlarm;

import java.util.Map;

public interface ButlerAlarmService {
    Map<String, Object> insertAlarmRecord(ButlerAppAlarm butlerAppAlarm);
}
