package com.api.manage.controller.butlerService;

import com.api.manage.service.butlerService.SysInspectionPlanService;
import com.api.manage.service.butlerService.SysInspectionPointService;

import com.api.model.butlerService.SearchInspectionExecute;
import com.api.model.butlerService.SearchInspectionPlan;
import com.api.model.butlerService.SysInspectionPlan;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.butlerService.VoBorrow;
import com.api.vo.butlerService.VoInspectionExecute;
import com.api.vo.butlerService.VoInspectionPlan;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 巡检计划管理
 */
@RestController
@RequestMapping("manage/inspectionPlan")
public class SysInspectionPlanController   {
    @Resource
    SysInspectionPlanService sysInspectionPlanService;

    /**
     * 查询所有的巡检计划信息(包含条件搜索)
     * @param searchInspectionPlan 搜索条件
     * @return map
     */
    @GetMapping("/list")
    @RequiresPermissions(value = {"0301"},logical = Logical.AND)
    public Map<String,Object> list(SearchInspectionPlan searchInspectionPlan){
        PageHelper.startPage(searchInspectionPlan.getPageNum(),searchInspectionPlan.getSize());
        List<VoInspectionPlan> voInspectionPlans = sysInspectionPlanService.list(searchInspectionPlan);
        PageInfo<VoInspectionPlan> pageInfo = new PageInfo<>(voInspectionPlans);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 添加巡检计划信息
     * @param sysInspectionPlan 巡检计划 model
     * @return map
     */
    @PostMapping("/insert")
    @RequiresPermissions(value = {"0303"},logical = Logical.AND)
    public Map<String,Object> insert(@RequestBody SysInspectionPlan sysInspectionPlan){
        return sysInspectionPlanService.insert(sysInspectionPlan);
    }


    /**
     * 根据巡检计划主键id查询巡检计划信息（不允许修改）
     * @param id 巡检计划主键id
     * @return map
     */
    @GetMapping("/findById")
    @RequiresPermissions(value = {"0305"},logical = Logical.AND)
    public Map<String,Object> findById(Integer id){
        return sysInspectionPlanService.findById(id);
    }

    /**
     * 假删除巡检计划
     * @param ids 巡检计划主键id数组
     * @return map
     */
    @PostMapping("/falseDelete")
    @RequiresPermissions(value = {"0304"},logical = Logical.AND)
    public Map<String,Object> falseDelete(@RequestBody VoIds ids){
        return sysInspectionPlanService.falseDelete(ids.getIds());
    }

    /**
     * 启用/停用 巡检计划
     * @param id 巡检计划主键id
     * @return map
     */
    @GetMapping("/isEnable")
    @RequiresPermissions(value = {"0315"},logical = Logical.AND)
    public Map<String,Object> isEnable(Integer id){
        return sysInspectionPlanService.isEnable(id);
    }


    /**
     * 查询所有的巡检执行记录信息(包含条件搜索)
     * @param searchInspectionExecute 搜索条件
     * @return map
     */
    @GetMapping("/executeList")
    public Map<String,Object> executeList(SearchInspectionExecute searchInspectionExecute){
        PageHelper.startPage(searchInspectionExecute.getPageNum(),searchInspectionExecute.getSize());
        List<VoInspectionExecute> voInspectionExecuteList = sysInspectionPlanService.executeList(searchInspectionExecute);
        PageInfo<VoInspectionExecute> pageInfo = new PageInfo<>(voInspectionExecuteList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

}
