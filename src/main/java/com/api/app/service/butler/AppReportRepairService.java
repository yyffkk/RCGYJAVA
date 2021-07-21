package com.api.app.service.butler;

import com.api.model.app.AppRepairEvaluate;
import com.api.model.app.UserIdAndRepairId;
import com.api.model.butlerService.ReportRepair;
import com.api.vo.app.AppReportRepairVo;

import java.util.List;
import java.util.Map;

public interface AppReportRepairService {
    List<AppReportRepairVo> list(Integer id);

    Map<String, Object> findById(UserIdAndRepairId userIdAndRepairId);

    Map<String, Object> insert(ReportRepair reportRepair, Integer id, String tel, String name);

    Map<String, Object> falseDelete(int[] ids, Integer id);

    Map<String, Object> cancel(UserIdAndRepairId userIdAndRepairId, String name);

    Map<String, Object> completeOrder(UserIdAndRepairId userIdAndRepairId, String name);

    Map<String, Object> evaluate(AppRepairEvaluate appRepairEvaluate);
}
