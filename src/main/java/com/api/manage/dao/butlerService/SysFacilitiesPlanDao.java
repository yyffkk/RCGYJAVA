package com.api.manage.dao.butlerService;

import com.api.model.butlerService.FacilitiesExecute;
import com.api.model.butlerService.FacilitiesPlan;
import com.api.model.butlerService.SearchFacilitiesPlan;
import com.api.vo.butlerService.VoFacilitiesPlan;

import java.util.Date;
import java.util.List;

public interface SysFacilitiesPlanDao {
    /**
     * 查询所有的设施设备检查计划
     * @param searchFacilitiesPlan 设施设备检查计划搜索条件
     * @return 设施设备检查计划
     */
    List<VoFacilitiesPlan> list(SearchFacilitiesPlan searchFacilitiesPlan);

    /**
     * 添加检查计划
     * @param facilitiesPlan 设施/设备检查计划model
     * @return 影响行数
     */
    int insertPlan(FacilitiesPlan facilitiesPlan);

    /**
     * 添加检查执行情况
     * @param facilitiesExecute 设施/设备检查执行情况
     * @return 影响行数
     */
    int insertExecute(FacilitiesExecute facilitiesExecute);

    /**
     * 删除检查计划信息
     * @param id 检查计划主键id
     * @return 影响行数
     */
    int falseDelete(int id);

    /**
     * 停用
     * @param id 检查计划主键id
     * @return 影响行数
     */
    int stop(int id);

    /**
     * 开启
     * @param id 检查计划主键id
     * @return 影响行数
     */
    int open(int id);

    /**
     * 查询最新的一次的检查状态
     * @param id 检查计划主键id
     * @return 检查执行情况
     */
    FacilitiesExecute findNewPlan(int id);

    /**
     * 根据检查计划主键id 查询 检查计划情况
     * @param id 检查计划主键id
     * @return 检查计划情况
     */
    FacilitiesPlan findById(int id);

    /**
     * 根据检查计划主键id 查询 检查计划情况(删除也能查到)
     * @param id 检查计划主键id
     * @return 检查计划情况
     */
    FacilitiesPlan findById2(int id);


    /**
     * 根据检查计划主键id查询检查执行数量
     * @param facilitiesPlanId 检查计划主键id
     * @return 检查执行数量
     */
    int countExecuteNumByPlanId(Integer facilitiesPlanId);


    /**
     * 根据当前时间，查询计划当次检查开始时间小于当天的 并状态为待完成的检查执行记录
     * @param date 当前时间
     * @return 检查执行记录
     */
    List<FacilitiesExecute> findOldExecuteByToday(Date date);

    /**
     * 修改当次检查情况状态为，3.未完成
     * @param id 检查执行情况主键id
     * @return 影响行数
     */
    int updateExecuteStatus(Integer id);

}
