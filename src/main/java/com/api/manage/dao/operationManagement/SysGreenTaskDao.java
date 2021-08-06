package com.api.manage.dao.operationManagement;

import com.api.model.operationManagement.SearchGreenTask;
import com.api.model.operationManagement.SysGreenTask;
import com.api.vo.butlerApp.ButlerGreenTaskCheckSituationVo;
import com.api.vo.operationManagement.VoGreenTask;

import java.util.List;

public interface SysGreenTaskDao {
    /**
     * 查询所有的绿化任务（包含条件搜索）
     * @param searchGreenTask 搜索条件
     * @return 绿化任务
     */
    List<VoGreenTask> list(SearchGreenTask searchGreenTask);

    /**
     * 添加绿化任务信息
     * @param sysGreenTask 绿化任务信息
     * @return 影响行数
     */
    int insert(SysGreenTask sysGreenTask);

    /**
     * 根据绿化任务主键id删除绿化任务信息
     * @param id 绿化任务主键id
     * @return 影响行数
     */
    int delete(int id);

    /**
     * 根据绿化任务主键id查询绿化任务检查报告信息
     * @param greenTaskId 绿化任务主键id
     * @return 绿化任务检查报告信息
     */
    List<ButlerGreenTaskCheckSituationVo> findCheckSituationByGreenTaskId(Integer greenTaskId);
}
