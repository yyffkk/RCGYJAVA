package com.api.manage.controller.businessManagement;

import com.api.manage.service.businessManagement.SysDBManageService;
import com.api.model.businessManagement.SysDbBackUp;
import com.api.model.businessManagement.SysDbRecovery;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 数据库管理
 */
@RequestMapping("manage/dbManage")
@RestController
public class SysDBManageController {
    private static Map<String,Object> map = null;
    @Resource
    SysDBManageService sysDBManageService;

    /**
     * 数据库备份
     * @return
     */
    @PostMapping("/dbBackUp")
    public Map<String,Object> dbBackUp(@RequestBody SysDbBackUp sysDbBackUp){
        map = new HashMap<>();
        String hostIP = sysDbBackUp.getHostIP(); //ip地址，可以是本机也可以是远程
        String userName = sysDbBackUp.getUserName(); //数据库的用户名
        String password = sysDbBackUp.getPassword(); //数据库的密码
        String savePath = sysDbBackUp.getSavePath(); //备份的路径
        String fileName = sysDbBackUp.getFileName(); //备份的文件名
        String databaseName = sysDbBackUp.getDatabaseName(); //需要备份的数据库的名称


        boolean b = sysDBManageService.dbBackUp(hostIP, userName, password, savePath, fileName, databaseName);

        if (b){
            map.put("message","操作成功");
            map.put("status",true);
        }else {
            map.put("message","操作失败");
            map.put("status",false);
        }

        return map;
    }

    /**
     * 数据库恢复
     * @return
     */
    @PostMapping("/dbRecovery")
    public Map<String,Object> dbRecovery(@RequestBody SysDbRecovery sysDbRecovery){
        map = new HashMap<>();
        String filepath = sysDbRecovery.getFilepath(); //数据库备份的脚本路径
        String ip = sysDbRecovery.getIp(); //IP地址
        String database = sysDbRecovery.getDatabase(); //数据库名称
        String userName = sysDbRecovery.getUserName(); //用户名
        String password = sysDbRecovery.getPassword(); //密码


        boolean b = sysDBManageService.dbRecovery(filepath, ip, database, userName, password);

        if (b){
            map.put("message","操作成功");
            map.put("status",true);
        }else {
            map.put("message","操作失败");
            map.put("status",false);
        }

        return map;
    }

}
