package com.api.dao.butlerService;

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
}
