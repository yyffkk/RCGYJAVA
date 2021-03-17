package com.api.manage.controller.butlerService;

import com.api.manage.service.butlerService.SysInspectionRouteService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 巡检路线管理
 */
@RestController
@RequestMapping("manage/inspectionRoute")
public class SysInspectionRouteController {
    @Resource
    SysInspectionRouteService sysInspectionRouteService;
}
