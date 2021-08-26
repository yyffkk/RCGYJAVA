package com.api.manage.dao.butlerService;

import com.api.model.butlerService.SearchGambitTheme;
import com.api.model.system.SysFunctionSwitch;
import com.api.vo.butlerService.VoGambitTheme;
import com.api.vo.butlerService.VoGambitThemeComment;

import java.util.List;

public interface SysGambitThemeDao {
    /**
     * 查询所有的主题明细信息 （包含条件搜索）
     * @param searchGambitTheme 搜索条件
     * @return 主题明细信息集合
     */
    List<VoGambitTheme> list(SearchGambitTheme searchGambitTheme);

    /**
     * 查询点赞人数
     * @param id 主题明细主键id
     * @return 点赞人数
     */
    int countLikeNum(Integer id);

    /**
     * 查询评论人数
     * @param id 主题明细主键id
     * @return 评论人数
     */
    int countCommentNum(Integer id);

    /**
     * 根据主题明细主键id删除主题明细信息
     * @param id 主题明细主键id
     * @return 影响行数
     */
    int falseDelete(int id);

    /**
     * 根据主题明细主键id恢复主题明细信息
     * @param id 主题明细主键id
     * @return 影响行数
     */
    int recovery(int id);

    /**
     * 根据主键id查询模块功能开关状态
     * @param id 主键id
     * @return 模块功能开关状态
     */
    SysFunctionSwitch findSwitchById(Integer id);

    /**
     * 根据主键id修改模块功能开关状态
     * @param sysFunctionSwitch 模块功能开关model
     * @return 影响行数
     */
    int updateSwitchById(SysFunctionSwitch sysFunctionSwitch);

    /**
     * 根据主题明细主键id查询评论列表
     * @param themeId 主题明细主键id
     * @return 评论列表
     */
    List<VoGambitThemeComment> findCommentByThemeId(Integer themeId);

    /**
     * 根据主题评论主键id删除主题评论
     * @param commentId 主题评论主键id
     * @return 影响行数
     */
    int deleteCommentByCommentId(Integer commentId);
}
