package com.api.manage.service.operationManagement;

import com.api.model.operationManagement.SearchNewsManagement;
import com.api.model.operationManagement.SysNewsManagement;
import com.api.vo.operationManagement.VoNewsManagement;

import java.util.List;
import java.util.Map;

public interface SysNewsManagementService {
    List<VoNewsManagement> list(SearchNewsManagement searchNewsManagement);

    Map<String, Object> insert(SysNewsManagement sysNewsManagement);

    Map<String, Object> findById(Integer newsId);

    Map<String, Object> update(SysNewsManagement sysNewsManagement);

    Map<String, Object> delete(int[] ids);

    int updateMedical();

    int updateEducation();
}
