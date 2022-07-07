package com.api.model.app;

import com.api.model.butlerService.SysQuestionnaireAnswerSubmit;

import java.util.List;

/**
 * app问卷调查提交信息
 */
public class AppQuestionnaireSubmit {
    /**
     * 问卷调查主键id
     */
    private Integer id;
    /**
     * 问卷调查提交答案集合
     */
    private List<AppQuestionnaireAnswerSubmit> appQuestionnaireAnswerSubmits;

    @Override
    public String toString() {
        return "AppQuestionnaireSubmit{" +
                "id=" + id +
                ", appQuestionnaireAnswerSubmits=" + appQuestionnaireAnswerSubmits +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<AppQuestionnaireAnswerSubmit> getAppQuestionnaireAnswerSubmits() {
        return appQuestionnaireAnswerSubmits;
    }

    public void setAppQuestionnaireAnswerSubmits(List<AppQuestionnaireAnswerSubmit> appQuestionnaireAnswerSubmits) {
        this.appQuestionnaireAnswerSubmits = appQuestionnaireAnswerSubmits;
    }

    public AppQuestionnaireSubmit() {
    }

    public AppQuestionnaireSubmit(Integer id, List<AppQuestionnaireAnswerSubmit> appQuestionnaireAnswerSubmits) {
        this.id = id;
        this.appQuestionnaireAnswerSubmits = appQuestionnaireAnswerSubmits;
    }
}
