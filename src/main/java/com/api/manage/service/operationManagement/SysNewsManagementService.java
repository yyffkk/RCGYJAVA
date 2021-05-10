package com.api.manage.service.operationManagement;

import com.api.model.operationManagement.SearchNewsManagement;
import com.api.vo.operationManagement.VoNewsManagement;

import java.util.List;

public interface SysNewsManagementService {
    List<VoNewsManagement> list(SearchNewsManagement searchNewsManagement);
}
