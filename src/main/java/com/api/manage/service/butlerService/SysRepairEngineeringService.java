package com.api.manage.service.butlerService;

import com.api.model.butlerService.SearchRepairEngineering;
import com.api.vo.butlerService.VoRepairEngineering;

import java.util.List;
import java.util.Map;

public interface SysRepairEngineeringService {
    List<VoRepairEngineering> list(SearchRepairEngineering searchRepairEngineering);

    Map<String, Object> findById(Integer repairEngineeringId);
}
