package com.aku.dao.butlerService;

import com.aku.model.butlerService.SearchUserArticleOut;
import com.aku.model.butlerService.UserArticleOut;
import com.aku.vo.butlerService.VoUserArticleOut;

import java.util.List;
import java.util.Map;

public interface UserArticleOutDao {
    /**
     * 查询所有物品出门信息（包含条件搜索）
     * @param searchUserArticleOut 搜索条件
     * @return 物品出门信息集合
     */
    List<VoUserArticleOut> list(SearchUserArticleOut searchUserArticleOut);

    /**
     * 根据主键id删除物品出门信息
     * @param id 物品出门主键id数组
     * @return 影响行数
     */
    int delete(int id);

    /**
     * 驳回申请
     * @param userArticleOut 驳回相关信息
     * @return 影响行数
     */
    int applicationRejection(UserArticleOut userArticleOut);

    /**
     * 查询今日预计家庭物品出户数量
     * @return 今日预计家庭物品出户数量
     */
    Integer countArticleOutNow();

    /**
     * 查询未执行的家庭物品出户数量
     * @return 未执行的家庭物品出户数量
     */
    Integer countPerformed();
}
