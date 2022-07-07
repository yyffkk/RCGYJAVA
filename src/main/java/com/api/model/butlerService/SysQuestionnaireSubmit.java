package com.api.model.butlerService;

import java.util.List;

/**
 * 问卷调查提交
 */
public class SysQuestionnaireSubmit {
    /**
     * 问卷调查主键id
     */
    private Integer id;
    /**
     * 问卷调查提交答案集合
     */
    private List<SysQuestionnaireAnswerSubmit> sysQuestionnaireTopicSubmitList;

    @Override
    public String toString() {
        return "SysQuestionnaireSubmit{" +
                "id=" + id +
                ", sysQuestionnaireTopicSubmitList=" + sysQuestionnaireTopicSubmitList +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<SysQuestionnaireAnswerSubmit> getSysQuestionnaireTopicSubmitList() {
        return sysQuestionnaireTopicSubmitList;
    }

    public void setSysQuestionnaireTopicSubmitList(List<SysQuestionnaireAnswerSubmit> sysQuestionnaireTopicSubmitList) {
        this.sysQuestionnaireTopicSubmitList = sysQuestionnaireTopicSubmitList;
    }

    public SysQuestionnaireSubmit() {
    }

    public SysQuestionnaireSubmit(Integer id, List<SysQuestionnaireAnswerSubmit> sysQuestionnaireTopicSubmitList) {
        this.id = id;
        this.sysQuestionnaireTopicSubmitList = sysQuestionnaireTopicSubmitList;
    }
}
