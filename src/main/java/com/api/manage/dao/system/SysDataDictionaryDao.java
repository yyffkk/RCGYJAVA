package com.api.manage.dao.system;

import com.api.model.system.SysDataDictionary;
import com.api.model.system.SysDataDictionarySearch;
import com.api.vo.system.VoDataDictionary;
import com.api.vo.system.VoDataDictionaryList;

import java.util.List;

public interface SysDataDictionaryDao {
    List<VoDataDictionaryList> list(SysDataDictionarySearch sysDataDictionarySearch);

    int update(SysDataDictionary sysDataDictionary);

    List<VoDataDictionary> findParkingSpaceStatus();

    List<VoDataDictionary> findUserResidentIdType();

    List<VoDataDictionary> findParkingSpaceType();

    List<VoDataDictionary> findEstateStatus();

    List<VoDataDictionary> findEstateType();

    List<VoDataDictionary> findUserCarType();

    List<VoDataDictionary> findUserCarStatus();

    List<VoDataDictionary> findResidentEstateStatus();

    List<VoDataDictionary> findResidentRelativesIdentity();

    List<VoDataDictionary> findDecorationStaffIdentity();

    List<VoDataDictionary> findUserResidentType();

    List<VoDataDictionary> findSysDailyPaymentType();

    List<VoDataDictionary> findSysDispatchListDetailType();

    List<VoDataDictionary> findSysDispatchListDelayedDelayed();

}
