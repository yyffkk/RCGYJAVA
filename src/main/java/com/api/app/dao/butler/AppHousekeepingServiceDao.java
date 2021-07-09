package com.api.app.dao.butler;

import com.api.model.app.AppHousekeepingService;
import com.api.model.app.AppHousekeepingServiceProcessRecord;

public interface AppHousekeepingServiceDao {
    /**
     * 添加家政服务信息
     * @param appHousekeepingService app 新版家政服务 model
     * @return 影响行数
     */
    int submitHousekeeping(AppHousekeepingService appHousekeepingService);

    /**
     * 添加家政服务处理进程记录
     * @param processRecord app 新版家政服务处理进程记录
     * @return 影响行数
     */
    int insertHousekeepingProcessRecord(AppHousekeepingServiceProcessRecord processRecord);
}
