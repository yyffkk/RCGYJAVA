package com.api.manage.service.butlerService;

import com.api.model.butlerService.SearchInspectionPoint;
import com.api.model.butlerService.SysInspectionRoute;
import com.api.vo.butlerService.VoInspectionRoute;

import java.util.List;
import java.util.Map;

public interface SysInspectionRouteService {
    List<VoInspectionRoute> list(SearchInspectionPoint searchInspectionPoint);

    Map<String, Object> insert(SysInspectionRoute sysInspectionRoute);

    Map<String, Object> findById(Integer id);

    Map<String, Object> update(SysInspectionRoute sysInspectionRoute);

    Map<String, Object> falseDelete(int[] ids);

    Map<String, Object> isEnable(Integer id);
}
