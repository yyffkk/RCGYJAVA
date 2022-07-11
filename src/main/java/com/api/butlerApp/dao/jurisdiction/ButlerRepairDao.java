package com.api.butlerApp.dao.jurisdiction;

import com.api.model.businessManagement.SysUser;
import com.api.model.butlerApp.*;
import com.api.model.butlerService.ProcessRecord;
import com.api.model.butlerService.SysDispatchListDetail;
import com.api.model.butlerService.UpdateDispatchStatus;
import com.api.vo.app.IdAndName;
import com.api.vo.butlerApp.*;

import java.util.ArrayList;
import java.util.List;

public interface ButlerRepairDao {
    /**
     * 根据角色id查询权限id集合
     * @param roleId 角色id
     * @return 权限id集合
     */
    List<Integer> findJIdsByRoleId(Integer roleId);

    /**
     * 根据角色id数组查询权限id集合
     * @param split 角色id数组
     * @return 权限id集合
     */
    List<Integer> findJIdsByRoleIds(List<Integer> split);

    /**
     * 派单人：查询所有的报事报修信息(包含条件搜索)
     * @param butlerRepairSearch 搜索条件
     * @return 报事报修信息集合
     */
    List<ButlerRepairVo> list1(ButlerRepairSearch butlerRepairSearch);

    /**
     * 接单人：查询所有的报事报修信息(包含条件搜索)
     * @param butlerRepairSearch 搜索条件
     * @return 报事报修信息集合
     */
    List<ButlerRepairVo> list2(ButlerRepairSearch butlerRepairSearch);

    /**
     * 其他角色：查询所有的报事报修信息(包含条件搜索)
     * @param butlerRepairSearch 搜索条件
     * @return 报事报修信息集合
     */
    List<ButlerRepairVo> list3(ButlerRepairSearch butlerRepairSearch);

    /**
     * 派单人：根据用户主键id 和 报事报修主键id 查询报修详情
     * @param butlerUserIdAndRepairId 用户主键id 与 报事报修主键id
     * @return 报修详情Vo findById 回显
     */
    ButlerRepairFindByIdVo findById(ButlerUserIdAndRepairId butlerUserIdAndRepairId);

    /**
     * 派单人：根据用户主键id 和 报事报修主键id 查询工单类型
     * @param butlerUserIdAndRepairId 用户主键id 和 报事报修主键id
     * @return 管家app 工单类型 Vo findById 回显
     */
    ButlerDispatchTypeVo findDispatchTypeById(ButlerUserIdAndRepairId butlerUserIdAndRepairId);

    /**
     * 所有角色：根据报修id查询报修进程
     * @param repairId 报修id
     * @return 报修进程
     */
    List<ButlerProcessRecordVo> findProcessRecord(Integer repairId);

    /**
     * 接单人：根据用户主键id 和 报事报修主键id 查询报修详情
     * @param butlerUserIdAndRepairId 用户主键id 和 报事报修主键id
     * @return 报修详情
     */
    ButlerRepairFindByIdVo findById2(ButlerUserIdAndRepairId butlerUserIdAndRepairId);

    /**
     * 接单人：根据用户主键id 和 报事报修主键id 查询工单类型
     * @param butlerUserIdAndRepairId 用户主键id 和 报事报修主键id
     * @return 工单类型
     */
    ButlerDispatchTypeVo findDispatchTypeById2(ButlerUserIdAndRepairId butlerUserIdAndRepairId);

    /**
     * 其他角色：根据报事报修主键id 查询报修详情
     * @param repairId 报事报修主键id
     * @return 报修详情
     */
    ButlerRepairFindByIdVo findById3(Integer repairId);

    /**
     * 其他角色：根据报事报修主键id 查询工单类型
     * @param repairId 报事报修主键id
     * @return 工单类型
     */
    ButlerDispatchTypeVo findDispatchTypeById3(Integer repairId);

    /**
     * 查询所有的工单时限信息
     * @return 工单时限id and name
     */
    List<IdAndName> findWorkOrderTimeLimit();

    /**
     * 查询所有的工单类型明细信息（工单子类信息）
     * @param workOrderTypeId 工单大类主键id
     * @return 工单子类 id and name
     */
    List<IdAndName> findWorkOrderTypeDetail(Integer workOrderTypeId);

