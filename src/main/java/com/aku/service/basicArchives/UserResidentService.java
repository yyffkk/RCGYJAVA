package com.aku.service.basicArchives;

import com.aku.model.basicArchives.CpmBuildingUnitEstate;
import com.aku.model.basicArchives.UserResident;

import java.util.List;
import java.util.Map;

public interface UserResidentService {
    List<UserResident> list(UserResident userResident);

    Map<String, Object> insert(UserResident userResident,Integer cpmParkingSpaceId);

    UserResident findByBuildingUnitEstateId(Integer buildingUnitEstateId);

    Map<String, Object> findById(Integer id);
}
