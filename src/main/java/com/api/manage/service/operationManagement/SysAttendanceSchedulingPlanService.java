package com.api.manage.service.operationManagement;

import com.api.model.operationManagement.SearchAttendanceSchedulingPlan;
import com.api.model.operationManagement.SysAttendanceSchedulingPlan;
import com.api.vo.operationManagement.VoAttendanceSchedulingPlan;

import java.util.List;
import java.util.Map;

public interface SysAttendanceSchedulingPlanService {
    List<VoAttendanceSchedulingPlan> list(SearchAttendanceSchedulingPlan searchAttendanceSchedulingPlan);

    Map<String, Object> insert(SysAttendanceSchedulingPlan sysAttendanceSchedulingPlan);

    Map<String, Object> delete(int[] ids);

    Map<String, Object> update(SysAttendanceSchedulingPlan sysAttendanceSchedulingPlan);

    Map<String, Object> enable(Integer id);

    Map<String, Object> findById(Integer id);
}
