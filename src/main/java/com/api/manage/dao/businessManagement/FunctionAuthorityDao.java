package com.api.manage.dao.businessManagement;

import com.api.model.businessManagement.SearchFunctionAuthority;
import com.api.vo.businessManagement.VoFunctionAuthority;

import java.util.List;

public interface FunctionAuthorityDao {
    List<VoFunctionAuthority> list(SearchFunctionAuthority searchFunctionAuthority);
}
