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
}
