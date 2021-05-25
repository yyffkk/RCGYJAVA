package com.api.manage.controller.operationManagement;


import com.api.manage.service.operationManagement.SysAttendanceRecordService;
import com.api.model.operationManagement.AttendanceRecord;
import com.api.model.operationManagement.SearchAttendanceLeaveRecord;
import com.api.model.operationManagement.SearchAttendanceRecord;
import com.api.model.operationManagement.SysAttendanceLeaveRecord;
import com.api.vo.operationManagement.VoAnnouncementManagement;
import com.api.vo.operationManagement.VoAttendanceLeaveRecord;
import com.api.vo.operationManagement.VoAttendanceRecord;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 考勤打卡记录管理
 */
@RestController
@RequestMapping("manage/attendanceRecord")
public class SysAttendanceRecordController {
    @Resource
    SysAttendanceRecordService sysAttendanceRecordService;

    /**
     * 查询所有的考勤打卡记录
     * @param searchAttendanceRecord 考勤打卡记录搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(SearchAttendanceRecord searchAttendanceRecord){
        PageHelper.startPage(searchAttendanceRecord.getPageNum(),searchAttendanceRecord.getSize());
        List<VoAttendanceRecord> voAttendanceRecordList = sysAttendanceRecordService.list(searchAttendanceRecord);
        PageInfo<VoAttendanceRecord> pageInfo = new PageInfo<>(voAttendanceRecordList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 补卡
     * @param attendanceRecord 考勤记录model
     * @return map
     */
    @GetMapping("/cardReplacement")
    public Map<String,Object> cardReplacement(AttendanceRecord attendanceRecord){
        return sysAttendanceRecordService.cardReplacement(attendanceRecord);
    }

    /**
     * 查询所有的请假/加班记录
     * @param searchAttendanceLeaveRecord 请假/加班记录搜索条件
     * @return map
     */
    @GetMapping("/leaveList")
    public Map<String,Object> leaveList(SearchAttendanceLeaveRecord searchAttendanceLeaveRecord){
        PageHelper.startPage(searchAttendanceLeaveRecord.getPageNum(),searchAttendanceLeaveRecord.getSize());
        List<VoAttendanceLeaveRecord> voAttendanceLeaveRecordList = sysAttendanceRecordService.leaveList(searchAttendanceLeaveRecord);
        PageInfo<VoAttendanceLeaveRecord> pageInfo = new PageInfo<>(voAttendanceLeaveRecordList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 审核
     * @param sysAttendanceLeaveRecord 考勤请假/加班记录model
     * @return map
     */
    @PostMapping("/reviewer")
    public Map<String,Object> reviewer(@RequestBody SysAttendanceLeaveRecord sysAttendanceLeaveRecord){
        return sysAttendanceRecordService.reviewer(sysAttendanceLeaveRecord);
    }


}
