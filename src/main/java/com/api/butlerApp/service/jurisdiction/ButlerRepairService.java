package com.api.butlerApp.service.jurisdiction;

import com.api.model.butlerApp.ButlerRepairSearch;
import com.api.vo.butlerApp.ButlerRepairVo;

import java.util.List;
import java.util.Map;

public interface ButlerRepairService {
    List<ButlerRepairVo> list(ButlerRepairSearch butlerRepairSearch);

    Map<String, Object> findById(Integer repairId, Integer id, String roleId);

    Map<String, Object> findWorkOrderTimeLimit();

    Map<String, Object> findWorkOrderTypeDetail(Integer workOrderTypeId);

    Map<String, Object> findRepairOrganization(int repairOrganizationId);
}
