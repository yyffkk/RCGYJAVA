package com.api.manage.service.businessManagement;

public interface SysDBManageService {
    void dbBackUp();

    void dbRecovery(String fileName, String backupDate);
}
