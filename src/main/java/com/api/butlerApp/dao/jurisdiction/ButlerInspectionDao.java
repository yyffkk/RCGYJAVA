package com.api.butlerApp.dao.jurisdiction;

import com.api.model.butlerApp.*;
import com.api.vo.butlerApp.*;

import java.util.Date;
import java.util.List;

public interface ButlerInspectionDao {
    /**
     * 查询所有的巡检管理信息（包含条件搜索）
     * @param butlerInspectionSearch 搜索条件
     * @return 巡检管理信息集合
     */
    List<ButlerInspectionVo> list(ButlerInspectionSearch butlerInspectionSearch);

    /**
     * 根据巡检执行情况主键id查询巡检详情
     * @param executeId 巡检执行情况主键id
     * @return 巡检详情
     */
    ButlerInspectionFDBIVo findDetailById(Integer executeId);

    /**
     * 根据巡检计划主键id查询巡检点部分信息（开始巡检前调用）
     * @param planId 巡检计划主键id
     * @return 巡检点部分信息集合
     */
    List<ButlerPointVo> findPointByPlanId(Integer planId);

    /**
     * 根据巡检点主键id查询检查项数量(计划表)
     * @param id 巡检点主键id
     * @return 检查项数量
     */
    int countCheckNumByPointId(Integer id);

    /**
     * 根据巡检执行情况主键id查询巡检点部分信息（开始巡检后调用）
     * @param executeId 巡检执行情况主键id
     * @return 巡检点部分信息集合
     */
    List<ButlerPointVo> findPointByExecuteId(Integer executeId);

    /**
     * 根据巡检点主键id查询检查项数量(执行表)
     * @param id 巡检点主键id
     * @return 检查项数量
     */
    int countCheckNumByPointId2(Integer id);

    /**
     * 查询计划巡检点信息
     * @param executeId 巡检执行情况主键id
     * @return 计划巡检点信息
     */
    List<ButlerExecutePoint> findPlanInspectionPoint(Integer executeId);

    /**
     * 添加执行巡检点信息
     * @param butlerExecutePoint 管家app  巡检执行点信息model
     * @return 影响行数
     */
    int insertExecutePoint(ButlerExecutePoint butlerExecutePoint);

    /**
     * 查询计划巡检点检查项
     * @param id 巡检点主键id
     * @return 巡检点检查项集合
     */
    List<ButlerExecuteCheck> findPlanPointCheck(Integer id);

    /**
     * 添加执行巡检点检查项
     * @param executeCheck 管家app 巡检执行检查项
     * @return 影响行数
     */
    int insertExecuteCheck(ButlerExecuteCheck executeCheck);

    /**
     * 修改当前巡检执行情况的实际开始时间
     * @param butlerExecuteIdAndBeginDate 管家app 执行情况主键id 和当前巡检实际开始时间
     * @return 影响行数
     */
    int updateActualBeginDateById(ButlerExecuteIdAndBeginDate butlerExecuteIdAndBeginDate);

    /**
     * 根据巡检执行情况主键id查询巡检点主键id
     * @param executeId 巡检执行情况主键id
     * @return 巡检点主键ids数组
     */
    List<Integer> findPointIdByExecuteId(Integer executeId);

    /**
     * 根据巡检执行点主键id查询巡检执行点信息
     * @param executePointId 执行巡检点主键id
     * @return 巡检执行点信息
     */
    ButlerExecutePointVo findExecutePointById(Integer executePointId);

    /**
     * 根据巡检执行点主键id查询巡检执行检查项
     * @param id 巡检执行点主键id
     * @return 巡检执行检查项集合
     */
    List<ButlerExecuteCheckVo> findExecuteCheckByPointId(Integer id);

    /**
     * 修改巡检执行点检查项信息
     * @param executeCheck 巡检执行检查项
     * @return 影响行数
     */
    int updateExecuteCheck(ButlerExecuteCheck executeCheck);

    /**
     * 更新巡检点完成时间
     * @param pointIdAndCompleteDate 巡检执行点主键id 和 巡检点完成时间
     * @return 影响行数
     */
    int updateExecutePoint(ButlerPointIdAndCompleteDate pointIdAndCompleteDate);

    /**
     * 根据巡检执行点主键id查询完成时间
     * @param executePointId 巡检执行点主键id
     * @return 完成时间
     */
    ButlerExecutePoint findCompleteDateById(Integer executePointId);

    /**
     * 查询未完成的巡检点数量
     * @param executeId
     * @return
     */
    int countExecutePoint(Integer executeId);

    /**
     * 修改当次巡检情况实际结束时间
     * @param executeIdAndActualEndDate 巡检执行情况主键id 和 实际当次巡检结束时间
     * @return 影响行数
     */
    int updateExecute(ButlerExecuteIdAndActualEndDate executeIdAndActualEndDate);
}
