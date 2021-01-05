package com.api.manage.controller.system;

import com.api.manage.service.system.SysOrganizationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("manage/sysOrganization")
@RestController
public class SysOrganizationController {
    @Resource
    SysOrganizationService sysOrganizationService;

}
