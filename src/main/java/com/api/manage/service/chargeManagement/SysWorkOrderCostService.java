package com.api.manage.service.chargeManagement;

import com.api.model.chargeManagement.SearchDailyPayment;
import com.api.vo.chargeManagement.VoWorkOrderCost;

import java.util.List;
import java.util.Map;

public interface SysWorkOrderCostService {
    List<VoWorkOrderCost> list(SearchDailyPayment searchDailyPayment);

    Map<String, Object> falseDelete(int[] ids);
}
