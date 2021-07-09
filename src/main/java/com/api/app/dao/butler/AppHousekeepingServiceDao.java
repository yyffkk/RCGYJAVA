package com.api.app.dao.butler;

import com.api.model.app.AppHousekeepingService;

public interface AppHousekeepingServiceDao {
    /**
     * 添加家政服务信息
     * @param appHousekeepingService app 新版家政服务 model
     * @return 影响行数
     */
    int submitHousekeeping(AppHousekeepingService appHousekeepingService);
}
