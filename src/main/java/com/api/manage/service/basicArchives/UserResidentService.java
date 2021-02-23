package com.api.manage.service.basicArchives;

import com.api.model.basicArchives.*;
import com.api.vo.basicArchives.VoFindAll;
import com.api.vo.basicArchives.VoRelatives;
import com.api.vo.basicArchives.VoUserResident;

import java.util.List;
import java.util.Map;

public interface UserResidentService {
    List<VoUserResident> list(UserResident userResident);

    List<UserResident> findByBuildingUnitEstateId(Integer buildingUnitEstateId);

    Map<String, Object> findById(Integer id);

    Map<String, Object> findByIdOne(Integer id);

    Map<String, Object> findRelativesById(Integer id);

    Map<String, Object> findEstateById(Integer id);

    Map<String, Object> findParkingSpaceById(Integer id);

    Map<String, Object> insert(UserResident userResident, List<VoRelatives>  voRelativesList, int[] cpmParkingSpaceIds, int[] buildingUnitEstateIds);

    Map<String, Object> delete(int[] id);

    Map<String, Object> updateRelatives(ResidentAndRelativesList residentAndRelatives);

    Map<String, Object> updateEstate(ResidentAndEstateIds residentAndEstateList);

    Map<String, Object> updateParkingSpace(ResidentAndParkingSpaceIds residentAndParkingSpaceList);

    List<VoFindAll> findResidentAll();

    List<VoFindAll> findAll();

    List<VoFindAll> findNameBySearch(SearchFindName searchFindName);
}
