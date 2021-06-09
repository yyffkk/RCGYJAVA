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
@RequestMapping("/dataStatistics")
public class DataStatisticsController {
    @Resource
    DataStatisticsService dataStatisticsService;

//    /**
//     * 查询上月物业缴费情况
//     * @return map
//     */
//    @GetMapping("/findLastMonthPayCostDetail")
//    public Map<String,Object> findLastMonthPayCostDetail(){
//
//    }


}
