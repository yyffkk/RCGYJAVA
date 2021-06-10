package com.api.manage.service.dataStatistics.impl;

import com.api.manage.dao.dataStatistics.DataStatisticsDao;
import com.api.manage.service.dataStatistics.DataStatisticsService;
import com.api.vo.dataStatistics.EnvironmentalHealthVo;
import com.api.vo.dataStatistics.LastMonthPayCostDetailVo;
import com.api.vo.dataStatistics.PaymentStatisticsVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
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

    @Override
    public Map<String, Object> findPaymentStatistics() {
        map = new HashMap<>();
        List<PaymentStatisticsVo> paymentStatisticsVos = dataStatisticsDao.findPaymentStatistics();
        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",paymentStatisticsVos);
        return map;
    }

    @Override
    public Map<String, Object> findTodayEnvironmentalHealth() {
        map = new HashMap<>();
        EnvironmentalHealthVo environmentalHealthVo = new EnvironmentalHealthVo();
        //查询绿化任务总任务数
        Integer greenTaskTotal = dataStatisticsDao.findGreenTaskTotal();
        //查询绿化任务待完成任务数
        Integer greenTaskPending = dataStatisticsDao.findGreenTaskPending();
        //查询绿化任务已完成任务数
        Integer greenTaskCompleted = dataStatisticsDao.findGreenTaskCompleted();
        //查询绿化任务未完成任务数
        Integer greenTaskUnFinished = dataStatisticsDao.findGreenTaskUnFinished();

        //查询卫生任务总任务数
        Integer hygieneTaskTotal = dataStatisticsDao.findHygieneTaskTotal();
        //查询卫生任务待完成任务数
        Integer hygieneTaskPending = dataStatisticsDao.findHygieneTaskPending();
        //查询卫生任务已完成任务数
        Integer hygieneTaskCompleted = dataStatisticsDao.findHygieneTaskCompleted();
        //查询卫生任务未完成任务数
        Integer hygieneTaskUnFinished = dataStatisticsDao.findHygieneTaskUnFinished();

        environmentalHealthVo.setGreenTaskTotal(greenTaskTotal);
        environmentalHealthVo.setGreenTaskPending(greenTaskPending);
        environmentalHealthVo.setGreenTaskCompleted(greenTaskCompleted);
        environmentalHealthVo.setGreenTaskUnFinished(greenTaskUnFinished);

        environmentalHealthVo.setHygieneTaskTotal(hygieneTaskTotal);
        environmentalHealthVo.setHygieneTaskPending(hygieneTaskPending);
        environmentalHealthVo.setHygieneTaskCompleted(hygieneTaskCompleted);
        environmentalHealthVo.setHygieneTaskUnFinished(hygieneTaskUnFinished);


        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",environmentalHealthVo);
        return map;
    }
}
