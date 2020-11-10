package com.aku.controller.system;

import com.aku.service.system.SysOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("sysOrganization")
@RestController
public class SysOrganizationController {
    @Autowired
    SysOrganizationService sysOrganizationService;

}
