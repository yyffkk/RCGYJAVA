package com.api.butlerApp.service.butler.impl;

import com.api.butlerApp.dao.butler.ButlerAttendanceDao;
import com.api.butlerApp.service.butler.ButlerAttendanceService;
import com.api.model.butlerApp.ButlerUserIdAndToDay;
import com.api.model.operationManagement.AttendanceRecord;
import com.api.model.operationManagement.SysAttendanceLeaveRecord;
import com.api.vo.operationManagement.VoAttendanceLeaveRecord;
import com.api.vo.operationManagement.VoAttendanceRecord;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ButlerAttendanceServiceImpl implements ButlerAttendanceService {
    private static Map<String,Object> map = null;
    @Resource
    ButlerAttendanceDao butlerAttendanceDao;

    @Override
    public Map<String, Object> todayClockRecord(Integer id) {
        map = new HashMap<>();

        ButlerUserIdAndToDay userIdAndToDay = new ButlerUserIdAndToDay();
        userIdAndToDay.setUserId(id);
        userIdAndToDay.setToDay(new Date());
        VoAttendanceRecord voAttendanceRecord = butlerAttendanceDao.todayClockRecord(userIdAndToDay);

        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",voAttendanceRecord);

        return map;
    }

    @Override
    public Map<String, Object> clock(AttendanceRecord attendanceRecord) {
        map = new HashMap<>();


        int update = butlerAttendanceDao.clock(attendanceRecord);
        if (update >0){
            map.put("message","打卡成功");
            map.put("status",true);
        }else {
            map.put("message","打卡失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public List<VoAttendanceRecord> clockRecord(Integer id) {
        return butlerAttendanceDao.clockRecord(id);
    }

    @Override
    public List<VoAttendanceLeaveRecord> applyRecord(Integer id) {
        return butlerAttendanceDao.applyRecord(id);
    }

    @Override
    public Map<String, Object> apply(SysAttendanceLeaveRecord sysAttendanceLeaveRecord, Integer id) {
        map = new HashMap<>();

        sysAttendanceLeaveRecord.setCreateId(id);
        sysAttendanceLeaveRecord.setCreateDate(new Date());
        sysAttendanceLeaveRecord.setStatus(1);//默认1.待审核

        int insert = butlerAttendanceDao.apply(sysAttendanceLeaveRecord);
        if (insert >0){
            map.put("message","填写成功");
            map.put("status",true);
        }else {
            map.put("message","填写失败");
            map.put("status",false);
        }

        return map;
    }
}
