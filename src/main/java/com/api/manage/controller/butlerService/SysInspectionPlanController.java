package com.api.manage.controller.butlerService;

import com.api.manage.service.butlerService.SysInspectionPointService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 巡检计划管理
 */
@RestController
@RequestMapping("manage/inspectionPlan")
public class SysInspectionPlanController {
    @Resource
    SysInspectionPointService sysInspectionPointService;


}
