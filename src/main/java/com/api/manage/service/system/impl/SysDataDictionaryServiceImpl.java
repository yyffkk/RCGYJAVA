package com.api.manage.service.system.impl;

import com.api.manage.dao.system.SysDataDictionaryDao;
import com.api.manage.service.system.SysDataDictionaryService;
import com.api.model.businessManagement.SysUser;
import com.api.model.system.SysDataDictionary;
import com.api.model.system.SysDataDictionarySearch;
import com.api.vo.system.VoDataDictionary;
import com.api.vo.system.VoDataDictionaryList;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysDataDictionaryServiceImpl implements SysDataDictionaryService {
    private static Map<String,Object> map = null;
    @Resource
    SysDataDictionaryDao sysDataDictionaryDao;

    @Override
    public List<VoDataDictionaryList> list(SysDataDictionarySearch sysDataDictionarySearch) {
        return sysDataDictionaryDao.list(sysDataDictionarySearch);
    }

    @Override
    public Map<String, Object> update(SysDataDictionary sysDataDictionary) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        sysDataDictionary.setModifyId(sysUser.getId());
        sysDataDictionary.setModifyDate(new Date());

        int update = sysDataDictionaryDao.update(sysDataDictionary);
        if (update >0){
            map.put("message","修改成功");
            map.put("status",true);
        }else {
            map.put("message","修改失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public List<VoDataDictionary> findParkingSpaceStatus() {
        return sysDataDictionaryDao.findParkingSpaceStatus();
    }

    @Override
    public List<VoDataDictionary> findUserResidentIdType() {
        return sysDataDictionaryDao.findUserResidentIdType();
    }

    @Override
    public List<VoDataDictionary> findParkingSpaceType() {
        return sysDataDictionaryDao.findParkingSpaceType();
    }

    @Override
    public List<VoDataDictionary> findEstateStatus() {
        return sysDataDictionaryDao.findEstateStatus();
    }

    @Override
    public List<VoDataDictionary> findEstateType() {
        return sysDataDictionaryDao.findEstateType();
    }

    @Override
    public List<VoDataDictionary> findUserCarType() {
        return sysDataDictionaryDao.findUserCarType();
    }

    @Override
    public List<VoDataDictionary> findUserCarStatus() {
        return sysDataDictionaryDao.findUserCarStatus();
    }

    @Override
    public List<VoDataDictionary> findResidentEstateStatus() {
        return sysDataDictionaryDao.findResidentEstateStatus();
    }

    @Override
    public List<VoDataDictionary> findResidentRelativesIdentity() {
        return sysDataDictionaryDao.findResidentRelativesIdentity();
    }

    @Override
    public List<VoDataDictionary> findDecorationStaffIdentity() {
        return sysDataDictionaryDao.findDecorationStaffIdentity();
    }

    @Override
    public List<VoDataDictionary> findUserResidentType() {
        return sysDataDictionaryDao.findUserResidentType();
    }

    @Override
    public List<VoDataDictionary> findSysDailyPaymentType() {
        return sysDataDictionaryDao.findSysDailyPaymentType();
    }

    @Override
    public List<VoDataDictionary> findSysDispatchListDetailType() {
        return sysDataDictionaryDao.findSysDispatchListDetailType();
    }

    @Override
    public List<VoDataDictionary> findSysDispatchListDelayedDelayed() {
        return sysDataDictionaryDao.findSysDispatchListDelayedDelayed();
    }
}
