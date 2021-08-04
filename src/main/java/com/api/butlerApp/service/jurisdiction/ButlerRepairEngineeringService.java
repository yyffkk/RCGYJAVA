package com.api.butlerApp.service.jurisdiction;

import com.api.model.butlerApp.ButlerRepairEngineering;
import com.api.model.butlerApp.ButlerRepairEngineeringSearch;
import com.api.vo.butlerApp.ButlerRepairEngineeringVo;

import java.util.List;
import java.util.Map;

public interface ButlerRepairEngineeringService {
    List<ButlerRepairEngineeringVo> list(ButlerRepairEngineeringSearch butlerRepairEngineeringSearch, int type);

    Map<String, Object> insert(ButlerRepairEngineering butlerRepairEngineering);

    int findJurisdictionByUserId(String roleId);
}
