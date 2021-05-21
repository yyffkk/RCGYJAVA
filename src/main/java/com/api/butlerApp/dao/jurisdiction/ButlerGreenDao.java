package com.api.butlerApp.dao.jurisdiction;

import com.api.model.butlerApp.ButlerGreenSearch;
import com.api.model.operationManagement.SysGreenTask;
import com.api.vo.butlerApp.ButlerGreenVo;

import java.util.List;

public interface ButlerGreenDao {
    /**
     * 查询所有的绿化管理
     * @param butlerGreenSearch 管家app 绿化任务搜索条件
     * @return 绿化管理
     */
    List<ButlerGreenVo> list(ButlerGreenSearch butlerGreenSearch);

    /**
     * 确认完成
     * @param sysGreenTask 绿化任务管理model信息
     * @return 影响行数
     */
    int complete(SysGreenTask sysGreenTask);
}
