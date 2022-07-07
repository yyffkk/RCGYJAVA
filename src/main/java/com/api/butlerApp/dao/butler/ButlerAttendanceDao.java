package com.api.butlerApp.dao.butler;

import com.api.model.businessManagement.SysUser;
import com.api.model.butlerApp.ButlerUserIdAndToDay;
import com.api.model.operationManagement.AttendanceRecord;
import com.api.model.operationManagement.SysAttendanceLeaveRecord;
import com.api.vo.operationManagement.VoAttendanceLeaveRecord;
import com.api.vo.operationManagement.VoAttendanceRecord;

import java.util.List;

public interface ButlerAttendanceDao {
    /**
     * 当前用户今日打卡记录
     * @param userIdAndToDay 管家app 用户主键id 和 当前时间
     * @return 今日打卡记录
     */
    VoAttendanceRecord todayClockRecord(ButlerUserIdAndToDay userIdAndToDay);

    /**
     * 上下班打卡
     * @param attendanceRecord 考勤记录model
     * @return 影响行数
     */
    int clock(AttendanceRecord attendanceRecord);

    /**
     * 打卡记录
     * @param id 用户主键id
     * @return 打卡记录
     */
    List<VoAttendanceRecord> clockRecord(Integer id);

    /**
     * 加班/请假申请记录
     * @param id 用户主键id
     * @return 考勤请假/加班申请记录Vo list 回显
     */
    List<VoAttendanceLeaveRecord> applyRecord(Integer id);

    /**
     * 填写加班/请假申请
     * @param sysAttendanceLeaveRecord 考勤请假/加班记录model
     * @return 影响行数
     */
    int apply(SysAttendanceLeaveRecord sysAttendanceLeaveRecord);

    /**
     * 查询所有的需要执行考勤任务的物业人员信息(用户未删除，状态正常)
     * @return 需要执行考勤任务的物业人员信息
     */
    List<SysUser> findAllSysUer();

    /**
     * 添加考勤任务记录
     * @param attendanceRecord 考勤记录model
     * @return 影响行数
     */
    int autoAttendanceRecord(AttendanceRecord attendanceRecord);
}
