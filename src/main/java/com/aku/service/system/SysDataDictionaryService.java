package com.aku.service.system;

import com.aku.vo.system.VoDataDictionary;

import java.util.List;

public interface SysDataDictionaryService {
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
}