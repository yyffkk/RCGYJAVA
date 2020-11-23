package com.aku.service.basicArchives;

import com.aku.model.basicArchives.UserResident;
import com.aku.vo.basicArchives.VoRelatives;
import com.aku.vo.basicArchives.VoUpdateTenant;
import com.aku.vo.basicArchives.VoUserTenant;

import java.util.List;
import java.util.Map;

public interface UserTenantService {
    List<VoUserTenant> list(UserResident userTenant);

    Map<String, Object> insert(UserResident userResident, List<VoRelatives> voRelativesList, List<Integer> buildingUnitEstateIds);

    Map<String, Object> findById(Integer id);

    Map<String, Object> update(VoUpdateTenant voUpdateTenant);

}
