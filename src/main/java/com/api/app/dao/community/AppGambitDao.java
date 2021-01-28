package com.api.app.dao.community;

import com.api.vo.app.AppGambitThemeCommentVo;
import com.api.vo.app.AppGambitThemeVo;

import java.util.List;

public interface AppGambitDao {
    /**
     * 查询最新的所有主题信息
     * @return 主题信息集合
     */
    List<AppGambitThemeVo> list();

    /**
     * 根据主题主键id查询主题评论信息
     * @param ThemeId 主题主键id
     * @return 主题评论信息集合
     */
    List<AppGambitThemeCommentVo> findCommentByThemeId(Integer ThemeId);
}
