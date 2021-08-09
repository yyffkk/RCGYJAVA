package com.api.butlerApp.controller.jurisdiction;

import com.api.butlerApp.service.jurisdiction.ButlerRepairEngineeringService;
import com.api.model.butlerApp.ButlerRepairEngineering;
import com.api.model.butlerApp.ButlerRepairEngineeringMaintenanceResults;
import com.api.model.butlerApp.ButlerRepairEngineeringReport;
import com.api.model.butlerApp.ButlerRepairEngineeringSearch;
import com.api.vo.butlerApp.ButlerRepairEngineeringVo;
import com.api.vo.butlerApp.ButlerRepairVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 管家app 报事报修工程维修
 */
@RestController
@RequestMapping("butlerApp/user/repairEngineering")
public class ButlerRepairEngineeringController {
    @Resource
    ButlerRepairEngineeringService butlerRepairEngineeringService;

    /**
     * 查询所有的报事报修工程维修信息（包含条件搜索）
     * @param butlerRepairEngineeringSearch 管家app 报事报修-工程维修 搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(ButlerRepairEngineeringSearch butlerRepairEngineeringSearch){
        //查询用户所属权限,type:1.工程派单-维修公司 2.工程派单-维修人员 3.工程接单-维修人员，4.不具备任何权限
        int type = butlerRepairEngineeringService.findJurisdictionByUserId(butlerRepairEngineeringSearch.getRoleId());
        //分页查询信息
        PageHelper.startPage(butlerRepairEngineeringSearch.getPageNum(),butlerRepairEngineeringSearch.getSize());
        List<ButlerRepairEngineeringVo> butlerRepairEngineeringVoList =butlerRepairEngineeringService.list(butlerRepairEngineeringSearch,type);
        PageInfo<ButlerRepairEngineeringVo> pageInfo = new PageInfo<>(butlerRepairEngineeringVoList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 添加报事报修工程维修
     * @param butlerRepairEngineering 管家app 报事报修工程维修model
     * @param request butlerApp-admin-token获取的request管家用户信息
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody ButlerRepairEngineering butlerRepairEngineering, HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        butlerRepairEngineering.setCreateId(id);
        butlerRepairEngineering.setCreateDate(new Date());
        return butlerRepairEngineeringService.insert(butlerRepairEngineering);
    }

    /**
     * 根据工程维修主键id查询工程维修信息
     * @param repairEngineeringId 工程维修主键id
     * @return map
     */
    @GetMapping("/findById")
    public Map<String,Object> findById(Integer repairEngineeringId){
        return butlerRepairEngineeringService.findById(repairEngineeringId);
    }

    /**
     * 根据工程维修主键id查询工程报修进程
     * @param repairEngineeringId 工程维修主键id
     * @return map
     */
    @GetMapping("/findProcessRecordById")
    public Map<String,Object> findProcessRecordById(Integer repairEngineeringId){
        return butlerRepairEngineeringService.findProcessRecordById(repairEngineeringId);
    }

    /**
     * 查询所有的维修公司
     * @return map
     */
    @GetMapping("/findRepairOrganization")
    public Map<String,Object> findRepairOrganization(){
        return butlerRepairEngineeringService.findRepairOrganization();
    }


    /**
     * 工程维修维修公司派单
     * @param butlerRepairEngineering 管家app 报事报修工程维修model
     * @param request butlerApp-admin-token获取的request管家用户信息
     * @return map
     */
    @PostMapping("/maintenanceCompanySendSingle")
    public Map<String,Object> maintenanceCompanySendSingle(@RequestBody ButlerRepairEngineering butlerRepairEngineering, HttpServletRequest request){

        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        //从request获取用户联系方式
        String roleId = request.getParameter("roleId");
        butlerRepairEngineering.setMaintenanceCompanySendSingle(id);//填入维修公司派单人id
        butlerRepairEngineering.setMaintenanceCompanySendSingleDate(new Date());//填入维修公司派单时间

        //查询用户所属权限,type:1.工程派单-维修公司 2.工程派单-维修人员 3.工程接单-维修人员，4.不具备任何权限
        int type = butlerRepairEngineeringService.findJurisdictionByUserId(roleId);

        return butlerRepairEngineeringService.maintenanceCompanySendSingle(butlerRepairEngineering,type);
    }

    /**
     * 根据维修公司主键id查询维修人员信息
     * @param repairOrganizationId 维修公司主键id
     * @return 维修人员信息
     */
    @GetMapping("/findSysUserByOrganizationId")
    public Map<String,Object> findSysUserByOrganizationId(Integer repairOrganizationId){
        return butlerRepairEngineeringService.findSysUserByOrganizationId(repairOrganizationId);
    }

