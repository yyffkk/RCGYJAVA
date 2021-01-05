package com.api.manage.dao.operationManagement;

import com.api.model.operationManagement.ActivityManagement;
import com.api.model.operationManagement.SearchActivityManagement;
import com.api.vo.operationManagement.VoActivityManagement;
import com.api.vo.operationManagement.VoActivityRegistration;
import com.api.vo.operationManagement.VoFindByIdActivityManagement;

import java.util.List;

public interface SysActivityManagementDao {
    /**
     * 根据主键id查询主办次数
     * @param id 主键id
     * @return 主办次数count
     */
    int countBySponsorId(Integer id);

    /**
     * 查询所有的活动信息（包含条件搜索）
     * @param searchActivityManagement 搜索条件
     * @return 活动信息集合
     */
    List<VoActivityManagement> list(SearchActivityManagement searchActivityManagement);

    /**
     * 根据活动主键id查询报名人数
     * @param id 活动主键id
     * @return 报名人数
     */
    int countRegistrationByActivityId(Integer id);

    /**
     * 根据活动主键id查询报名记录信息
     * @param id 活动主键id
     * @return 报名记录信息集合
     */
    List<VoActivityRegistration> findRegistrationById(Integer id);


    /**
     * 添加活动信息
     * @param activityManagement 活动信息
     * @return 影响行数
     */
    int insert(ActivityManagement activityManagement);

    /**
     * 根据主键id查询活动信息
     * @param id 主键id
     * @return 活动信息
     */
    VoFindByIdActivityManagement findById(Integer id);

    /**
     * 修改活动信息
     * @param activityManagement 新活动信息
     * @return 影响行数
     */
    int update(ActivityManagement activityManagement);

    /**
     * 假删除活动信息
     * @param id 活动信息主键id
     * @return 影响行数
     */
    int falseDelete(int id);
}

