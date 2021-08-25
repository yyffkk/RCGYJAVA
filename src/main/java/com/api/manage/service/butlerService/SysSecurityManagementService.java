package com.api.manage.service.butlerService;

import com.api.model.butlerService.SearchSecurityManagement;
import com.api.model.butlerService.SecurityManagement;
import com.api.vo.butlerService.VoSecurityManagement;

import java.util.List;
import java.util.Map;

public interface SysSecurityManagementService {
    List<VoSecurityManagement> list(SearchSecurityManagement searchSecurityManagement);

    Map<String, Object> insert(SecurityManagement securityManagement);
}
