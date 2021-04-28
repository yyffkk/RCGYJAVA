package com.api.app.service.butler.impl;

import com.api.app.dao.butler.AppFacilitiesAppointmentDao;
import com.api.app.service.butler.AppFacilitiesAppointmentService;
import com.api.manage.dao.butlerService.SysFacilitiesAppointmentDao;
import com.api.model.app.SearchAppFacilitiesAppointment;
import com.api.model.butlerService.FacilitiesAppointment;
import com.api.util.IdWorker;
import com.api.vo.app.AppFacilitiesAppointmentVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AppFacilitiesAppointmentServiceImpl implements AppFacilitiesAppointmentService {
    @Resource
    AppFacilitiesAppointmentDao facilitiesAppointmentDao;
    @Resource
    SysFacilitiesAppointmentDao sysFacilitiesAppointmentDao;
    private static Map<String,Object> map = null;

    @Override
    public List<AppFacilitiesAppointmentVo> list(SearchAppFacilitiesAppointment appFacilitiesAppointment) {
        return facilitiesAppointmentDao.list(appFacilitiesAppointment);
    }

    @Override
    public Map<String, Object> insert(FacilitiesAppointment facilitiesAppointment) {
        map = new HashMap<>();

        facilitiesAppointment.setCreateId(-1); //app添加 为-1
        facilitiesAppointment.setCreateDate(new Date());
        facilitiesAppointment.setStatus(1); //填入预约状态,默认为1.未签到
        facilitiesAppointment.setCode(String.valueOf(new IdWorker(1, 1, 1).nextId())); //填入预约编号，雪花算法得取

        int insert = sysFacilitiesAppointmentDao.insert(facilitiesAppointment);
        if (insert <= 0){
            map.put("message","添加失败");
            map.put("status",false);
        }else {
            map.put("message","添加成功");
            map.put("status",true);
        }
        return map;
    }
}
