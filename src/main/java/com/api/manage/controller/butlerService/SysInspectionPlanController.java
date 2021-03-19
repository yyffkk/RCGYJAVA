package com.api.manage.controller.butlerService;

import com.api.manage.service.butlerService.SysInspectionPlanService;
import com.api.manage.service.butlerService.SysInspectionPointService;
import com.api.model.butlerService.SearchInspectionPlan;
import com.api.model.butlerService.SysInspectionPlan;
import com.api.vo.butlerService.VoBorrow;
import com.api.vo.butlerService.VoInspectionPlan;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
public class SysInspectionPlanController {
    @Resource
    SysInspectionPlanService sysInspectionPlanService;

    /**
     * 查询所有的巡检计划信息(包含条件搜索)
     * @param searchInspectionPlan 搜索条件
     * @return map
     */
    @GetMapping("/list")
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
    public Map<String,Object> insert(@RequestBody SysInspectionPlan sysInspectionPlan){
        return sysInspectionPlanService.insert(sysInspectionPlan);
    }
}
