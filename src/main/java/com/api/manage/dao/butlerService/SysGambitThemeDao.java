package com.api.manage.dao.butlerService;

import com.api.model.butlerService.SearchGambitTheme;
import com.api.vo.butlerService.VoGambitTheme;

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
}
