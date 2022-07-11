package com.api.manage.service.butlerService;

import com.api.model.butlerService.FacilitiesMaintenanceRecord;

import java.util.Map;

public interface SysFacilitiesMaintenanceRecordService {
    Map<String, Object> list(Integer facilitiesManageId);

    Map<String, Object> insert(FacilitiesMaintenanceRecord maintenanceRecord);

    Map<String, Object> delete(int[] ids);
}
