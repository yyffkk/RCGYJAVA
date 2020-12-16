package com.api.dao.chargeManagement;

import com.api.model.chargeManagement.SearchChargesTemplateDetail;
import com.api.model.chargeManagement.SysChargesTemplateDetail;
import com.api.vo.chargeManagement.VoChargesTemplateDetail;
import com.api.vo.chargeManagement.VoFindByIdChargesTemplateDetail;

import java.util.List;

public interface SysChargesTemplateDetailDao {
    /**
     * 根据物业收费标准模版主键id 查询所有的物业收费标准明细 (包含条件搜索)
     * @param searchChargesTemplateDetail 搜索条件
     * @return 物业收费标准明细集合
     */
    List<VoChargesTemplateDetail> list(SearchChargesTemplateDetail searchChargesTemplateDetail);

    /**
     * 添加物业收费标准明细信息
     * @param sysChargesTemplateDetail 物业收费标准明细信息
     * @return 影响行数
     */
    int insert(SysChargesTemplateDetail sysChargesTemplateDetail);

    /**
     * 根据物业收费标准明细主键id 查询物业收费标准明细信息
     * @param id 物业收费标准明细主键id
     * @return 物业收费标准明细信息
     */
    VoFindByIdChargesTemplateDetail findById(Integer id);

    /**
     * 更新物业收费标准明细信息
     * @param sysChargesTemplateDetail 新物业收费标准明细信息
     * @return 影响行数
     */
    int update(SysChargesTemplateDetail sysChargesTemplateDetail);

    /**
     * 根据物业收费标准明细主键id 删除物业收费标准明细信息
     * @param id 物业收费标准明细主键id
     * @return 影响行数
     */
    int delete(int id);

    /**
     * 查询计费单位显示名称
     * @param type 计费单位类型
     * @return 计费单位显示名称
     */
    String findTypeShowNameByShowValue(Integer type);

    /**
     * 查询状态显示名称
     * @param status 状态
     * @return 状态显示名称
     */
    String findStatusShowNameByShowValue(Integer status);
}
