package com.api.manage.dao.businessManagement;

import com.api.model.businessManagement.SearchFunctionAuthority;
import com.api.model.businessManagement.UserIdAndRoleId;
import com.api.vo.businessManagement.VoFunctionAuthority;

import java.util.List;

public interface FunctionAuthorityDao {
    /**
     * 查询所属角色下所有的员工信息 （包含条件搜索）
     * @param searchFunctionAuthority 搜索条件
     * @return 员工信息集合
     */
    List<VoFunctionAuthority> list(SearchFunctionAuthority searchFunctionAuthority);

}
