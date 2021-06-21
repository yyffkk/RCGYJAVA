package com.api.manage.controller.butlerService;

import com.api.manage.service.butlerService.LeaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 租赁（租户）管理
 */
@RestController
@RequestMapping("manage/complaintPraise")
public class LeaseController {
    @Resource
    LeaseService leaseService;
}
