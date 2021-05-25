package com.api.manage.dao.operationManagement;

import com.api.model.operationManagement.AttendanceRecord;
import com.api.model.operationManagement.SearchAttendanceLeaveRecord;
import com.api.model.operationManagement.SearchAttendanceRecord;
import com.api.model.operationManagement.SysAttendanceLeaveRecord;
import com.api.vo.operationManagement.VoAttendanceLeaveRecord;
import com.api.vo.operationManagement.VoAttendanceRecord;

import java.util.List;

public interface SysAttendanceRecordDao {
    /**
     * 查询所有的考勤打卡记录
     * @param searchAttendanceRecord 考勤打卡记录搜索条件
     * @return 考勤打卡记录
     */
    List<VoAttendanceRecord> list(SearchAttendanceRecord searchAttendanceRecord);

    /**
     * 补卡
     * @param attendanceRecord 考勤记录model
     * @return 影响行数
     */
    int cardReplacement(AttendanceRecord attendanceRecord);

    /**
     * 查询所有的请假/加班记录
     * @param searchAttendanceLeaveRecord 请假/加班记录搜索条件
     * @return 所有的请假/加班记录
     */
    List<VoAttendanceLeaveRecord> leaveList(SearchAttendanceLeaveRecord searchAttendanceLeaveRecord);

    /**
     * 审核
     * @param sysAttendanceLeaveRecord 考勤请假/加班记录model
     * @return 影响行数
     */
    int reviewer(SysAttendanceLeaveRecord sysAttendanceLeaveRecord);
}
