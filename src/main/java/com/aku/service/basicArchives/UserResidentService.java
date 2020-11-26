package com.aku.service.basicArchives;

import com.aku.model.basicArchives.ResidentAndEstateIds;
import com.aku.model.basicArchives.ResidentAndParkingSpaceIds;
import com.aku.model.basicArchives.ResidentAndRelativesList;
import com.aku.model.basicArchives.UserResident;
import com.aku.vo.basicArchives.VoFindAll;
import com.aku.vo.basicArchives.VoRelatives;
import com.aku.vo.basicArchives.VoUserResident;

import java.util.List;
import java.util.Map;

public interface UserResidentService {
    List<VoUserResident> list(UserResident userResident);

    List<UserResident> findByBuildingUnitEstateId(Integer buildingUnitEstateId);

    Map<String, Object> findById(Integer id);

    Map<String, Object> findRelativesById(Integer id);

    Map<String, Object> findEstateById(Integer id);

    Map<String, Object> findParkingSpaceById(Integer id);

    Map<String, Object> insert(UserResident userResident, List<VoRelatives>  voRelativesList, List<Integer> cpmParkingSpaceIds, List<Integer> buildingUnitEstateIds);

    Map<String, Object> delete(int[] id);

    Map<String, Object> updateRelatives(ResidentAndRelativesList residentAndRelatives);

    Map<String, Object> updateEstate(ResidentAndEstateIds residentAndEstateList);

    Map<String, Object> updateParkingSpace(ResidentAndParkingSpaceIds residentAndParkingSpaceList);

    List<VoFindAll> findResidentAll();

    List<VoFindAll> findAll();
}
