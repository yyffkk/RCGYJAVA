package com.api.butlerApp.dao.jurisdiction;

import com.api.model.butlerApp.ButlerHygieneSearch;
import com.api.model.butlerApp.ButlerHygieneTaskCheckSituation;
import com.api.model.butlerApp.ButlerHygieneTaskIdAndStatus;
import com.api.model.operationManagement.SysHygieneTask;
import com.api.vo.butlerApp.ButlerHygieneVo;

import java.util.List;

public interface ButlerHygieneDao {
    /**
     * 查询所有的卫生管理(接单人)
     * @param butlerHygieneSearch 管家app 卫生任务搜索条件
     * @return 卫生管理
     */
    List<ButlerHygieneVo> list(ButlerHygieneSearch butlerHygieneSearch);

    /**
     * 查询所有的卫生管理(检查人)
     * @param butlerHygieneSearch 管家app 卫生任务搜索条件
     * @return 卫生管理
     */
    List<ButlerHygieneVo> list2(ButlerHygieneSearch butlerHygieneSearch);

    /**
     * 确认完成
     * @param sysHygieneTask 卫生任务管理model信息
     * @return 影响行数
     */
    int complete(SysHygieneTask sysHygieneTask);

    /**
     * 根据卫生任务主键id查询卫生任务信息
     * @param id 卫生任务主键id
     * @return 卫生任务信息
     */
    SysHygieneTask findTaskById(Integer id);

    /**
     * 修改卫生任务的状态
     * @param hygieneTaskIdAndStatus 管家app 卫生任务主键id 和 状态
     * @return 影响行数
     */
    int updateStatusById(ButlerHygieneTaskIdAndStatus hygieneTaskIdAndStatus);

    /**
     * 添加卫生任务检查情况
     * @param hygieneTaskCheckSituation 管家app 卫生任务检查情况
     * @return 影响行数
     */
    int insertHygieneTaskCheckSituation(ButlerHygieneTaskCheckSituation hygieneTaskCheckSituation);

}
