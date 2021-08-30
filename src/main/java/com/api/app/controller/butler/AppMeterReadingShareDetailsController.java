package com.api.app.controller.butler;


import com.api.app.service.butler.AppMeterReadingShareDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * app 抄表分摊详情管理
 */
@RestController
@RequestMapping("app/user/meterReadingShareDetails")
public class AppMeterReadingShareDetailsController {
    @Resource
    AppMeterReadingShareDetailsService appMeterReadingShareDetailsService;
}
