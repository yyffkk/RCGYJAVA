package com.api.manage.controller.butlerService;

import com.api.manage.service.butlerService.LeaseContractService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 租赁合同管理
 */
@RestController
@RequestMapping("manage/leaseContract")
public class LeaseContractController {
    @Resource
    LeaseContractService leaseContractService;



}
