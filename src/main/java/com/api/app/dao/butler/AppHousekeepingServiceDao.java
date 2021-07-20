package com.api.app.dao.butler;

import com.api.model.app.AppHousekeepingService;
import com.api.model.app.AppHousekeepingServiceProcessRecord;
import com.api.model.app.SearchAppHousekeepingService;
import com.api.model.app.UserIdAndHousekeepingServiceId;
import com.api.model.businessManagement.SysUser;
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

    /**
     * 取消服务
     * @param userIdAndHousekeepingServiceId 家政服务主键id 和 用户主键id
     * @return 影响行数
     */
    int cancel(UserIdAndHousekeepingServiceId userIdAndHousekeepingServiceId);

    /**
     * 根据家政服务主键id查询家政服务信息
     * @param housekeepingServiceId 家政服务主键id
     * @return 家政服务信息
     */
    AppHousekeepingService findHousekeepingServiceById(Integer housekeepingServiceId);

    /**
     * 评价
     * @param appHousekeepingService app 新版家政服务 model
     * @return 影响行数
     */
    int evaluation(AppHousekeepingService appHousekeepingService);

    /**
     * 根据被指派人主键id查询被指派人信息
     * @param handler 被指派人主键id
     * @return 被指派人信息
     */
    SysUser findUserInfoById(Integer handler);

    /**
     * 接单
     * @param appHousekeepingService app 新版家政服务 model
     * @return 影响行数
     */
    int orderReceiving(AppHousekeepingService appHousekeepingService);

    /**
     * 提交报告
     * @param appHousekeepingService app 新版家政服务 model
     * @return 影响行数
     */
    int submitReport(AppHousekeepingService appHousekeepingService);
}
