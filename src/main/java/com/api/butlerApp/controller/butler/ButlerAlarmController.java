package com.api.butlerApp.controller.butler;

import com.api.butlerApp.service.butler.ButlerAlarmService;
import com.api.manage.service.operationManagement.SysAlarmService;
import com.api.model.butlerApp.ButlerAppAlarm;
import com.api.vo.operationManagement.VoButlerOneButtonAlarm;
import com.api.vo.operationManagement.VoFireAlarm;
import com.api.vo.operationManagement.VoOneButtonAlarm;
import com.api.vo.operationManagement.VoPlanAlarm;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * app 一键报警
 */
@RestController
@RequestMapping("butlerApp/user/alarm")
public class ButlerAlarmController {
    @Resource
    ButlerAlarmService butlerAlarmService;
    @Resource
    SysAlarmService sysAlarmService;


    /**
     * 添加管家app报警记录
     * @param request app-admin-token获取的request用户信息
     * @return map
     */
    @PostMapping("/insertAlarmRecord")
    public Map<String,Object> insertAlarmRecord(HttpServletRequest request){
        //创建管家app 报警model 信息
        ButlerAppAlarm butlerAppAlarm = new ButlerAppAlarm();
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        butlerAppAlarm.setCreateId(id);
        butlerAppAlarm.setCreateDate(new Date());
        return butlerAlarmService.insertAlarmRecord(butlerAppAlarm);
    }

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
     * 查询业主app的一键报警记录
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

    /**
     * 查询管家app的一键报警记录
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @return map
     */
    @GetMapping("/butlerOneButtonAlarmList")
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


    /**
     * 查询预案的报警记录
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @return map
     */
    @GetMapping("/planAlarmList")
    public Map<String,Object> planAlarmList(int pageNum,int size){
        PageHelper.startPage(pageNum,size);
        List<VoPlanAlarm> voPlanAlarmList = sysAlarmService.planAlarmList();
        PageInfo<VoPlanAlarm> pageInfo = new PageInfo<>(voPlanAlarmList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 推送灾情解除通知
     * @param planAlertId 预案主键id
     * @return map
     */
    @GetMapping("/pushRelieveAlert")
    public Map<String,Object> pushRelieveAlert(Integer planAlertId){
        return sysAlarmService.pushRelieveAlert(planAlertId);
    }
}
