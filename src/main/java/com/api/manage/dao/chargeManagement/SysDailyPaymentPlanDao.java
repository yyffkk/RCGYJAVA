package com.api.manage.dao.chargeManagement;

import com.api.model.chargeManagement.DailyPaymentPlan;
import com.api.model.chargeManagement.SearchDailyPaymentPlan;
import com.api.vo.chargeManagement.VoDailyPaymentPlan;

import java.util.List;

public interface SysDailyPaymentPlanDao {
    /**
     * 查询所有的缴费计划
     * @param searchDailyPaymentPlan 缴费计划搜索条件
     * @return 缴费计划信息
     */
    List<VoDailyPaymentPlan> list(SearchDailyPaymentPlan searchDailyPaymentPlan);

    /**
     * 添加缴费计划
     * @param dailyPaymentPlan 缴费计划（周期生成缴费记录）
     * @return 影响行数
     */
    int insert(DailyPaymentPlan dailyPaymentPlan);

    /**
     * 修改缴费计划
     * @param dailyPaymentPlan 缴费计划（周期生成缴费记录）
     * @return 影响行数
     */
    int update(DailyPaymentPlan dailyPaymentPlan);

    /**
     * 删除缴费计划
     * @param id 缴费计划主键id
     * @return 影响行数
     */
    int delete(int id);

    /**
     * 查询 未删除并且未结束 的缴费计划(可用的缴费计划)
     * @return 缴费计划
     */
    List<DailyPaymentPlan> findEnableDPP();

}
