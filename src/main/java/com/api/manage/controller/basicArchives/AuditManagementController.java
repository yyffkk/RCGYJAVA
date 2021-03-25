package com.api.manage.controller.basicArchives;

import com.api.manage.service.basicArchives.AuditManagementService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 审核管理
 */
@RestController("manage/auditManagement")
public class AuditManagementController {
    @Resource
    AuditManagementService auditManagementService;

    @GetMapping("/list")
    public Map<String,Object> list(){
        return null;
    }
}
