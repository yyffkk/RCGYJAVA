package com.api.manage.dao.operationManagement;

import com.api.model.operationManagement.SearchAttendanceSchedulingPlan;
import com.api.model.operationManagement.SysAttendanceSchedulingPlan;
import com.api.model.operationManagement.SysAttendanceSchedulingPlanDetail;
import com.api.model.operationManagement.SysAttendanceSchedulingPlanException;
import com.api.vo.operationManagement.VoAttendanceSchedulingPlan;

import java.util.List;

public interface SysAttendanceSchedulingPlanDao {
    /**
     * 查询所有的考勤排班计划（包含条件搜索）
     * @param searchAttendanceSchedulingPlan 考勤排班计划搜索条件
     * @return 考勤排班计划
     */
    List<VoAttendanceSchedulingPlan> list(SearchAttendanceSchedulingPlan searchAttendanceSchedulingPlan);

    /**
     * 添加考勤排班计划
     * @param sysAttendanceSchedulingPlan 考勤排班计划model
     * @return 影响行数
     */
    int insert(SysAttendanceSchedulingPlan sysAttendanceSchedulingPlan);

    /**
     * 添加考勤排班计划详情
     * @param planDetail 排班计划详情model
     * @return 影响行数
     */
    int insertDetail(SysAttendanceSchedulingPlanDetail planDetail);

    /**
     * 添加考勤排班计划例外情况
     * @param planException 考勤排班计划例外情况model
     * @return 影响行数
     */
    int insertException(SysAttendanceSchedulingPlanException planException);
}
