package com.api.manage.service.butlerService;

import com.api.model.butlerService.SearchGambitTheme;
import com.api.vo.butlerService.VoGambitTheme;

import java.util.List;
import java.util.Map;

public interface SysGambitThemeService {
    List<VoGambitTheme> list(SearchGambitTheme searchGambitTheme);

    Map<String, Object> falseDelete(int[] ids);

    Map<String, Object> recovery(int[] ids);

    Map<String, Object> enableTheme();

    Map<String, Object> enableComment();

    Map<String, Object> findCommentByThemeId(Integer themeId);

    Map<String, Object> deleteCommentByCommentId(Integer commentId);
}
