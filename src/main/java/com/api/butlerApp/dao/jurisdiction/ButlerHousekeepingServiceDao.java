package com.api.butlerApp.dao.jurisdiction;

import com.api.model.app.AppHousekeepingService;
import com.api.model.businessManagement.SysUser;
import com.api.model.butlerApp.ButlerHousekeepingServiceSearch;
import com.api.vo.app.AppHousekeepingServiceVo;

import java.util.List;

public interface ButlerHousekeepingServiceDao {
    /**
     * 查询所有的家政服务信息（派单人界面）
     * @param butlerHousekeepingServiceSearch 管家app  新版家政服务搜索条件
     * @return 派单人界面
     */
    List<AppHousekeepingServiceVo> list1(ButlerHousekeepingServiceSearch butlerHousekeepingServiceSearch);

    /**
     * 查询所有的家政服务信息（接单人界面）
     * @param butlerHousekeepingServiceSearch 管家app  新版家政服务搜索条件
     * @return 接单人界面
     */
    List<AppHousekeepingServiceVo> list2(ButlerHousekeepingServiceSearch butlerHousekeepingServiceSearch);

    /**
     * 查询所有的接单人员
     * @param organizationId 部门id
     * @return 接单人员
     */
    List<SysUser> findPickUpSinglePersonnel(int organizationId);

    /**
     * 派单
     * @param appHousekeepingService app 新版家政服务 model
     * @return 影响行数
     */
    int sendSingle(AppHousekeepingService appHousekeepingService);
}
