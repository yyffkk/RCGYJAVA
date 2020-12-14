package com.api.service.butlerService;

import com.api.model.butlerService.SearchGambitTheme;
import com.api.vo.butlerService.VoGambitTheme;

import java.util.List;

public interface SysGambitThemeService {
    List<VoGambitTheme> list(SearchGambitTheme searchGambitTheme);
}
