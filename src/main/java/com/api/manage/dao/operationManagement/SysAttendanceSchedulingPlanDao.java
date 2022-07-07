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

    /**
     * 根据考勤排班计划主键id查询考勤排班计划
     * @param id 考勤排班计划主键id
     * @return 考勤排班计划
     */
    SysAttendanceSchedulingPlan findById(int id);

    /**
     * 根据考勤排班计划主键id删除考勤排班计划例外情况
     * @param id 根据考勤排班计划主键id
     * @return 影响行数
     */
    int deleteException(int id);

    /**
     * 根据考勤排班计划主键id删除考勤排班计划详情
     * @param id 根据考勤排班计划主键id
     * @return 影响行数
     */
    int deleteDetail(int id);

    /**
     * 根据考勤排班计划主键id删除考勤排班计划
     * @param id 根据考勤排班计划主键id
     * @return 影响行数
     */
    int delete(int id);

    /**
     * 先根据考勤排班计划主键id 修改 考勤排班计划
     * @param sysAttendanceSchedulingPlan 考勤排班计划主键id
     * @return 影响行数
     */
    int update(SysAttendanceSchedulingPlan sysAttendanceSchedulingPlan);

    /**
     * 查询该用户今日（按年月日算）是否有开启的排班计划例外情况
     * @param id 用户主键id
     * @return 排班计划例外情况
     */
    SysAttendanceSchedulingPlanException findExceptionByToday(Integer id);

    /**
     * 查询该用户今日（按周几来算）是否有开启的排班计划
     * @param id 用户主键id
     * @return 排班计划
     */
    SysAttendanceSchedulingPlanDetail findExceptionByWeek(int id);

    /**
     * 根据排班计划主键id修改排班计划状态
     * @param byId 考勤排班计划model
     * @return 影响行数
     */
    int updateStatusById(SysAttendanceSchedulingPlan byId);
}
