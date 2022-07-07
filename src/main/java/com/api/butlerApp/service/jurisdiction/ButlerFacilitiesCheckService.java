package com.api.butlerApp.service.jurisdiction;

import com.api.model.butlerApp.ButlerFacilitiesCheckSearch;
import com.api.model.butlerService.FacilitiesExecute;
import com.api.vo.butlerApp.ButlerFacilitiesCheckVo;

import java.util.List;
import java.util.Map;

public interface ButlerFacilitiesCheckService {
    List<ButlerFacilitiesCheckVo> list(ButlerFacilitiesCheckSearch butlerFacilitiesCheckSearch);

    Map<String, Object> submitCheck(FacilitiesExecute facilitiesExecute, Integer id, String name, Integer organizationId);
}
