package com.api.butlerApp.service.butler;

import com.api.model.operationManagement.AttendanceRecord;
import com.api.model.operationManagement.SysAttendanceLeaveRecord;
import com.api.vo.operationManagement.VoAttendanceLeaveRecord;
import com.api.vo.operationManagement.VoAttendanceRecord;

import java.util.List;
import java.util.Map;

public interface ButlerAttendanceService {
    Map<String, Object> todayClockRecord(Integer id);

    Map<String, Object> clock(AttendanceRecord attendanceRecord);

    List<VoAttendanceRecord> clockRecord(Integer id);

    List<VoAttendanceLeaveRecord> applyRecord(Integer id);

    Map<String, Object> apply(SysAttendanceLeaveRecord sysAttendanceLeaveRecord, Integer id);
}
