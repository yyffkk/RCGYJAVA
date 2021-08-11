package com.api.manage.dao.butlerService;

import com.api.model.butlerService.SearchRepairEngineering;
import com.api.vo.butlerService.*;

import java.util.List;

public interface SysRepairEngineeringDao {
    /**
     * 查询所有的工程维修信息
     * @param searchRepairEngineering 报事报修工程维修 搜索条件
     * @return 工程维修信息
     */
    List<VoRepairEngineering> list(SearchRepairEngineering searchRepairEngineering);

    /**
     * 根据工程维修主键Id查询工程维修信息
     * @param repairEngineeringId 工程维修主键Id
     * @return 工程维修信息
     */
    VoRepairEngineeringFBI findById(Integer repairEngineeringId);

    /**
     * 根据工程维修主键id查询工程维修信息
     * @param repairEngineeringId 工程维修主键id
     * @return 工程维修信息
     */
    List<VoRepairEngineeringReport> findReportByRepairEngineeringId(Integer repairEngineeringId);

    /**
     * 根据工程维修主键id查询处理进程记录
     * @param repairEngineeringId 工程维修主键id
     * @return 处理进程记录
     */
    List<VoRepairEngineeringProcessRecord> findRecordByRepairEngineeringId(Integer repairEngineeringId);

    /**
     * 根据工程维修主键id查询验收结果
     * @param repairEngineeringId 工程维修主键id
     * @return 验收结果
     */
    List<VoRepairEngineeringMaintenanceResults> findResultsByRepairEngineeringId(Integer repairEngineeringId);
}
