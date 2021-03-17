package com.api.manage.service.butlerService;

import com.api.model.butlerService.SearchInspectionPoint;
import com.api.model.butlerService.SysInspectionPoint;
import com.api.vo.butlerService.VoInspectionPoint;

import java.util.List;
import java.util.Map;

public interface SysInspectionPointService {
    List<VoInspectionPoint> list(SearchInspectionPoint searchInspectionPoint);

    Map<String, Object> insert(SysInspectionPoint sysInspectionPoint);
}