    /**
     * 根据父组织查询子组织信息
     * @param repairOrganizationId 父组织id
     * @return 管家app 维修部组织 信息Vo 回显
     */
    List<ButlerRepairOrganizationVo> findRepairOrganization(int repairOrganizationId);

    /**
     * 根据组织id查询维修人信息
     * @param id 组织id
     * @return 维修人信息集合
     */
    List<ButlerRepairmanVo> findRepairman(Integer id);

    /**
     * 添加派工单详情信息 并返回主键id
     * @param sysDispatchListDetail 派工单详情信息
     * @return 影响行数
     */
    int dispatch(SysDispatchListDetail sysDispatchListDetail);

    /**
     * 改变工单状态(变为1.待分配)
     * @param updateDispatchStatus 更改工单状态信息
     * @return 影响行数
     */
    int updateStatus(UpdateDispatchStatus updateDispatchStatus);

    /**
     * 根据id查询维修人信息
     * @param operator 维修人主键id（系统用户表）
     * @return 维修人信息
     */
    SysUser findSysUserById(Integer operator);

    /**
     * 添加处理进程记录
     * @param processRecord 处理进程记录信息
     * @return 影响行数
     */
    int insertProcessRecord(ProcessRecord processRecord);

    /**
     * 根据派工单主键id查询派工单状态
     * @param dispatchListId 派工单主键id
     * @return 派工单状态
     */
    Integer findStatusByDispatchId(Integer dispatchListId);

    /**
     * 改派
     * @param sysDispatchListDetail 改派信息
     * @return 影响行数
     */
    int updateDispatchListDetail(SysDispatchListDetail sysDispatchListDetail);

    /**
     * 根据报事报修主键id 查询 处理情况
     * @param repairId 报事报修主键id
     * @return 管家app 处理情况Vo findById 回显
     */
    ButlerHandlingSituationVo findHSByRepairId(Integer repairId);

    /**
     * 根据报事报修主键id 查询 费用明细
     * @param repairId 报事报修主键id
     * @return 管家app 报事报修费用明细
     */
    ButlerRepairCostDetailVo findRCDByRepairId(Integer repairId);

    /**
     * 根据报事报修主键id 查询 评价信息
     * @param repairId 报事报修主键id
     * @return 评价信息
     */
    ButlerEvaluateInfoVo findEIByRepairId(Integer repairId);

    /**
     * 接单
     * @param butlerUpdateStatusAndDate 管家app 修改派工单状态和时间
     * @return 影响行数
     */
    int receivingOrders(ButlerUpdateStatusAndDate butlerUpdateStatusAndDate);

    /**
     * 根据派工单id 查询维修人id
     * @param dispatchId 派工单id
     * @return 维修人id
     */
    Integer findOperatorByDispatchId(Integer dispatchId);

    /**
     * 根据showValue查询 showName
     * @param showValue showValue
     * @return showName
     */
    String findDelayedByShowValue(Integer showValue);

    /**
     * 添加延时信息
     * @param butlerApplyDelayed 管家app 申请延时信息 model
     * @return 影响行数
     */
    int insertDispatchListDelayed(ButlerApplyDelayed butlerApplyDelayed);

    /**
     * 添加完成结果详情
     * @param handleCompleteDetail 管家app 处理完成结果详情
     * @return 影响行数
     */
    int insertHandleCompleteDetail(ButlerHandleCompleteDetail handleCompleteDetail);

    /**
     * 根据派工单主键id查询派工类型(1.无偿服务，2.有偿服务)
     * @param dispatchListId 派工单主键id
     * @return 派工类型(1.无偿服务，2.有偿服务)
     */
    int findTypeByDispatchListId(Integer dispatchListId);

    /**
     * 修改派工单状态 和 时间（处理结束时间）
     * @param butlerUpdateStatusAndDate 管家app 修改派工单状态和时间
     * @return 影响行数
     */
    int updateStatusAndDate(ButlerUpdateStatusAndDate butlerUpdateStatusAndDate);

    /**
     * 根据派工单主键id 查询报事报修主键id
     * @param dispatchListId 派工单主键id
     * @return 报事报修主键id
     */
    int findRepairIdByDispatchListId(Integer dispatchListId);
}
