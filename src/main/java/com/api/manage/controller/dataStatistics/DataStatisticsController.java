package com.api.manage.controller.dataStatistics;

import com.api.manage.service.dataStatistics.DataStatisticsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 数据统计(后台配置大屏)
 */
@RestController
@RequestMapping("/dataStatistics")
public class DataStatisticsController {
    @Resource
    DataStatisticsService dataStatisticsService;


}
