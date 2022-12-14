package com.api.manage.service.dataStatistics;

import java.util.Map;

public interface DataStatisticsService {
    Map<String, Object> findLastMonthPayCostDetail();

    Map<String, Object> findPaymentStatistics();

    Map<String, Object> findTodayEnvironmentalHealth();

    Map<String, Object> findTodayInspectionRecord();

}
