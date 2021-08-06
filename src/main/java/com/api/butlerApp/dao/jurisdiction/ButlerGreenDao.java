package com.api.butlerApp.dao.jurisdiction;

import com.api.model.butlerApp.ButlerGreenSearch;
import com.api.model.operationManagement.SysGreenTask;
import com.api.vo.butlerApp.ButlerGreenVo;

import java.util.List;

public interface ButlerGreenDao {
    /**
     * 查询所有的绿化管理（接单人界面）
     * @param butlerGreenSearch 管家app 绿化任务搜索条件
     * @return 绿化管理
     */
    List<ButlerGreenVo> list(ButlerGreenSearch butlerGreenSearch);

    /**
     * 查询所有的绿化管理（检查人界面）
     * @param butlerGreenSearch 管家app 绿化任务搜索条件
     * @return 绿化管理
     */
    List<ButlerGreenVo> list2(ButlerGreenSearch butlerGreenSearch);

    /**
     * 确认完成
     * @param sysGreenTask 绿化任务管理model信息
     * @return 影响行数
     */
    int complete(SysGreenTask sysGreenTask);

    /**
     * 根据绿化任务主键id查询绿化任务信息
     * @param id 绿化任务主键id
     * @return 绿化任务信息
     */
    SysGreenTask findTaskById(Integer id);

}
