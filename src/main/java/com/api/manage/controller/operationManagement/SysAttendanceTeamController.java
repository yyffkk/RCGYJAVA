package com.api.manage.controller.operationManagement;

import com.api.manage.service.operationManagement.SysAttendanceTeamService;
import com.api.model.operationManagement.SearchAttendanceTeam;
import com.api.model.operationManagement.SysAttendanceTeam;
import com.api.vo.operationManagement.VoAttendanceRecord;
import com.api.vo.operationManagement.VoAttendanceTeam;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 考勤小组管理
 */
@RestController
@RequestMapping("manage/attendanceTeam")
public class SysAttendanceTeamController {
    @Resource
    SysAttendanceTeamService sysAttendanceTeamService;

    /**
     * 查询所有的考勤小组信息(包含条件搜索)
     * @param searchAttendanceTeam 考勤小组管理 搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(SearchAttendanceTeam searchAttendanceTeam){
        PageHelper.startPage(searchAttendanceTeam.getPageNum(),searchAttendanceTeam.getSize());
        List<VoAttendanceTeam> voAttendanceTeamList = sysAttendanceTeamService.list(searchAttendanceTeam);
        PageInfo<VoAttendanceTeam> pageInfo = new PageInfo<>(voAttendanceTeamList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 添加考勤小组
     * @param sysAttendanceTeam 考勤小组管理model
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody SysAttendanceTeam sysAttendanceTeam){
        return sysAttendanceTeamService.insert(sysAttendanceTeam);
    }


}
