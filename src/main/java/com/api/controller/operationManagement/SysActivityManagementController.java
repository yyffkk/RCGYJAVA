package com.api.controller.operationManagement;

import com.api.service.operationManagement.SysActivityManagementService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 活动管理
 */
@RestController
@RequestMapping("/activityManagement")
public class SysActivityManagementController {
    @Resource
    SysActivityManagementService sysActivityManagementService;
}
