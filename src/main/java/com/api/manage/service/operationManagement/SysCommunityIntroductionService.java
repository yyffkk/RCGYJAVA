package com.api.manage.service.operationManagement;

import com.api.model.operationManagement.SearchCommunityIntroduction;
import com.api.model.operationManagement.SysCommunityIntroduction;
import com.api.vo.operationManagement.VoCommunityIntroduction;

import java.util.List;
import java.util.Map;

public interface SysCommunityIntroductionService {
    List<VoCommunityIntroduction> list(SearchCommunityIntroduction searchCommunityIntroduction);

    Map<String, Object> insert(SysCommunityIntroduction sysCommunityIntroduction);

    Map<String, Object> findById(Integer id);

    Map<String, Object> update(SysCommunityIntroduction sysCommunityIntroduction);

    Map<String, Object> delete(int[] ids);

    Map<String, Object> enable(Integer id);
}
