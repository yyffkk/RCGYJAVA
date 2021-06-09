package com.api.manage.service.dataStatistics.impl;

import com.api.manage.dao.dataStatistics.DataStatisticsDao;
import com.api.manage.service.dataStatistics.DataStatisticsService;
import com.api.vo.dataStatistics.LastMonthPayCostDetailVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class DataStatisticsServiceImpl implements DataStatisticsService {
    @Resource
    DataStatisticsDao dataStatisticsDao;
    private static Map<String,Object> map = null;

    @Override
    public Map<String, Object> findLastMonthPayCostDetail() {
        map = new HashMap<>();
        //查询上月账单已缴金额
        BigDecimal lastMonthPayPrice = dataStatisticsDao.findLastMonthPayPrice();
        //查询上月账单未缴金额
        BigDecimal lastMonthUnpaidPrice = dataStatisticsDao.findLastMonthUnpaidPrice();
        //查询上月账单应缴金额
        BigDecimal lastMonthShouldPayPrice = dataStatisticsDao.findLastMonthShouldPayPrice();
        //查询上月账单未缴户数
        BigDecimal lastMonthUnpaidHouseholds = dataStatisticsDao.findLastMonthUnpaidHouseholds();
        LastMonthPayCostDetailVo lastMonthPayCostDetailVo = new LastMonthPayCostDetailVo();
        lastMonthPayCostDetailVo.setLastMonthPayPrice(lastMonthPayPrice);
        lastMonthPayCostDetailVo.setLastMonthUnpaidPrice(lastMonthUnpaidPrice);
        lastMonthPayCostDetailVo.setLastMonthShouldPayPrice(lastMonthShouldPayPrice);
        lastMonthPayCostDetailVo.setLastMonthUnpaidHouseholds(lastMonthUnpaidHouseholds);

        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",lastMonthPayCostDetailVo);
        return map;
    }
}