    /**
     * 工程维修维修人员派单
     * @param butlerRepairEngineering 管家app 报事报修工程维修model
     * @param request butlerApp-admin-token获取的request管家用户信息
     * @return map
     */
    @PostMapping("/maintenancePersonnelSendSingle")
    public Map<String,Object> maintenancePersonnelSendSingle(@RequestBody ButlerRepairEngineering butlerRepairEngineering, HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        //从request获取用户联系方式
        String roleId = request.getParameter("roleId");
        butlerRepairEngineering.setMaintenancePersonnelSendSingle(id);//填入维修人员派单人id
        butlerRepairEngineering.setMaintenancePersonnelSendSingleDate(new Date());//填入维修人员派单时间

        //查询用户所属权限,type:1.工程派单-维修公司 2.工程派单-维修人员 3.工程接单-维修人员，4.不具备任何权限
        int type = butlerRepairEngineeringService.findJurisdictionByUserId(roleId);

        return butlerRepairEngineeringService.maintenancePersonnelSendSingle(butlerRepairEngineering,type);
    }


    /**
     * 工程维修维修人员接单
     * @param butlerRepairEngineering 管家app 报事报修工程维修model
     * @param request butlerApp-admin-token获取的request管家用户信息
     * @return map
     */
    @PostMapping("/maintenanceStaffPickSingle")
    public Map<String,Object> maintenanceStaffPickSingle(@RequestBody ButlerRepairEngineering butlerRepairEngineering, HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        //从request获取用户联系方式
        String roleId = request.getParameter("roleId");
        butlerRepairEngineering.setMaintenanceStaff(id);//填入维修人员接单人id
        butlerRepairEngineering.setMaintenanceStaffPickSingleDate(new Date());//填入维修人员接单时间

        //查询用户所属权限,type:1.工程派单-维修公司 2.工程派单-维修人员 3.工程接单-维修人员，4.不具备任何权限
        int type = butlerRepairEngineeringService.findJurisdictionByUserId(roleId);

        return butlerRepairEngineeringService.maintenanceStaffPickSingle(butlerRepairEngineering,type);
    }


    /**
     * 提交工作汇报
     * @param butlerRepairEngineeringReport 管家app 报事报修工程维修工作汇报model
     * @param request butlerApp-admin-token获取的request管家用户信息
     * @return map
     */
    @PostMapping("/submitReport")
    public Map<String,Object> submitReport(@RequestBody ButlerRepairEngineeringReport butlerRepairEngineeringReport, HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        butlerRepairEngineeringReport.setCreateId(id);//填入创建人
        butlerRepairEngineeringReport.setCreateDate(new Date());//填入创建时间

        //从request获取用户联系方式
        String roleId = request.getParameter("roleId");
        //查询用户所属权限,type:1.工程派单-维修公司 2.工程派单-维修人员 3.工程接单-维修人员，4.不具备任何权限
        int type = butlerRepairEngineeringService.findJurisdictionByUserId(roleId);


        return butlerRepairEngineeringService.submitReport(butlerRepairEngineeringReport,type);
    }


    /**
     * 根据工程维修主键id查询工作日志
     * @param repairEngineeringId 工程维修主键id
     * @return map
     */
    @GetMapping("/findReportByRepairEngineeringId")
    public Map<String,Object> findReportByRepairEngineeringId(Integer repairEngineeringId){

        return butlerRepairEngineeringService.findReportByRepairEngineeringId(repairEngineeringId);
    }


    /**
     * 完成维修
     * @param butlerRepairEngineeringMaintenanceResults 管家app 报事报修工程维修 维修结果model
     * @param request butlerApp-admin-token获取的request管家用户信息
     * @return map
     */
    @PostMapping("/completeMaintenance")
    public Map<String,Object> completeMaintenance(@RequestBody ButlerRepairEngineeringMaintenanceResults butlerRepairEngineeringMaintenanceResults, HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        butlerRepairEngineeringMaintenanceResults.setCreateId(id);//填入创建人
        butlerRepairEngineeringMaintenanceResults.setCreateDate(new Date());//填入创建时间

        //从request获取用户联系方式
        String roleId = request.getParameter("roleId");
        //查询用户所属权限,type:1.工程派单-维修公司 2.工程派单-维修人员 3.工程接单-维修人员，4.不具备任何权限
        int type = butlerRepairEngineeringService.findJurisdictionByUserId(roleId);


        return butlerRepairEngineeringService.completeMaintenance(butlerRepairEngineeringMaintenanceResults,type);
    }

    /**
     * 根据工程维修主键id查询最新的维修结果
     * @param repairEngineeringId 工程维修主键id
     * @return map
     */
    @GetMapping("/findNewResultByRepairEngineeringId")
    public Map<String,Object> findNewResultByRepairEngineeringId(Integer repairEngineeringId){
        return butlerRepairEngineeringService.findNewResultByRepairEngineeringId(repairEngineeringId);
    }







}
