package com.api.app.dao.butler;

import com.api.model.app.AppHousekeepingService;
import com.api.model.app.AppHousekeepingServiceProcessRecord;
import com.api.model.app.SearchAppHousekeepingService;
import com.api.vo.app.AppHousekeepingServiceVo;

import java.util.List;

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

    /**
     * 查询所有的家政服务信息(包含条件搜索)
     * @param searchAppHousekeepingService app 新版家政服务搜素条件
     * @return 家政服务信息集合
     */
    List<AppHousekeepingServiceVo> list(SearchAppHousekeepingService searchAppHousekeepingService);

    /**
     * 根据家政服务主键id查询家政服务服务进程
     * @param housekeepingServiceId 家政服务主键id
     * @return 家政服务服务进程集合
     */
    List<AppHousekeepingServiceProcessRecord> findHousekeepingProcessRecord(Integer housekeepingServiceId);
}
