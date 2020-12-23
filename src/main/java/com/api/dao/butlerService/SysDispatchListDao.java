package com.api.dao.butlerService;

import com.api.model.butlerService.*;
import com.api.vo.butlerService.*;

import java.util.List;

public interface SysDispatchListDao {
    /**
     * 查询所有的派工单信息 （包含条件搜素）
     * @param searchDispatchList 搜索条件
     * @return map
     */
    List<VoDispatchList> list(SearchDispatchList searchDispatchList);

    /**
     * 假删除工单
     * @param id 工单主键id
     * @return 影响行数
     */
    int falseDelete(Integer id);

    /**
     * 作废工单
     * @param cancelWorkOrder 作废信息
     * @return 影响行数
     */
    int cancel(CancelWorkOrder cancelWorkOrder);

    /**
     * 回访
     * @param revisitWorkOrder 回访信息
     * @return 影响行数
     */
    int revisit(RevisitWorkOrder revisitWorkOrder);

    /**
     * 根据工单主键id查询状态
     * @param id 工单主键id
     * @return 状态
     */
    int findStatusById(Integer id);

    /**
     * 回退工单
     * @param id 工单主键id
     * @return 影响行数
     */
    int rollback(Integer id);

    /**
     * 改变工单状态(变为1.待分配)
     * @param updateDispatchStatus 更改工单状态信息
     * @return 影响行数
     */
    int updateStatus(UpdateDispatchStatus updateDispatchStatus);

    /**
     * 添加派工单详情信息 并返回主键id
     * @param sysDispatchListDetail 派工单详情信息
     * @return 影响行数
     */
    int dispatch(SysDispatchListDetail sysDispatchListDetail);

    /**
     * 查询派工详情
     * @param id 工单主键id
     * @return 派工详情
     */
    VoDispatch findDispatchDetail(Integer id);

    /**
     * 查询客户评价
     * @param id 工单主键id
     * @return 客户评价信息
     */
    VoEvaluation findEvaluationById(Integer id);

    /**
     * 查询回访信息
     * @param id 工单主键id
     * @return 回访信息
     */
    VoRevisit findRevisitById(Integer id);

    /**
     * 添加工单信息 并返回主键id
     * @param dispatchList 工单信息
     * @return 影响行数
     */
    int insert(DispatchList dispatchList);
}
