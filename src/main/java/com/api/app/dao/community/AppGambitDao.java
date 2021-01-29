package com.api.app.dao.community;

import com.api.model.app.AppGambitThemeLike;
import com.api.model.app.UserIdAndThemeId;
import com.api.vo.app.IdAndName;
import com.api.vo.app.AppGambitThemeCommentVo;
import com.api.vo.app.AppGambitThemeVo;
import com.api.vo.app.AppGambitVo;
import com.api.vo.app.AppMyTidingsVo;

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

    /**
     * 我的动态
     * @param id 用户id
     * @return 动态信息
     */
    List<AppMyTidingsVo> myTidings(Integer id);

    /**
     * 根据主题主键id查询点赞人信息
     * @param id 主题主键id
     * @return 点赞人信息
     */
    List<IdAndName> findLikeNames(Integer id);

    /**
     * 根据主题主键id 查询 主题信息
     * @param themeId 主题主键id
     * @return app最新主题信息Vo list 回显
     */
    AppGambitThemeVo GambitThemeDetail(Integer themeId);

    /**
     * 根据主题主键id 查询 话题id
     * @param themeId 主题主键id
     * @return 话题id
     */
    Integer findGambitIdByThemeId(Integer themeId);

    /**
     * 根据用户id与主题id查询 点赞信息
     * @param userIdAndThemeId 用户id 与 主题主键id
     * @return app点赞信息model
     */
    AppGambitThemeLike findThemeLikeByIds(UserIdAndThemeId userIdAndThemeId);


    /**
     * 添加点赞人信息
     * @param appGambitThemeLike app点赞人信息model
     * @return 影响行数
     */
    int insertThemeLike(AppGambitThemeLike appGambitThemeLike);


    /**
     * 删除点赞信息
     * @param id 点赞信息主键id
     * @return 影响行数
     */
    int deleteThemeLike(Integer id);

    /**
     * 该主题的点赞数量+1
     * @param themeId 主题主键id
     * @return 影响行数
     */
    int incrLikesByTheme(Integer themeId);

    /**
     * 该主题的点赞数量-1
     * @param themeId 主题主键id
     * @return 影响行数
     */
    int decrLikesByTheme(Integer themeId);


    /**
     * 假删除主题信息（只能删除自己的）
     * @param userIdAndThemeId 用户id 与 主题主键id
     * @return 影响行数
     */
    int falseDelete(UserIdAndThemeId userIdAndThemeId);
}