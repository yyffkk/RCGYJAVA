package com.api.manage.controller.operationManagement;

import com.api.manage.service.operationManagement.SysAttendanceSchedulingPlanService;
import com.api.model.operationManagement.SearchAttendanceSchedulingPlan;
import com.api.model.operationManagement.SysAttendanceSchedulingPlan;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.operationManagement.VoAttendanceSchedulingPlan;
import com.api.vo.operationManagement.VoAttendanceTeam;
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
 * 考勤排班计划管理
 */
@RestController
@RequestMapping("manage/attendanceSchedulingPlan")
public class SysAttendanceSchedulingPlanController {
    @Resource
    SysAttendanceSchedulingPlanService sysAttendanceSchedulingPlanService;

    /**
     * 查询所有的考勤排班计划（包含条件搜索）
     * @param searchAttendanceSchedulingPlan 考勤排班计划搜索条件
     * @return map
     */
    @GetMapping("/list")
    @RequiresPermissions(value = {"0101"},logical = Logical.AND)
    public Map<String,Object> list(SearchAttendanceSchedulingPlan searchAttendanceSchedulingPlan){
        PageHelper.startPage(searchAttendanceSchedulingPlan.getPageNum(),searchAttendanceSchedulingPlan.getSize());
        List<VoAttendanceSchedulingPlan> voAttendanceSchedulingPlanList = sysAttendanceSchedulingPlanService.list(searchAttendanceSchedulingPlan);
        PageInfo<VoAttendanceSchedulingPlan> pageInfo = new PageInfo<>(voAttendanceSchedulingPlanList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 添加考勤排班计划
     * @param sysAttendanceSchedulingPlan 考勤排班计划model
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody SysAttendanceSchedulingPlan sysAttendanceSchedulingPlan){
        return sysAttendanceSchedulingPlanService.insert(sysAttendanceSchedulingPlan);
    }

    /**
     * 删除考勤排班计划
     * @param ids 考勤排班计划主键id数组
     * @return map
     */
    @PostMapping("/delete")
    public Map<String,Object> delete(@RequestBody VoIds ids){
        return sysAttendanceSchedulingPlanService.delete(ids.getIds());
    }

    /**
     * 修改考勤排班计划
     * @param sysAttendanceSchedulingPlan 考勤排班计划model
     * @return map
     */
    @PostMapping("/update")
    public Map<String,Object> update(@RequestBody SysAttendanceSchedulingPlan sysAttendanceSchedulingPlan){
        return sysAttendanceSchedulingPlanService.update(sysAttendanceSchedulingPlan);
    }

    /**
     * 开启/关闭考勤排班计划
     * @param id 考勤排班计划主键Id
     * @return map
     */
    @GetMapping("/enable")
    public Map<String,Object> enable(Integer id){
        return sysAttendanceSchedulingPlanService.enable(id);
    }

    /**
     * 根据考勤排班计划主键id查询考勤排班计划详情
     * @param id 考勤排班计划主键id
     * @return 考勤排班计划详情
     */
    @GetMapping("/findById")
    public Map<String,Object> findById(Integer id){
        return sysAttendanceSchedulingPlanService.findById(id);
    }



}
