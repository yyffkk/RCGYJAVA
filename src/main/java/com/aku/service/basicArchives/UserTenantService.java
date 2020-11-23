package com.aku.service.basicArchives;

import com.aku.model.basicArchives.*;
import com.aku.vo.basicArchives.VoRelatives;
import com.aku.vo.basicArchives.VoUpdateTenant;
import com.aku.vo.basicArchives.VoUserTenant;

import java.util.List;
import java.util.Map;

public interface UserTenantService {
    List<VoUserTenant> list(UserResident userTenant);

    Map<String, Object> insert(UserTenantInsert userTenantInsert);

    Map<String, Object> findById(Integer id);

    Map<String, Object> updateRelatives(ResidentAndRelativesList residentAndRelativesList);

    Map<String, Object> updateEstate(List<CpmResidentEstate> cpmResidentEstateList,Integer tenantId);

    Map<String, Object> updateParkingSpace(List<CpmParkingSpace> cpmParkingSpaceList,Integer tenantId);
}
