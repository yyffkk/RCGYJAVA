package com.api.butlerApp.dao.jurisdiction;

import com.api.model.butlerApp.*;
import com.api.vo.butlerApp.ButlerChecksContentVo;
import com.api.vo.butlerApp.ButlerDecorationFBIVo;
import com.api.vo.butlerApp.ButlerDecorationVo;
import com.api.vo.butlerApp.ButlerTrackInspectionFBIVo;

import java.util.List;

public interface ButlerDecorationDao {
    /**
     * 查询装修管理信息list列表
     * @param decorationSearch 管家app 装修管理搜索条件
     * @return 管家app 装修管理Vo list 回显
     */
    List<ButlerDecorationVo> list(ButlerDecorationSearch decorationSearch);

    /**
     * 根据装修主键id查询装修信息
     * @param decorationId 装修主键id
     * @return 装修信息
     */
    ButlerDecorationFBIVo findById(Integer decorationId);

    /**
     * 根据装修主键id查询检查周期信息
     * @param decorationId 装修主键id
     * @return 检查周期信息
     */
    ButlerTrackInspectionFBIVo findInspectionById(Integer decorationId);

    /**
     * 查询检查内容信息（标准表）
     * @return 检查内容信息集合
     */
    List<ButlerChecksContentVo> findChecksContent();

    /**
     * 查询跟踪检查内容信息（关联表）
     * @param decorationId 装修主键id
     * @return 跟踪检查内容信息集合
     */
    List<ButlerChecksContentVo> findTrackChecksContent(Integer decorationId);

    /**
     * 修改装修表 跟踪人id
     * @param trackInspectionCycle 跟踪检查周期信息
     * @return 影响行数
     */
    int updateTrackerById(ButlerTrackInspectionCycle trackInspectionCycle);

    /**
     * 添加 装修跟踪检查周期表信息
     * @param trackInspectionCycle 跟踪检查周期信息
     * @return 影响行数
     */
    int insertInspectionCycle(ButlerTrackInspectionCycle trackInspectionCycle);

    /**
     * 添加装修跟踪检查内容表（关联表）信息失败
     * @param checksContent 管家app 跟踪检查内容信息
     * @return 影响行数
     */
    int insertTrackChecksContent(ButlerTrackChecksContent checksContent);

    /**
     * 根据装修主键id查询是否有指派的人
     * @param decorationId 装修主键id
     * @return 跟踪人数量
     */
    int countInspectionCycle(Integer decorationId);

    /**
     * 添加装修跟踪记录
     * @param butlerTrackRecord 管家app 跟踪记录信息
     * @return 影响行数
     */
    int insertTrackRecord(ButlerTrackRecord butlerTrackRecord);

    /**
     * 添加装修跟踪记录明细
     * @param trackRecordDetail 管家app 跟踪记录信息详情
     * @return 影响行数
     */
    int insertTrackRecordDetail(ButlerTrackRecordDetail trackRecordDetail);

    /**
     * 更新装修表的【最后一次完工检查是否合格】字段
     * @param butlerTrackRecord 跟踪记录信息
     * @return 影响行数
     */
    int updateIsQualified(ButlerTrackRecord butlerTrackRecord);
}
