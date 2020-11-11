package com.aku.controller.system;

import com.aku.service.system.SysOrganizationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("sysOrganization")
@RestController
public class SysOrganizationController {
    @Resource
    SysOrganizationService sysOrganizationService;

}
