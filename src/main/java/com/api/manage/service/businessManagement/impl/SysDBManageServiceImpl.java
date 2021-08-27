package com.api.manage.service.businessManagement.impl;

import com.api.manage.service.businessManagement.SysDBManageService;
import com.api.model.businessManagement.SysBackupAndRecoveryConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class SysDBManageServiceImpl implements SysDBManageService {
    @Value("${spring.datasource.url}")
    private String sqlUrl;
    @Value("${spring.datasource.username}")
    private String userName;
    @Value("${spring.datasource.password}")
    private String passWord;

    @Override
    public void dbBackUp() {

    }

    @Override
    public void dbRecovery(String fileName, String backupDate) {

    }

    /**
     *解析数据库连接语句获取想要的数据
     *
     */
    public void setBackupInfo()
    {
        SysBackupAndRecoveryConfig sysBackupAndRecoveryConfig = new SysBackupAndRecoveryConfig();
        String sqlPath=sqlUrl;
        String[] split = sqlPath.split(":");
        sysBackupAndRecoveryConfig.setHost(split[2].substring(2));
        String[] splits= split[3].split("/");
        sysBackupAndRecoveryConfig.setPort(splits[0]);
        sysBackupAndRecoveryConfig.setCharset(splits[1].split("\\?")[1].split("&")[0].split("=")[1]);
        sysBackupAndRecoveryConfig.setDatabase(splits[1].split("\\?")[0]);
        sysBackupAndRecoveryConfig.setUsername( userName);
        sysBackupAndRecoveryConfig.setPassword(passWord);
    }
}
