package com.api.manage.dao.operationManagement;

import com.api.model.operationManagement.SysHygieneTask;
import com.api.model.operationManagement.SearchHygieneTask;
import com.api.vo.butlerApp.ButlerHygieneTaskCheckSituationVo;
import com.api.vo.operationManagement.VoFBIHygieneTask;
import com.api.vo.operationManagement.VoHygieneTask;

import java.util.List;

public interface SysHygieneTaskDao {
    /**
     * 查询所有的卫生任务信息(包含条件搜索)
     * @param searchHygieneTask 卫生任务搜索条件
     * @return 卫生任务信息
     */
    List<VoHygieneTask> list(SearchHygieneTask searchHygieneTask);

    /**
     * 添加卫生任务信息
     * @param sysHygieneTask 卫生任务model信息
     * @return 影响行数
     */
    int insert(SysHygieneTask sysHygieneTask);

    /**
     * 根据卫生任务主键id 查询卫生任务信息
     * @param id 卫生任务主键id
     * @return 卫生任务信息
     */
    VoFBIHygieneTask findById(Integer id);

    /**
     * 根据卫生任务主键id 删除卫生任务信息
     * @param id 卫生任务主键id
     * @return 影响行数
     */
    int delete(int id);

    /**
     * 根据卫生任务主键id查询卫生任务检查报告信息
     * @param hygieneTaskId 卫生任务主键id
     * @return 卫生任务检查报告信息
     */
    List<ButlerHygieneTaskCheckSituationVo> findCheckSituationByHygieneTaskId(Integer hygieneTaskId);

}
