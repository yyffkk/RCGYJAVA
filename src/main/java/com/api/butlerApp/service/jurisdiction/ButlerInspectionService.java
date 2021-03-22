package com.api.butlerApp.service.jurisdiction;

import com.api.model.butlerApp.ButlerInspectionSearch;
import com.api.vo.butlerApp.ButlerInspectionVo;

import java.util.List;
import java.util.Map;

public interface ButlerInspectionService {
    List<ButlerInspectionVo> list(ButlerInspectionSearch butlerInspectionSearch);

    Map<String, Object> findDetailById(Integer executeId);

    Map<String, Object> findPointByPlanId(Integer planId);

    Map<String, Object> findPointByExecuteId(Integer executeId);

    Map<String, Object> startInspection(Integer executeId, String roleId);

    Map<String, Object> findCheckDetailByQR(Integer executeId, Integer executePointId, String roleId);
}
