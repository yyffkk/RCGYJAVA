package com.api.manage.controller.operationManagement;

import com.api.manage.service.operationManagement.SysAlarmService;
import com.api.vo.operationManagement.VoFireAlarm;
import com.api.vo.operationManagement.VoGreenArea;
import com.api.vo.operationManagement.VoOneButtonAlarm;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
     * 查询所有的一键报警记录
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @return map
     */
    @GetMapping("/oneButtonAlarmList")
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

}
