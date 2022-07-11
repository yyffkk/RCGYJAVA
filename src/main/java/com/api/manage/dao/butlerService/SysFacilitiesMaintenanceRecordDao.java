package com.api.manage.dao.butlerService;

import com.api.model.butlerService.FacilitiesMaintenanceRecord;
import com.api.vo.butlerService.VoFacilitiesMaintenanceRecord;

import java.util.List;

public interface SysFacilitiesMaintenanceRecordDao {
    /**
     * 查询所有的保养记录信息
     * @param facilitiesManageId 设施设备主键id
     * @return 保养记录信息集合
     */
    List<VoFacilitiesMaintenanceRecord> list(Integer facilitiesManageId);

    /**
     * 添加保养记录信息
     * @param maintenanceRecord 设施设备保养记录
     * @return 影响行数
     */
    int insert(FacilitiesMaintenanceRecord maintenanceRecord);

    /**
     * 根据保养记录主键id删除保养记录
     * @param id 保养记录主键id
     * @return 影响行数
     */
    int delete(Integer id);
}
