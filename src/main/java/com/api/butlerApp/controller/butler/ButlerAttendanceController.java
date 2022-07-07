package com.api.butlerApp.controller.butler;

import com.api.butlerApp.service.butler.ButlerAttendanceService;
import com.api.model.operationManagement.AttendanceRecord;
import com.api.model.operationManagement.SysAttendanceLeaveRecord;
import com.api.vo.butlerApp.ButlerAnnouncementVo;
import com.api.vo.operationManagement.VoAttendanceLeaveRecord;
import com.api.vo.operationManagement.VoAttendanceRecord;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 管家app 考勤管理
 */
@RestController
@RequestMapping("butlerApp/user/attendance")
public class ButlerAttendanceController {
    @Resource
    ButlerAttendanceService butlerAttendanceService;

    /**
     * 查询当前用户今日打卡记录
     * @param id 用户主键id
     * @return map
     */
    @GetMapping("/todayClockRecord")
    public Map<String,Object> todayClockRecord(Integer id){
        return butlerAttendanceService.todayClockRecord(id);
    }


    /**
     * 上下班打卡
     * @param attendanceRecord 考勤记录model
     * @param request butlerApp-admin-token获取的request管家用户信息
     * @return map
     */
    @PostMapping("/clock")
    public Map<String,Object> clock(@RequestBody AttendanceRecord attendanceRecord, HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        attendanceRecord.setClockId(id);//填入打卡人id
        return butlerAttendanceService.clock(attendanceRecord);
    }

    /**
     * 打卡记录
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @param id 用户主键id
     * @return map
     */
    @GetMapping("/clockRecord")
    public Map<String,Object> clockRecord(int pageNum,int size,Integer id){
        PageHelper.startPage(pageNum,size);
        List<VoAttendanceRecord> voAttendanceRecordList =butlerAttendanceService.clockRecord(id);
        PageInfo<VoAttendanceRecord> pageInfo = new PageInfo<>(voAttendanceRecordList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 加班/请假申请记录
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @param id 用户主键id
     * @return map
     */
    @GetMapping("/applyRecord")
    public Map<String,Object> applyRecord(int pageNum,int size,Integer id){
        PageHelper.startPage(pageNum,size);
        List<VoAttendanceLeaveRecord> voAttendanceLeaveRecordList =butlerAttendanceService.applyRecord(id);
        PageInfo<VoAttendanceLeaveRecord> pageInfo = new PageInfo<>(voAttendanceLeaveRecordList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 填写加班/请假申请
     * @param sysAttendanceLeaveRecord 考勤请假/加班记录model
     * @param request butlerApp-admin-token获取的request管家用户信息
     * @return map
     */
    @PostMapping("/apply")
    public Map<String,Object> apply(@RequestBody SysAttendanceLeaveRecord sysAttendanceLeaveRecord, HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        return butlerAttendanceService.apply(sysAttendanceLeaveRecord,id);
    }
}
