package com.api.manage.dao.dataStatistics;

import com.api.vo.dataStatistics.EnvironmentalHealthVo;
import com.api.vo.dataStatistics.PaymentStatisticsVo;

import java.math.BigDecimal;
import java.util.List;

public interface DataStatisticsDao {
    /**
     * 查询上月账单已缴金额
     * @return 上月账单已缴金额
     */
    BigDecimal findLastMonthPayPrice();

    /**
     * 查询上月账单未缴金额
     * @return 上月账单未缴金额
     */
    BigDecimal findLastMonthUnpaidPrice();

    /**
     * 查询上月账单应缴金额
     * @return 上月账单应缴金额
     */
    BigDecimal findLastMonthShouldPayPrice();

    /**
     * 查询上月账单未缴户数
     * @return 上月账单未缴户数
     */
    BigDecimal findLastMonthUnpaidHouseholds();

    /**
     * 物业缴费统计（6个月数据）
     * @return 物业缴费统计
     */
    List<PaymentStatisticsVo> findPaymentStatistics();

    /**
     * 查询绿化任务总任务数
     * @return 绿化任务总任务数
     */
    Integer findGreenTaskTotal();

    /**
     * 查询绿化任务待完成任务数
     * @return 绿化任务待完成任务数
     */
    Integer findGreenTaskPending();

    /**
     * 查询绿化任务已完成任务数
     * @return 绿化任务已完成任务数
     */
    Integer findGreenTaskCompleted();

    /**
     * 查询绿化任务未完成任务数
     * @return 绿化任务未完成任务数
     */
    Integer findGreenTaskUnFinished();

    /**
     * 查询卫生任务总任务数
     * @return 卫生任务总任务数
     */
    Integer findHygieneTaskTotal();

    /**
     * 查询卫生任务待完成任务数
     * @return 卫生任务待完成任务数
     */
    Integer findHygieneTaskPending();

    /**
     * 查询卫生任务已完成任务数
     * @return 卫生任务已完成任务数
     */
    Integer findHygieneTaskCompleted();

    /**
     * 查询卫生任务未完成任务数
     * @return 卫生任务未完成任务数
     */
    Integer findHygieneTaskUnFinished();
}
