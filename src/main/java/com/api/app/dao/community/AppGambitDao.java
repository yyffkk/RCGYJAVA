package com.api.app.dao.community;

import com.api.vo.app.AppGambitThemeCommentVo;
import com.api.vo.app.AppGambitThemeVo;
import com.api.vo.app.AppGambitVo;

import java.util.List;

public interface AppGambitDao {
    /**
     * 查询最新的所有主题信息
     * @return 主题信息集合
     * @param id
     */
    List<AppGambitThemeVo> list(Integer id);

    /**
     * 根据主题主键id查询主题评论信息
     * @param ThemeId 主题主键id
     * @return 主题评论信息集合
     */
    List<AppGambitThemeCommentVo> findCommentByThemeId(Integer ThemeId);

    /**
     * 查询所有的话题
     * @return 话题集合
     */
    List<AppGambitVo> listGambit();

    /**
     * 查询点赞数
     * @param id 话题主键id
     * @return 总点赞数
     */
    int sumLikeNum(Integer id);

    /**
     * 查询评论数
     * @param id 话题主键id
     * @return 总评论数
     */
    int sumCommentNum(Integer id);
}
