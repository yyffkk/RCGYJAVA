package com.api.butlerApp.service.jurisdiction;

import com.api.model.butlerApp.ButlerRepairEngineeringSearch;
import com.api.vo.butlerApp.ButlerRepairVo;

import java.util.List;

public interface ButlerRepairEngineeringService {
    List<ButlerRepairVo> list(ButlerRepairEngineeringSearch butlerRepairEngineeringSearch);
}
