package com.api.manage.service.operationManagement.impl;

import com.api.manage.dao.operationManagement.SysAttendanceRecordDao;
import com.api.manage.service.operationManagement.SysAttendanceRecordService;
import com.api.model.businessManagement.SysUser;
import com.api.model.operationManagement.AttendanceRecord;
import com.api.model.operationManagement.SearchAttendanceLeaveRecord;
import com.api.model.operationManagement.SearchAttendanceRecord;
import com.api.model.operationManagement.SysAttendanceLeaveRecord;
import com.api.vo.operationManagement.VoAttendanceLeaveRecord;
import com.api.vo.operationManagement.VoAttendanceRecord;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysAttendanceRecordServiceImpl implements SysAttendanceRecordService {
    private static Map<String,Object> map = null;
    @Resource
    SysAttendanceRecordDao sysAttendanceRecordDao;

    @Override
    public List<VoAttendanceRecord> list(SearchAttendanceRecord searchAttendanceRecord) {
        return sysAttendanceRecordDao.list(searchAttendanceRecord);
    }

    @Override
    public Map<String, Object> cardReplacement(AttendanceRecord attendanceRecord) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        attendanceRecord.setCardReplacementDate(new Date());
        attendanceRecord.setOperator(sysUser.getId());
        int update = sysAttendanceRecordDao.cardReplacement(attendanceRecord);
        if (update >0){
            map.put("message","补卡成功");
            map.put("status",true);
        }else {
            map.put("message","补卡失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public List<VoAttendanceLeaveRecord> leaveList(SearchAttendanceLeaveRecord searchAttendanceLeaveRecord) {
        return sysAttendanceRecordDao.leaveList(searchAttendanceLeaveRecord);
    }

    @Override
    public Map<String, Object> reviewer(SysAttendanceLeaveRecord sysAttendanceLeaveRecord) {
        map = new HashMap<>();

        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        sysAttendanceLeaveRecord.setReviewer(sysUser.getId());
        sysAttendanceLeaveRecord.setReviewerDate(new Date());

        int update = sysAttendanceRecordDao.reviewer(sysAttendanceLeaveRecord);
        if (update >0){
            map.put("message","操作成功");
            map.put("status",true);
        }else {
            map.put("message","操作失败");
            map.put("status",false);
        }
        return map;
    }
}
