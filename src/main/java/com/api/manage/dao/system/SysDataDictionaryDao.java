package com.api.manage.dao.system;

import com.api.vo.system.VoDataDictionary;

import java.util.List;

public interface SysDataDictionaryDao {
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
}