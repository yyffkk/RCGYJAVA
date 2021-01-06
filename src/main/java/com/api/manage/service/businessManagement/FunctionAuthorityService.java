package com.api.manage.service.businessManagement;

import com.api.model.businessManagement.SearchFunctionAuthority;
import com.api.vo.businessManagement.VoFunctionAuthority;

import java.util.List;

public interface FunctionAuthorityService {
    List<VoFunctionAuthority> list(SearchFunctionAuthority searchFunctionAuthority);

    List<Integer> findRoleNameByUserId(Integer id);
}
