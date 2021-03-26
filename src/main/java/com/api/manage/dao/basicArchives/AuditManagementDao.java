package com.api.manage.dao.basicArchives;

import com.api.model.basicArchives.*;
import com.api.vo.basicArchives.VoAuditManagement;
import com.api.vo.basicArchives.VoCheckAuditById;
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

    /**
     * 添加住户房产关联
     * @param cpmResidentEstate 住户房产关联表
     * @return 影响行数
     */
    int insertResidentEstate(CpmResidentEstate cpmResidentEstate);

    /**
     * 添加住户亲属关联
     * @param userResidentRelatives 住户亲属关联表信息model
     * @return 影响行数
     */
    int insertResidentRelatives(UserResidentRelatives userResidentRelatives);

    /**
     * 修改住户资料信息
     * @param userResident 住户信息表
     * @return 影响行数
     */
    int updateResident(UserResident userResident);

    /**
     * 删除原本存在的住户房产关联记录
     * @param residentIdAndEstateId 房产id 和 业主id
     * @return 住户房产关联记录
     */
    int deleteByRIDAndEID(ResidentIdAndEstateId residentIdAndEstateId);

    /**
     * 删除原本存在的住户亲属关联表
     * @param residentIdAndRelativesId  业主id 和 亲属id
     * @return 影响行数
     */
    int deleteByRIDAndRID(ResidentIdAndRelativesId residentIdAndRelativesId);

    /**
     * 删除审核管理信息
     * @param id 审核管理主键id
     * @return 影响行数
     */
    int delete(int id);

    /**
     * 查看审核信息
     * @param estateExamineId 房屋审核主键id
     * @return 审核信息
     */
    VoCheckAuditById checkById(Integer estateExamineId);
}
