package com.api.app.service.butler;

import com.api.model.app.AppQuestionnaireSubmit;
import com.api.vo.app.AppQuestionnaireVo;

import java.util.List;
import java.util.Map;

public interface AppQuestionnaireService {
    List<AppQuestionnaireVo> list(Integer id, Integer type);

    Map<String, Object> findById(Integer questionnaireId);

    Map<String, Object> submit(AppQuestionnaireSubmit appQuestionnaireSubmit, Integer id);
}
