package com.api.butlerApp.dao.jurisdiction;

import com.api.model.butlerApp.ButlerArticleOutNoRelease;
import com.api.model.butlerApp.ButlerArticleOutRelease;
import com.api.model.butlerApp.ButlerArticleOutSearch;
import com.api.vo.butlerApp.ButlerAOFindByIdVo;
import com.api.vo.butlerApp.ButlerArticleOutVo;

import java.util.List;

public interface ButlerArticleOutDao {
    /**
     * 查询所有的物品出户信息(包含搜索条件)
     * @param articleOutSearch 管家app 物品出门 搜索条件
     * @return 物品出户信息集合
     */
    List<ButlerArticleOutVo> list(ButlerArticleOutSearch articleOutSearch);

    /**
     * 根据物品出户主键id查询出户详情
     * @param articleOutId 物品出户主键id
     * @return 出户详情
     */
    ButlerAOFindByIdVo findById(Integer articleOutId);

    /**
     * 放行
     * @param articleOutRelease 管家app物品出户 放行model
     * @return 影响行数
     */
    int release(ButlerArticleOutRelease articleOutRelease);

    /**
     * 放行
     * @param articleOutNoRelease 管家app 物品出户 不放行model
     * @return 影响行数
     */
    int noRelease(ButlerArticleOutNoRelease articleOutNoRelease);
}
