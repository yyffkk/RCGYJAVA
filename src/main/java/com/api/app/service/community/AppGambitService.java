package com.api.app.service.community;

import com.api.vo.app.AppGambitThemeVo;
import com.api.vo.app.AppGambitVo;
import com.api.vo.app.AppMyTidingsVo;

import java.util.List;
import java.util.Map;

public interface AppGambitService {
    List<AppGambitThemeVo> list(Integer id);

    List<AppGambitVo> listGambit();

    List<AppMyTidingsVo> myTidings(Integer id);

    Map<String, Object> GambitThemeDetail(Integer themeId);
}
