package com.aku.service.butlerService;

import com.aku.model.butlerService.SearchQuestionnaire;
import com.aku.model.butlerService.SysQuestionnaire;
import com.aku.vo.butlerService.VoQuestionnaire;

import java.util.List;
import java.util.Map;

public interface SysQuestionnaireService {
    List<VoQuestionnaire> list(SearchQuestionnaire searchQuestionnaire);

    Map<String, Object> insert(SysQuestionnaire sysQuestionnaire);

    Map<String, Object> findById(Integer id);
}
