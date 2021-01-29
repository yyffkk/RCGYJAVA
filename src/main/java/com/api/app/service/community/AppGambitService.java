package com.api.app.service.community;

import com.api.vo.app.AppGambitThemeVo;
import com.api.vo.app.AppGambitVo;

import java.util.List;

public interface AppGambitService {
    List<AppGambitThemeVo> list(Integer id);

    List<AppGambitVo> listGambit();

}
