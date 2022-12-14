package com.api.manage.dao.butlerService;

import com.api.model.butlerService.*;
import com.api.vo.butlerService.VoFBIInspectionPlan;
import com.api.vo.butlerService.VoInspectionExecute;
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

    /**
     * 假删除巡检计划
     * @param id 巡检计划主键id
     * @return 影响行数
     */
    int falseDelete(int id);

    /**
     * 根据巡检计划主键id查询巡检计划状态
     * @param id 巡检计划主键id
     * @return 巡检计划状态
     */
    int findStatusById(Integer id);

    /**
     * 修改启用状态
     * @param planIdAndStatus 巡检计划主键id 和 状态
     * @return 影响行数
     */
    int updateStatus(PlanIdAndStatus planIdAndStatus);

    /**
     * 查询最新的一次计划当次巡检开始时间
     * @param id 巡检计划主键id
     * @return 巡检计划信息
     */
    SysInspectionExecute findNewPlan(Integer id);

    /**
     * 查询所有的巡检执行记录信息(包含条件搜索)
     * @param searchInspectionExecute 搜索条件
     * @return 巡检执行记录信息
     */
    List<VoInspectionExecute> executeList(SearchInspectionExecute searchInspectionExecute);
}
