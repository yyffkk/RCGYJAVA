package com.api.manage.dao.basicArchives;

import com.api.model.basicArchives.AuditManagementSearch;
import com.api.vo.basicArchives.VoAuditManagement;

import java.util.List;

public interface AuditManagementDao {
    /**
     * 查询所有的房屋审核信息（包含条件搜索）
     * @param auditManagementSearch 搜索条件
     * @return 房屋审核信息集合
     */
    List<VoAuditManagement> list(AuditManagementSearch auditManagementSearch);
}
