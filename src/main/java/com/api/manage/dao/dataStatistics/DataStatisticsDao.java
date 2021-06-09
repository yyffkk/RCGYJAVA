package com.api.manage.dao.dataStatistics;

import java.math.BigDecimal;

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

}
