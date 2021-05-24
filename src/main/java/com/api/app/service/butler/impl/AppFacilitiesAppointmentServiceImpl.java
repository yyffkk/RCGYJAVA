package com.api.app.service.butler.impl;

import com.api.app.dao.butler.AppFacilitiesAppointmentDao;
import com.api.app.service.butler.AppFacilitiesAppointmentService;
import com.api.manage.dao.butlerService.SysFacilitiesAppointmentDao;
import com.api.model.app.AppFacilitiesIdAndNowDate;
import com.api.model.app.AppointmentCodeAndUserId;
import com.api.model.app.AppointmentStopUseFactor;
import com.api.model.app.SearchAppFacilitiesAppointment;
import com.api.model.butlerService.FacilitiesAppointment;
import com.api.util.IdWorker;
import com.api.util.UploadUtil;
import com.api.vo.app.AppAppointmentDateVo;
import com.api.vo.app.AppFacilitiesAppointmentVo;
import com.api.vo.app.AppFacilitiesCategoryVo;
import com.api.vo.app.IdAndName;
import com.api.vo.resources.VoResourcesImg;
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

    @Override
    public List<AppFacilitiesCategoryVo> findCategoryList() {
        List<AppFacilitiesCategoryVo> facilitiesCategoryVoList = facilitiesAppointmentDao.findCategoryList();
        if (facilitiesCategoryVoList != null && facilitiesCategoryVoList.size()>0){
            UploadUtil uploadUtil = new UploadUtil();
            for (AppFacilitiesCategoryVo appFacilitiesCategoryVo : facilitiesCategoryVoList) {
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysFacilitiesCategory", appFacilitiesCategoryVo.getId(), "categoryImg");
                appFacilitiesCategoryVo.setImgUrls(imgByDate);
            }
        }
        return facilitiesCategoryVoList;
    }

    @Override
    public Map<String, Object> findFacilitiesByCategoryId(Integer categoryId) {
        map = new HashMap<>();
        List<IdAndName> facilities = facilitiesAppointmentDao.findFacilitiesByCategoryId(categoryId);
        map.put("data",facilities);
        map.put("message","请求成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> useStop(AppointmentStopUseFactor appointmentStopUseFactor) {
        map = new HashMap<>();
        Integer status = facilitiesAppointmentDao.findStatusById(appointmentStopUseFactor.getFacilitiesAppointmentId());
        if (status != 2){
            map.put("message","此状态不可结束使用");
            map.put("status",false);
            return map;
        }

        appointmentStopUseFactor.setUseEndDate(new Date()); //填入结束时间
        int update = facilitiesAppointmentDao.useStop(appointmentStopUseFactor);
        if (update <= 0){
            map.put("message","结束失败");
            map.put("status",false);
        }else {
            map.put("message","结束成功");
            map.put("status",true);
        }
        return map;
    }

    @Override
    public Map<String, Object> cancel(AppointmentStopUseFactor appointmentStopUseFactor) {
        map = new HashMap<>();
        int update = facilitiesAppointmentDao.cancel(appointmentStopUseFactor);
        if (update <= 0){
            map.put("message","取消成功");
            map.put("status",true);
        }else {
            map.put("message","取消失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> signId(AppointmentCodeAndUserId appointmentCodeAndUserId) {
        map = new HashMap<>();
        //根据预约编号和预约人主键id 查询预约时间
        Date appointmentStartDate = facilitiesAppointmentDao.findAppointmentStartDateByACAUI(appointmentCodeAndUserId);
        if (appointmentStartDate == null){
            map.put("message","该预约不存在");
            map.put("status",false);
            return map;
        }

        //当前时间 时间戳
        long time = new Date().getTime();
        //预约开始时间 时间戳
        long time1 = appointmentStartDate.getTime();
        //当前时间 小于 预约开始时间 前半小时
        if (time < time1-30*60*1000){
            map.put("message","当前时间不可签到");
            map.put("status",false);
            return map;
        }

        //当前时间 大于 预约开始时间
        if (time > time1){
            map.put("message","已超出预约时间");
            map.put("status",false);
            return map;
        }

        int update = facilitiesAppointmentDao.signId(appointmentCodeAndUserId);
        if (update <= 0){
            map.put("message","签到失败");
            map.put("status",false);
        }else {
            map.put("message","签到成功");
            map.put("status",true);
        }
        return map;
    }

    @Override
    public List<AppAppointmentDateVo> findFacilitiesAppointmentDate(Integer facilitiesId) {
        AppFacilitiesIdAndNowDate facilitiesIdAndNowDate = new AppFacilitiesIdAndNowDate();
        facilitiesIdAndNowDate.setFacilitiesId(facilitiesId);
        facilitiesIdAndNowDate.setNowDate(new Date());
        return facilitiesAppointmentDao.findFacilitiesAppointmentDate(facilitiesIdAndNowDate);
    }
}
