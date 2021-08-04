package com.api.butlerApp.dao.jurisdiction;

import com.api.model.businessManagement.SysOrganization;
import com.api.model.butlerApp.ButlerRepairEngineering;
import com.api.model.butlerApp.ButlerRepairEngineeringSearch;
import com.api.model.butlerApp.ButlerReportRepairEngineeringProcessRecord;
import com.api.vo.butlerApp.ButlerRepairEngineeringFBIVo;
import com.api.vo.butlerApp.ButlerRepairEngineeringVo;
import com.api.vo.butlerApp.ButlerRepairVo;

import java.util.List;

public interface ButlerRepairEngineeringDao {
    /**
     * 查询所有的报事报修工程维修信息（包含条件搜索）【工程派单-维修公司】
     * @param butlerRepairEngineeringSearch 管家app 报事报修-工程维修 搜索条件
     * @return 报事报修工程维修信息
     */
    List<ButlerRepairEngineeringVo> list1(ButlerRepairEngineeringSearch butlerRepairEngineeringSearch);

    /**
     * 添加报事报修工程维修
     * @param butlerRepairEngineering 管家app 报事报修工程维修model
     * @return 影响行数
     */
    int insert(ButlerRepairEngineering butlerRepairEngineering);

    /**
     * 查询所有的报事报修工程维修信息（包含条件搜索）【工程派单-维修人员】
     * @param butlerRepairEngineeringSearch 管家app 报事报修-工程维修 搜索条件
     * @return 报事报修工程维修信息
     */
    List<ButlerRepairEngineeringVo> list2(ButlerRepairEngineeringSearch butlerRepairEngineeringSearch);

    /**
     * 查询所有的报事报修工程维修信息（包含条件搜索）【工程接单-维修人员】
     * @param butlerRepairEngineeringSearch 管家app 报事报修-工程维修 搜索条件
     * @return 报事报修工程维修信息
     */
    List<ButlerRepairEngineeringVo> list3(ButlerRepairEngineeringSearch butlerRepairEngineeringSearch);

    /**
     * 添加工程维修报修进程处理进程记录
     * @param engineeringProcessRecord 管家app 报事报修工程维修进程model
     * @return 影响行数
     */
    int insertProcessRecord(ButlerReportRepairEngineeringProcessRecord engineeringProcessRecord);

    /**
     * 根据工程维修主键id查询工程维修信息
     * @param repairEngineeringId 工程维修主键id
     * @return 工程维修信息
     */
    ButlerRepairEngineeringFBIVo findById(Integer repairEngineeringId);

    /**
     * 根据工程维修主键id查询工程报修进程
     * @param repairEngineeringId 工程维修主键id
     * @return 工程报修进程
     */
    List<ButlerReportRepairEngineeringProcessRecord> findProcessRecordById(Integer repairEngineeringId);

    /**
     * 查询所有的维修公司
     * @return 维修公司
     */
    List<SysOrganization> findRepairOrganization();
}
