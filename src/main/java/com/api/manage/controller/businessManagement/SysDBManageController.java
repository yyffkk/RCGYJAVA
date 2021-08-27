package com.api.manage.controller.businessManagement;

import com.api.manage.service.businessManagement.SysDBManageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.*;
import java.util.Map;

/**
 * 数据库管理
 */
@RequestMapping("manage/dbManage")
@RestController
public class SysDBManageController {
    @Resource
    SysDBManageService sysDBManageService;

    @GetMapping("/dbBackUp")
    public Map<String,Object> dbBackUp(){

        sysDBManageService.dbBackUp();

        return null;
    }

    @GetMapping("/dbRecovery")
    public Map<String,Object> dbRecovery(String fileName,String backupDate){
        sysDBManageService.dbRecovery(fileName,backupDate);

        return null;
    }

}
