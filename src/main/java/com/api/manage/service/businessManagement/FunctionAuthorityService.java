package com.api.manage.service.businessManagement;

import com.api.model.businessManagement.*;
import com.api.vo.businessManagement.VoFunctionAuthority;
import com.api.vo.businessManagement.VoListJurisdiction;

import java.util.List;
import java.util.Map;

public interface FunctionAuthorityService {
    List<VoFunctionAuthority> list(SearchFunctionAuthority searchFunctionAuthority);

    List<Integer> findRoleNameByUserId(Integer id);

    Map<String, Object> updateRole(UserIdAndRoleId userIdAndRoleId);

    List<VoListJurisdiction> listJurisdiction(RoleIdAndParentId searchListJurisdiction);

    Map<String, Object> updateJurisdiction(RoleIdAndJurisdictionIdList roleIdAndJurisdictionIdList);

    Map<String, Object> updateOneJurisdiction(RoleIdAndJurisdictionId roleIdAndJurisdictionId);
}
