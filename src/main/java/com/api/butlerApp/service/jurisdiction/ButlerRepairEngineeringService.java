package com.api.butlerApp.service.jurisdiction;

import com.api.model.butlerApp.ButlerRepairEngineering;
import com.api.model.butlerApp.ButlerRepairEngineeringMaintenanceResults;
import com.api.model.butlerApp.ButlerRepairEngineeringReport;
import com.api.model.butlerApp.ButlerRepairEngineeringSearch;
import com.api.vo.butlerApp.ButlerRepairEngineeringVo;

import java.util.List;
import java.util.Map;

public interface ButlerRepairEngineeringService {
    List<ButlerRepairEngineeringVo> list(ButlerRepairEngineeringSearch butlerRepairEngineeringSearch, int type);

    Map<String, Object> insert(ButlerRepairEngineering butlerRepairEngineering);

    int findJurisdictionByUserId(String roleId);

    Map<String, Object> findById(Integer repairEngineeringId);

    Map<String, Object> findProcessRecordById(Integer repairEngineeringId);

    Map<String, Object> findRepairOrganization();

    Map<String, Object> maintenanceCompanySendSingle(ButlerRepairEngineering butlerRepairEngineering, int type);

    Map<String, Object> findSysUserByOrganizationId(Integer repairOrganizationId);

    Map<String, Object> maintenancePersonnelSendSingle(ButlerRepairEngineering butlerRepairEngineering, int type);

    Map<String, Object> maintenanceStaffPickSingle(ButlerRepairEngineering butlerRepairEngineering, int type);

    Map<String, Object> submitReport(ButlerRepairEngineeringReport butlerRepairEngineeringReport, int type);

    Map<String, Object> completeMaintenance(ButlerRepairEngineeringMaintenanceResults butlerRepairEngineeringMaintenanceResults, int type);
}
