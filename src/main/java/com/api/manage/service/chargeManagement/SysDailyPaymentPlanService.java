package com.api.manage.service.chargeManagement;

import com.api.model.chargeManagement.DailyPaymentPlan;
import com.api.model.chargeManagement.SearchDailyPaymentPlan;
import com.api.vo.chargeManagement.VoDailyPaymentPlan;

import java.util.List;
import java.util.Map;

public interface SysDailyPaymentPlanService {
    List<VoDailyPaymentPlan> list(SearchDailyPaymentPlan searchDailyPaymentPlan);

    Map<String, Object> insert(DailyPaymentPlan dailyPaymentPlan);

    Map<String, Object> update(DailyPaymentPlan dailyPaymentPlan);

    Map<String, Object> delete(int[] ids);
}
