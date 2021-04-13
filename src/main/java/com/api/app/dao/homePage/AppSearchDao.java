package com.api.app.dao.homePage;

import com.api.vo.app.AppActivityVo;
import com.api.vo.app.AppGambitVo;

import java.util.List;

public interface AppSearchDao {
    /**
     * 模糊查询社区活动信息
     * @param searchName 搜索条件
     * @return 社区活动信息
     */
    List<AppActivityVo> searchActivity(String searchName);

    /**
     * 模糊查询帖子活动信息
     * @param searchName 搜索条件
     * @return 帖子活动信息
     */
    List<AppGambitVo> searchGambit(String searchName);
}
