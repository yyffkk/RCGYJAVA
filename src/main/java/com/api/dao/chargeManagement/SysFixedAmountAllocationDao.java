package com.api.dao.chargeManagement;

import com.api.model.chargeManagement.*;
import com.api.vo.chargeManagement.VoFindByIdFAA;
import com.api.vo.chargeManagement.VoFixedAmountAllocation;
import com.api.vo.chargeManagement.VoFixedAmountAllocationResult;

import java.util.List;
import java.util.Map;

public interface SysFixedAmountAllocationDao {
    /**
     * 查询所有的固定金额分摊信息（包含条件搜索）
     * @param searchFixedAmountAllocation 搜索条件
     * @return 固定金额分摊信息集合
     */
    List<VoFixedAmountAllocation> list(SearchFixedAmountAllocation searchFixedAmountAllocation);

    /**
     * 添加固定金额分摊信息
     * @param sysFixedAmountAllocation 固定金额分摊信息
     * @return 影响行数
     */
    int insert(SysFixedAmountAllocation sysFixedAmountAllocation);

    /**
     * 根据主键id查询固定金额分摊信息
     * @param id 主键id
     * @return 固定金额分摊信息
     */
    VoFindByIdFAA findById(Integer id);

    /**
     * 修改固定金额分摊信息
     * @param sysFixedAmountAllocation 新固定金额分摊信息
     * @return 影响行数
     */
    int update(SysFixedAmountAllocation sysFixedAmountAllocation);

    /**
     * 假删除固定金额分摊信息
     * @param id 主键id
     * @return 影响行数
     */
    int falseDelete(int id);

    /**
     * 查询当前固定金额的分摊结果 （包含条件搜索）
     * @param searchFixedAmountAllocationResult 搜索条件
     * @return 固定金额的分摊结果
     */
    List<VoFixedAmountAllocationResult> listResult(SearchFixedAmountAllocationResult searchFixedAmountAllocationResult);

    /**
     * 查询所有房间（查询有业主的房间）
     * @return 房产id和建筑面积
     */
    List<EstateIdAndConstructionArea> findAllRoomByHave();

    /**
     * 指定楼栋（查询有业主的房间）
     * @param s 楼栋id
     * @return 房产id和建筑面积
     */
    List<EstateIdAndConstructionArea> findBuildingRoomByHave(String s);

    /**
     * 添加分摊信息
     * @param fixedAmountAllocationResult 固定金额分摊结果model
     * @return 影响行数
     */
    int share(FixedAmountAllocationResult fixedAmountAllocationResult);

    /**
     * 指定房间（查询有业主的房间）
     * @param s 房产id和建筑面积
     * @return
     */
    EstateIdAndConstructionArea findRoomByHave(String s);

    /**
     * 修改固定金额分摊的相关状态信息
     * @param sysFixedAmountAllocation 新固定金额分摊
     * @return 影响行数
     */
    int updateStatus(SysFixedAmountAllocation sysFixedAmountAllocation);

    /**
     * 改变固定金额分摊结果状态
     * @param fixedPayment 固定金额 缴纳model
     * @return 影响行数
     */
    int updateResultStatus(FixedPayment fixedPayment);
}
