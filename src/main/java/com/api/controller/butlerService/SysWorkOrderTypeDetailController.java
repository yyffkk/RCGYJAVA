package com.api.controller.butlerService;

import com.api.service.butlerService.SysWorkOrderTypeDetailService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 工单类型明细管理
 */
@RestController
@RequestMapping("/workOrderTypeDetail")
public class SysWorkOrderTypeDetailController {
    @Resource
    SysWorkOrderTypeDetailService sysWorkOrderTypeDetailService;
}
