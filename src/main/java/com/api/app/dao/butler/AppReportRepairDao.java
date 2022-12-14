package com.api.app.dao.butler;

import com.api.model.app.AppRepairEvaluate;
import com.api.model.app.AppRepairOrder;
import com.api.model.app.UserIdAndRepairId;
import com.api.vo.app.AppDispatchListVo;
import com.api.vo.app.AppMaintenanceResultVo;
import com.api.vo.app.AppProcessRecordVo;
import com.api.vo.app.AppReportRepairVo;

import java.math.BigDecimal;
import java.util.List;

public interface AppReportRepairDao {
    /**
     * app查询当前用户的报事报修信息
     * @param id 用户主键id
     * @return app报事报修Vo list
     */
    List<AppReportRepairVo> list(Integer id);

    /**
     * 根据用户id和报事报修主键id查询app报事报修Vo
     * @param userIdAndRepairId 用户id和报事报修主键id
     * @return app报事报修Vo
     */
    AppReportRepairVo findRepairByIds(UserIdAndRepairId userIdAndRepairId);

    /**
     * 根据用户id和报事报修主键id查询app维修信息
     * @param userIdAndRepairId 用户id和报事报修主键id
     * @return app维修信息
     */
    AppDispatchListVo findDispatchListByIds(UserIdAndRepairId userIdAndRepairId);

    /**
     * 根据用户id和报事报修主键id查询app进程处理
     * @param userIdAndRepairId 用户id和报事报修主键id
     * @return app进程处理集合
     */
    List<AppProcessRecordVo>  findProcessRecordByIds(UserIdAndRepairId userIdAndRepairId);

    /**
     * //根据 用户id和报事报修主键id 查询维修结果信息
     * @param userIdAndRepairId 用户id和报事报修主键id
     * @return 维修结果信息
     */
    AppMaintenanceResultVo findHandleCompleteByIds(UserIdAndRepairId userIdAndRepairId);


    /**
     * 假删除报事报修信息，将工单表的 用户端删除字段 改为 0.删除
     * @param userIdAndRepairId 用户id和报事报修主键id
     * @return 影响行数
     */
    int falseDelete(UserIdAndRepairId userIdAndRepairId);

    /**
     * 取消订单
     * @param userIdAndRepairId 用户id和报事报修主键id
     * @return 影响行数
     */
    int cancel(UserIdAndRepairId userIdAndRepairId);

    /**
     * 根据用户id和报事报修主键id 查询派工单id
     * @param userIdAndRepairId 用户id和报事报修主键id
     * @return 影响行数
     */
    int findDispatchListIdByIds(UserIdAndRepairId userIdAndRepairId);

    /**
     * 用户确认完成订单，改变报修单状态为 5.已确认已完成
     * @param userIdAndRepairId 用户id和报事报修主键id
     * @return 影响行数
     */
    int completeOrder(UserIdAndRepairId userIdAndRepairId);

    /**
     * 用户评价
     * @param appRepairEvaluate app报事报修评论信息
     * @return 影响行数
     */
    int evaluate(AppRepairEvaluate appRepairEvaluate);

    /**
     * 根据报事报修主键id查询报修人
     * @param repairId 报事报修主键id
     * @return 报修人
     */
    int findRepairmanByRepairId(Integer repairId);

    /**
     * 添加报事报修订单信息
     * @param appDispatchListOrder app 报事报修订单
     * @return 影响行数
     */
    int insertOrder(AppRepairOrder appDispatchListOrder);

    /**
     * 根据报事报修主键id查询付款金额
     * @param reportRepairId 报事报修主键id
     * @return 付款金额
     */
    BigDecimal findPayPriceById(Integer reportRepairId);

    /**
     * 根据支付单号查询支付订单信息
     * @param outTradeNo 支付单号
     * @return 支付订单信息
     */
    AppRepairOrder findRepairOrderByCode(String outTradeNo);

    /**
     * 更新支付订单状态
     * @param appRepairOrder app 报事报修订单
     * @return 影响行数
     */
    int updateDPOrderStatusByCode(AppRepairOrder appRepairOrder);

    /**
     * 查询未付款的订单
     * @return 未付款的订单信息
     */
    List<AppRepairOrder> findUnPaymentOrder();
}
