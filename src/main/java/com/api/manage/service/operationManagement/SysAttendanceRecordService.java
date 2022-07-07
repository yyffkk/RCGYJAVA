package com.api.manage.service.operationManagement;

import com.api.model.operationManagement.AttendanceRecord;
import com.api.model.operationManagement.SearchAttendanceLeaveRecord;
import com.api.model.operationManagement.SearchAttendanceRecord;
import com.api.model.operationManagement.SysAttendanceLeaveRecord;
import com.api.vo.operationManagement.VoAttendanceLeaveRecord;
import com.api.vo.operationManagement.VoAttendanceRecord;

import java.util.List;
import java.util.Map;

public interface SysAttendanceRecordService {
    List<VoAttendanceRecord> list(SearchAttendanceRecord searchAttendanceRecord);

    Map<String, Object> cardReplacement(AttendanceRecord attendanceRecord);

    List<VoAttendanceLeaveRecord> leaveList(SearchAttendanceLeaveRecord searchAttendanceLeaveRecord);

    Map<String, Object> reviewer(SysAttendanceLeaveRecord sysAttendanceLeaveRecord);
}
