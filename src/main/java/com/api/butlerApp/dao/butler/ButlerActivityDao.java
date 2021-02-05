package com.api.butlerApp.dao.butler;

import com.api.vo.butlerApp.ButlerActivityFBIdVo;
import com.api.vo.butlerApp.ButlerActivityVo;

import java.util.List;

public interface ButlerActivityDao {
    /**
     * 管家app 查询所有的活动管理信息
     * @return 活动管理信息集合
     */
    List<ButlerActivityVo> list();

    /**
     * 根据活动管理主键id查询活动详情
     * @param activityId 活动管理主键id
     * @return 活动详情
     */
    ButlerActivityFBIdVo findById(Integer activityId);
}
