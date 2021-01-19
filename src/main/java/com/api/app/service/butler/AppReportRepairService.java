package com.api.app.service.butler;

import com.api.model.app.UserIdAndRepairId;
import com.api.vo.app.AppReportRepairVo;

import java.util.List;
import java.util.Map;

public interface AppReportRepairService {
    List<AppReportRepairVo> list(Integer id);

    Map<String, Object> findById(UserIdAndRepairId userIdAndRepairId);
}
