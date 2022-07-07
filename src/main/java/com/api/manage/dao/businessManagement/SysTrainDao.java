package com.api.manage.dao.businessManagement;

import com.api.model.businessManagement.SearchTrain;
import com.api.model.businessManagement.SysTrain;
import com.api.vo.businessManagement.VoTrain;

import java.util.List;

public interface SysTrainDao {
    /**
     * 查询所有的培训信息
     * @param searchTrain 培训管理搜索条件
     * @return map
     */
    List<VoTrain> list(SearchTrain searchTrain);

    /**
     * 添加培训信息
     * @param sysTrain 培训信息model
     * @return 影响行数
     */
    int insert(SysTrain sysTrain);

    /**
     * 根据培训主键id删除培训信息
     * @param id 培训主键id
     * @return 影响行数
     */
    int delete(int id);
}
