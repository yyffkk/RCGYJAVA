package com.api.butlerApp.service.jurisdiction;

import com.api.model.butlerApp.ButlerRepairEngineering;
import com.api.model.butlerApp.ButlerRepairEngineeringSearch;
import com.api.vo.butlerApp.ButlerRepairVo;

import java.util.List;
import java.util.Map;

public interface ButlerRepairEngineeringService {
    List<ButlerRepairVo> list(ButlerRepairEngineeringSearch butlerRepairEngineeringSearch);

    Map<String, Object> insert(ButlerRepairEngineering butlerRepairEngineering);
}
