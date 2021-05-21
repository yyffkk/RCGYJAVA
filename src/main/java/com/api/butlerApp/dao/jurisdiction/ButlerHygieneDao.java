package com.api.butlerApp.dao.jurisdiction;

import com.api.model.butlerApp.ButlerHygieneSearch;
import com.api.model.operationManagement.SysHygieneTask;
import com.api.vo.butlerApp.ButlerHygieneVo;

import java.util.List;

public interface ButlerHygieneDao {
    /**
     * 查询所有的卫生管理
     * @param butlerHygieneSearch 管家app 卫生任务搜索条件
     * @return 卫生管理
     */
    List<ButlerHygieneVo> list(ButlerHygieneSearch butlerHygieneSearch);

    /**
     * 确认完成
     * @param sysHygieneTask 卫生任务管理model信息
     * @return 影响行数
     */
    int complete(SysHygieneTask sysHygieneTask);
}
