package com.api.manage.service.butlerService;

import com.api.model.butlerService.SearchInspectionPlan;
import com.api.model.butlerService.SysInspectionPlan;
import com.api.vo.butlerService.VoInspectionPlan;

import java.util.List;
import java.util.Map;

public interface SysInspectionPlanService {
    List<VoInspectionPlan> list(SearchInspectionPlan searchInspectionPlan);

    Map<String, Object> insert(SysInspectionPlan sysInspectionPlan);
}
