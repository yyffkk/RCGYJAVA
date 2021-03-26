package com.api.manage.dao.basicArchives;

import com.api.model.basicArchives.AuditManagementSearch;
import com.api.model.basicArchives.Review;
import com.api.vo.basicArchives.VoAuditManagement;
import com.api.vo.basicArchives.VoFBIAuditManagement;

import java.util.List;

public interface AuditManagementDao {
    /**
     * 查询所有的房屋审核信息（包含条件搜索）
     * @param auditManagementSearch 搜索条件
     * @return 房屋审核信息集合
     */
    List<VoAuditManagement> list(AuditManagementSearch auditManagementSearch);

    /**
     * 根据房屋审核主键id 查询房屋审核信息
     * @param estateExamineId 房屋审核主键id
     * @return 房屋审核信息
     */
    VoFBIAuditManagement findById(Integer estateExamineId);

    /**
     * 修改审核状态和备注
     * @param review 审核操作内容
     * @return
     */
    int review(Review review);
}
