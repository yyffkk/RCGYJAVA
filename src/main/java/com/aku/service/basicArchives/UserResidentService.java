package com.aku.service.basicArchives;

import com.aku.model.basicArchives.UserResident;
import com.aku.vo.basicArchives.VoRelatives;
import com.aku.vo.basicArchives.VoUpdateResident;

import java.util.List;
import java.util.Map;

public interface UserResidentService {
    List<UserResident> list(UserResident userResident);

//    Map<String, Object> insert(UserResident userResident,Integer cpmParkingSpaceId);

    UserResident findByBuildingUnitEstateId(Integer buildingUnitEstateId);

    Map<String, Object> findById(Integer id);

    Map<String, Object> insert(UserResident userResident, List<VoRelatives>  voRelativesList, List<Integer> cpmParkingSpaceIds, List<Integer> buildingUnitEstateIds);

    Map<String, Object> update(VoUpdateResident voUpdateResident);

    Map<String, Object> delete(int id);
}
