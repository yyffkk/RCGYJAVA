package com.api.manage.service.basicArchives;

import com.api.model.basicArchives.AuditManagementSearch;
import com.api.vo.basicArchives.VoAuditManagement;

import java.util.List;
import java.util.Map;

public interface AuditManagementService {
    List<VoAuditManagement> list(AuditManagementSearch auditManagementSearch);

    Map<String, Object> findById(Integer estateExamineId);
}
