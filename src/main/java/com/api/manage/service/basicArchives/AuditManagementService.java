package com.api.manage.service.basicArchives;

import com.api.model.basicArchives.AuditManagementSearch;
import com.api.vo.basicArchives.VoAuditManagement;

import java.util.List;

public interface AuditManagementService {
    List<VoAuditManagement> list(AuditManagementSearch auditManagementSearch);
}
