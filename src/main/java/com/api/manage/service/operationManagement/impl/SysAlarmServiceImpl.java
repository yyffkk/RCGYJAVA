package com.api.manage.service.operationManagement.impl;

import com.api.manage.dao.operationManagement.SysAlarmDao;
import com.api.manage.service.operationManagement.SysAlarmService;
import com.api.vo.operationManagement.VoButlerOneButtonAlarm;
import com.api.vo.operationManagement.VoFireAlarm;
import com.api.vo.operationManagement.VoOneButtonAlarm;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysAlarmServiceImpl implements SysAlarmService {
    @Resource
    SysAlarmDao sysAlarmDao;

    @Override
    public List<VoFireAlarm> fireAlarmList() {
        return sysAlarmDao.fireAlarmList();
    }

    @Override
    public List<VoOneButtonAlarm> oneButtonAlarmList() {
        return sysAlarmDao.oneButtonAlarmList();
    }

    @Override
    public List<VoButlerOneButtonAlarm> butlerOneButtonAlarmList() {
        return sysAlarmDao.butlerOneButtonAlarmList();
    }
}
