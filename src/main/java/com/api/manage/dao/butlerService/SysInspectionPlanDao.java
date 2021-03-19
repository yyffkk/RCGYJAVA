package com.api.manage.dao.butlerService;

import com.api.model.butlerService.SearchInspectionPlan;
import com.api.model.butlerService.SysInspectionPlan;
import com.api.vo.butlerService.VoInspectionPlan;

import java.util.List;

public interface SysInspectionPlanDao {
    /**
     * 查询所有的巡检计划信息(包含条件搜索)
     * @param searchInspectionPlan 巡检计划 搜索条件
     * @return 巡检计划信息集合
     */
    List<VoInspectionPlan> list(SearchInspectionPlan searchInspectionPlan);

    /**
     * 添加巡检计划信息
     * @param sysInspectionPlan 巡检计划 model
     * @return 影响行数
     */
    int insert(SysInspectionPlan sysInspectionPlan);
}
