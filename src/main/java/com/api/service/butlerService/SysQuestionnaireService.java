package com.api.service.butlerService;

import com.api.model.butlerService.SearchQuestionnaire;
import com.api.model.butlerService.SearchShortAnswer;
import com.api.model.butlerService.SysQuestionnaire;
import com.api.model.butlerService.SysQuestionnaireSubmit;
import com.api.vo.butlerService.VoQuestionnaire;
import com.api.vo.butlerService.VoReportQuestionnaireShort;

import java.util.List;
import java.util.Map;

public interface SysQuestionnaireService {
    List<VoQuestionnaire> list(SearchQuestionnaire searchQuestionnaire);

    Map<String, Object> insert(SysQuestionnaire sysQuestionnaire);

    Map<String, Object> findById(Integer id);

    Map<String, Object> update(SysQuestionnaire sysQuestionnaire);

    Map<String, Object> delete(int[] ids);

    Map<String, Object> falseDelete(int[] ids);

    Map<String, Object> sysQuestionnaireSubmit(SysQuestionnaireSubmit sysQuestionnaireSubmit);

    Map<String, Object> reportAnalysis(Integer id);

    List<VoReportQuestionnaireShort> listShortAnswer(SearchShortAnswer searchShortAnswer);
}
