package com.api.controller.butlerService;

import com.api.service.butlerService.SysReportRepairService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 报事报修表
 */
@RestController
@RequestMapping("reportRepair")
public class SysReportRepairController {
    @Resource
    SysReportRepairService sysReportRepairService;

    
}
