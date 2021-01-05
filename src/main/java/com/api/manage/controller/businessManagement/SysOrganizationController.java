package com.api.manage.controller.businessManagement;

import com.api.manage.service.businessManagement.SysOrganizationService;
import com.api.model.businessManagement.SearchOrganization;
import com.api.vo.businessManagement.VoOrganization;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("manage/sysOrganization")
@RestController
public class SysOrganizationController {
    @Resource
    SysOrganizationService sysOrganizationService;

    @GetMapping("/list")
    public VoOrganization list(SearchOrganization searchOrganization){
        return sysOrganizationService.list(searchOrganization);
    }

}
