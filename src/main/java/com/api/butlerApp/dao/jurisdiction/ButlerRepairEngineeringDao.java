package com.api.butlerApp.dao.jurisdiction;

import com.api.model.businessManagement.SysOrganization;
import com.api.model.businessManagement.SysUser;
import com.api.model.butlerApp.*;
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

    /**
     * 工程维修维修公司派单
     * @param butlerRepairEngineering 管家app 报事报修工程维修model
     * @return 影响行数
     */
    int maintenanceCompanySendSingle(ButlerRepairEngineering butlerRepairEngineering);

    /**
     * 根据维修公司主键id查询维修人员信息
     * @param repairOrganizationId 维修公司主键id
     * @return 维修人员信息
     */
    List<SysUser> findSysUserByOrganizationId(Integer repairOrganizationId);

    /**
     * 工程维修维修人员派单
     * @param butlerRepairEngineering 管家app 报事报修工程维修model
     * @return 影响行数
     */
    int maintenancePersonnelSendSingle(ButlerRepairEngineering butlerRepairEngineering);

    /**
     * 工程维修维修人员接单
     * @param butlerRepairEngineering 管家app 报事报修工程维修model
     * @return 影响行数
     */
    int maintenanceStaffPickSingle(ButlerRepairEngineering butlerRepairEngineering);

    /**
     * 提交工作汇报
     * @param butlerRepairEngineeringReport 管家app 报事报修工程维修工作汇报model
     * @return 影响行数
     */
    int submitReport(ButlerRepairEngineeringReport butlerRepairEngineeringReport);

    /**
     * 完成维修
     * @param butlerRepairEngineeringMaintenanceResults 管家app 报事报修工程维修 维修结果model
     * @return 影响行数
     */
    int completeMaintenance(ButlerRepairEngineeringMaintenanceResults butlerRepairEngineeringMaintenanceResults);

    /**
     * 修改工程维修状态
     * @param butlerRepairEngineering 管家app 报事报修工程维修model
     * @return 影响行数
     */
    int updateStatusById(ButlerRepairEngineering butlerRepairEngineering);
}
