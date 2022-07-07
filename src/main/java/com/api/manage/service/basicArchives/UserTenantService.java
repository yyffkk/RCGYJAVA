package com.api.manage.service.basicArchives;

import com.api.model.basicArchives.*;
import com.api.vo.basicArchives.VoUserTenant;

import java.util.List;
import java.util.Map;

public interface UserTenantService {
    List<VoUserTenant> list(UserResident userTenant);

    Map<String, Object> insert(UserTenantInsert userTenantInsert);

    Map<String, Object> findById(Integer id);

    Map<String, Object> updateRelatives(ResidentAndRelativesList residentAndRelativesList);

    Map<String, Object> updateEstate(List<CpmResidentEstate> cpmResidentEstateList,Integer tenantId);

    Map<String, Object> updateParkingSpace(List<CpmParkingSpace> cpmParkingSpaceList,Integer tenantId);

    Map<String, Object> delete(int[] ids);
}
