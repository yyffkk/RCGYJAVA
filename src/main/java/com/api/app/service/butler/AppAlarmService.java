package com.api.app.service.butler;

import com.api.model.app.AppAlarm;

import java.util.Map;

public interface AppAlarmService {
    Map<String, Object> insertAlarmRecord(AppAlarm appAlarm);
}
