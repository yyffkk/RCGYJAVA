package com.api.manage.controller.operationManagement;

import com.api.manage.service.operationManagement.SysAlarmService;
import com.api.vo.operationManagement.VoButlerOneButtonAlarm;
import com.api.vo.operationManagement.VoFireAlarm;
import com.api.vo.operationManagement.VoGreenArea;
import com.api.vo.operationManagement.VoOneButtonAlarm;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 报警管理
 */
@RestController
@RequestMapping("manage/alarm")
public class SysAlarmController {
    @Resource
    SysAlarmService sysAlarmService;

    /**
     * 查询所有的火灾报警记录
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @return map
     */
    @GetMapping("/fireAlarmList")
    @RequiresPermissions(value = {"0101"},logical = Logical.AND)
    public Map<String,Object> fireAlarmList(int pageNum,int size){
        PageHelper.startPage(pageNum,size);
        List<VoFireAlarm> voFireAlarmList = sysAlarmService.fireAlarmList();
        PageInfo<VoFireAlarm> pageInfo = new PageInfo<>(voFireAlarmList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }


    /**
     * 查询业主app的一键报警记录
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @return map
     */
    @GetMapping("/oneButtonAlarmList")
    @RequiresPermissions(value = {"0101"},logical = Logical.AND)
    public Map<String,Object> oneButtonAlarmList(int pageNum,int size){
        PageHelper.startPage(pageNum,size);
        List<VoOneButtonAlarm> voOneButtonAlarmList = sysAlarmService.oneButtonAlarmList();
        PageInfo<VoOneButtonAlarm> pageInfo = new PageInfo<>(voOneButtonAlarmList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 查询管家app的一键报警记录
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @return map
     */
    @GetMapping("/butlerOneButtonAlarmList")
    @RequiresPermissions(value = {"0101"},logical = Logical.AND)
    public Map<String,Object> butlerOneButtonAlarmList(int pageNum,int size){
        PageHelper.startPage(pageNum,size);
        List<VoButlerOneButtonAlarm> voButlerOneButtonAlarmList = sysAlarmService.butlerOneButtonAlarmList();
        PageInfo<VoButlerOneButtonAlarm> pageInfo = new PageInfo<>(voButlerOneButtonAlarmList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

}
