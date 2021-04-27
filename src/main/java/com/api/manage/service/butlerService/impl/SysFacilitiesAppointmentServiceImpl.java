package com.api.manage.service.butlerService.impl;

import com.api.manage.dao.butlerService.SysFacilitiesAppointmentDao;
import com.api.manage.service.butlerService.SysFacilitiesAppointmentService;
import com.api.model.businessManagement.SysUser;
import com.api.model.butlerService.FacilitiesAppointment;
import com.api.model.butlerService.SearchFacilitiesAppointment;
import com.api.util.IdWorker;
import com.api.vo.butlerService.VoFacilitiesAppointment;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysFacilitiesAppointmentServiceImpl implements SysFacilitiesAppointmentService {
    private static Map<String,Object> map = null;
    @Resource
    SysFacilitiesAppointmentDao facilitiesAppointmentDao;

    @Override
    public List<VoFacilitiesAppointment> list(SearchFacilitiesAppointment searchFacilitiesAppointment) {
        return facilitiesAppointmentDao.list(searchFacilitiesAppointment);
    }

    @Override
    public Map<String, Object> insert(FacilitiesAppointment facilitiesAppointment) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        facilitiesAppointment.setCreateId(sysUser.getId());
        facilitiesAppointment.setCreateDate(new Date());
        facilitiesAppointment.setStatus(1); //填入预约状态,默认为1.未签到
        facilitiesAppointment.setCode(String.valueOf(new IdWorker(1, 1, 1).nextId())); //填入预约编号，雪花算法得取


        int insert = facilitiesAppointmentDao.insert(facilitiesAppointment);
        if (insert <= 0){
            map.put("message","添加失败");
            map.put("status",false);
        }else {
            map.put("message","添加成功");
            map.put("status",true);
        }
        return map;
    }

    @Override
    public Map<String, Object> nullify(Integer id) {
        map = new HashMap<>();
        return null;
    }
}
