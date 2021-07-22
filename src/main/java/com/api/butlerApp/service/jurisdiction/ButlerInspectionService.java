package com.api.butlerApp.service.jurisdiction;

import com.api.model.butlerApp.ButlerExecuteMap;
import com.api.model.butlerApp.ButlerExecutePointSubmit;
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

    Map<String, Object> findCheckDetailByQR(Integer executeId, String executePointCode, String roleId);

    Map<String, Object> submitPointDetail(ButlerExecutePointSubmit executePointSubmit, String roleId, Integer id, String name, Integer organizationId);

    Map<String, Object> findCheckDetailById(Integer executePointId);

    Map<String, Object> findCheckDetailById2(Integer planPointId);

    Map<String, Object> uploadLocation(ButlerExecuteMap butlerExecuteMap, String roleId);

    Map<String, Object> getLocation(Integer executeId);

}
