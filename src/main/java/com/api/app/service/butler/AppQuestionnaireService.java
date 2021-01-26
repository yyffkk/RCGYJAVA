package com.api.app.service.butler;

import com.api.vo.app.AppQuestionnaireVo;

import java.util.List;

public interface AppQuestionnaireService {
    List<AppQuestionnaireVo> list(Integer id, Integer type);
}
