package com.aku.service.system.impl;

import com.aku.dao.system.SysDataDictionaryDao;
import com.aku.service.system.SysDataDictionaryService;
import com.aku.vo.system.VoDataDictionary;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysDataDictionaryServiceImpl implements SysDataDictionaryService {
    @Resource
    SysDataDictionaryDao sysDataDictionaryDao;

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
}
