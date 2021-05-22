package com.api.manage.service.system;

import com.api.model.system.SysDataDictionary;
import com.api.model.system.SysDataDictionarySearch;
import com.api.vo.system.VoDataDictionary;
import com.api.vo.system.VoDataDictionaryList;

import java.util.List;
import java.util.Map;

public interface SysDataDictionaryService {
    List<VoDataDictionaryList> list(SysDataDictionarySearch sysDataDictionarySearch);

    Map<String, Object> update(SysDataDictionary sysDataDictionary);

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
