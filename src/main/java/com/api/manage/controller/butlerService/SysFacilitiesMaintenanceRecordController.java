package com.api.manage.controller.butlerService;

import com.api.manage.service.butlerService.SysFacilitiesMaintenanceRecordService;
import com.api.model.butlerService.FacilitiesMaintenanceRecord;
import com.api.vo.basicArchives.VoIds;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 设施设备保养记录管理 设施预约-设施管理-设施设备保养记录管理：
 */
@RestController
@RequestMapping("manage/facilitiesMaintenanceRecord")
public class SysFacilitiesMaintenanceRecordController {
    @Resource
    SysFacilitiesMaintenanceRecordService maintenanceRecordService;

    /**
     * 根据设施设备主键id查询所有的保养记录信息
     * @param facilitiesManageId 设施设备主键id
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(Integer facilitiesManageId){
        return maintenanceRecordService.list(facilitiesManageId);
    }

    /**
     * 添加保养记录信息
     * @param maintenanceRecord 设施设备保养记录
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody FacilitiesMaintenanceRecord maintenanceRecord){
        return maintenanceRecordService.insert(maintenanceRecord);
    }

    /**
     * 根据保养记录主键id删除保养记录
     * @param ids 保养记录主键id数组
     * @return map
     */
    @PostMapping("/delete")
    public Map<String,Object> delete(@RequestBody VoIds ids){
        return maintenanceRecordService.delete(ids.getIds());
    }
}
