package com.api.butlerApp.controller.jurisdiction;

import com.api.butlerApp.service.jurisdiction.ButlerRepairService;
import com.api.model.butlerApp.ButlerApplyDelayed;
import com.api.model.butlerApp.ButlerRepairSearch;
import com.api.model.butlerService.SysDispatchListDetail;
import com.api.vo.butlerApp.ButlerRepairVo;
import com.api.vo.butlerApp.ButlerVisitorVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 管家app 报事报修
 */
@RestController
@RequestMapping("butlerApp/user/repair")
public class ButlerRepairController {
    @Resource
    ButlerRepairService butlerRepairService;

    /**
     * 查询所有的报事报修信息(包含条件搜索)
     * @param butlerRepairSearch 搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(ButlerRepairSearch butlerRepairSearch){
        PageHelper.startPage(butlerRepairSearch.getPageNum(),butlerRepairSearch.getSize());
        List<ButlerRepairVo> butlerRepairVos =butlerRepairService.list(butlerRepairSearch);
        PageInfo<ButlerRepairVo> pageInfo = new PageInfo<>(butlerRepairVos);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }


    /**
     * 根据报事报修id查询报修详情
     * @param repairId 报事报修id
     * @param id 用户id
     * @param roleId 用户所拥有的角色id
     * @return map
     */
    @GetMapping("/findById")
    public Map<String,Object> findById(Integer repairId,Integer id,String roleId){
        return butlerRepairService.findById(repairId,id,roleId);
    }

    /**
     * 查询所有的工单时限信息(id and name)
     * @return map
     */
    @GetMapping("/findWorkOrderTimeLimit")
    public Map<String,Object> findWorkOrderTimeLimit(){
        return butlerRepairService.findWorkOrderTimeLimit();
    }


    /**
     * 查询所有的工单类型明细信息（工单子类信息）
     * @param workOrderTypeId 工单大类主键id
     * @return map
     */
    @GetMapping("/findWorkOrderTypeDetail")
    public Map<String,Object> findWorkOrderTypeDetail(Integer workOrderTypeId){
        return butlerRepairService.findWorkOrderTypeDetail(workOrderTypeId);
    }

    /**
     * 查询 维修部组织信息及人员
     * @return map
     */
    @GetMapping("/findRepairOrganization")
    public Map<String,Object> findRepairOrganization(){
        //房屋管理维修部 主键id为6
        int repairOrganizationId = 6;
        return butlerRepairService.findRepairOrganization(repairOrganizationId);
    }

    /**
     * 派单
     * @param sysDispatchListDetail 派工单详情信息
     * @param request butlerApp-admin-token获取的request管家用户信息
     * @return map
     */
    @PostMapping("/dispatch")
    public Map<String,Object> dispatch(@RequestBody SysDispatchListDetail sysDispatchListDetail, HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        //从request获取用户组织id
        String roleId = request.getParameter("roleId");
        //填入分配人
        sysDispatchListDetail.setCreateId(id);
        return butlerRepairService.dispatch(sysDispatchListDetail,roleId);
    }


    /**
     * 改派
     * @param dispatchListId 派工单id
     * @param operator 操作人（维修人）
     * @param roleId 用户所拥有的角色id
     * @param id 用户id
     * @return map
     */
    @GetMapping("/reassignment")
    public Map<String,Object> reassignment(Integer dispatchListId,Integer operator,String roleId,Integer id){
        return butlerRepairService.reassignment(dispatchListId,operator,roleId,id);
    }

    /**
     * 接单
     * @param dispatchId 派工单id
     * @param id 用户id
     * @param roleId 用户所拥有的角色id
     * @return map
     */
    @GetMapping("/receivingOrders")
    public Map<String,Object> receivingOrders(Integer dispatchId,Integer id,String roleId){
        return butlerRepairService.receivingOrders(dispatchId,id,roleId);
    }


    /**
     * 申请延时
     * @param butlerApplyDelayed 管家app 申请延时信息 model
     * @param request butlerApp-admin-token获取的request管家用户信息
     * @return map
     */
    @PostMapping("/applyDelayed")
    public Map<String,Object> applyDelayed(@RequestBody ButlerApplyDelayed butlerApplyDelayed,HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        return butlerRepairService.applyDelayed(butlerApplyDelayed,id);
    }


    /**
     * 处理完成
     * @return map
     */
    @PostMapping("/handleResult")
    public Map<String,Object> handleResult(){
        return null;
    }





}
