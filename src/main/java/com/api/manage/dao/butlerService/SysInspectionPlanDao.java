package com.api.manage.dao.butlerService;

import com.api.model.butlerService.SearchInspectionPlan;
import com.api.model.butlerService.SysInspectionExecute;
import com.api.model.butlerService.SysInspectionPlan;
import com.api.vo.butlerService.VoFBIInspectionPlan;
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

    /**
     * 添加第一次执行巡检信息
     * @param sysInspectionExecute 巡检执行情况
     * @return 影响行数
     */
    int insertExecute(SysInspectionExecute sysInspectionExecute);

    /**
     * 根据巡检计划主键id查询巡检计划信息
     * @param id 巡检计划主键id
     * @return 巡检计划信息
     */
    VoFBIInspectionPlan findById(Integer id);
}
