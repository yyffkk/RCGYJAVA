package com.api.manage.controller.dataStatistics;

import com.api.manage.service.dataStatistics.DataStatisticsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 数据统计(后台配置大屏)
 */
@RestController
@RequestMapping("manage/dataStatistics")
public class DataStatisticsController {
    @Resource
    DataStatisticsService dataStatisticsService;

    /**
     * 查询上月物业缴费情况
     * @return map
     */
    @GetMapping("/findLastMonthPayCostDetail")
    public Map<String,Object> findLastMonthPayCostDetail(){
        return dataStatisticsService.findLastMonthPayCostDetail();
    }

    /**
     * 物业缴费统计（6个月内数据）
     * @return map
     */
    @GetMapping("findPaymentStatistics")
    public Map<String,Object> findPaymentStatistics(){
        return dataStatisticsService.findPaymentStatistics();
    }

    /**
     * 查询今日环境卫生任务情况
     * @return map
     */
    @GetMapping("/findTodayEnvironmentalHealth")
    public Map<String,Object> findTodayEnvironmentalHealth(){
        return dataStatisticsService.findTodayEnvironmentalHealth();
    }

}
