package com.api.manage.controller.chargeManagement;

import com.api.manage.service.chargeManagement.SysMeterReadingRecordService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 抄表记录管理
 */
@RestController
@RequestMapping("manage/meterReadingRecord")
public class SysMeterReadingRecordController {
    @Resource
    SysMeterReadingRecordService meterReadingRecordService;


}
