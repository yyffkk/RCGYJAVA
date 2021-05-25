package com.api.manage.service.operationManagement;

import com.api.model.operationManagement.Interview;
import com.api.model.operationManagement.SearchInterview;
import com.api.vo.operationManagement.VoInterview;

import java.util.List;
import java.util.Map;

public interface SysInterviewService {
    List<VoInterview> list(SearchInterview searchInterview);

    Map<String, Object> insert(Interview interview);

    Map<String, Object> delete(int[] ids);
}
