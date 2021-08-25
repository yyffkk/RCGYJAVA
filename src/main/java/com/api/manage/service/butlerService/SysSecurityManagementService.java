package com.api.manage.service.butlerService;

import com.api.model.butlerService.SearchSecurityManagement;
import com.api.vo.butlerService.VoSecurityManagement;

import java.util.List;

public interface SysSecurityManagementService {
    List<VoSecurityManagement> list(SearchSecurityManagement searchSecurityManagement);
}
