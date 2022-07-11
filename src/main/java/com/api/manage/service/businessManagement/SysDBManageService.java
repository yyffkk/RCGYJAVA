package com.api.manage.service.businessManagement;

public interface SysDBManageService {
    boolean dbBackUp(String hostIP, String userName, String password, String savePath, String fileName,
                  String databaseName);

    boolean dbRecovery(String filepath,String ip,String database, String userName,String password);
}
