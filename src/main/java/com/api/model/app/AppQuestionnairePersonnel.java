package com.api.model.app;

import java.util.Date;

/**
 * 问卷人表信息
 */
public class AppQuestionnairePersonnel {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 问卷id
     */
    private Integer questionnaireId;
    /**
     * 答卷人id
     */
    private Integer answerId;
    /**
     * 答卷时间
     */
    private Date answerDate;

    @Override
    public String toString() {
        return "AppQuestionnairePersonnel{" +
                "id=" + id +
                ", questionnaireId=" + questionnaireId +
                ", answerId=" + answerId +
                ", answerDate=" + answerDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(Integer questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    public Date getAnswerDate() {
        return answerDate;
    }

    public void setAnswerDate(Date answerDate) {
        this.answerDate = answerDate;
    }

    public AppQuestionnairePersonnel() {
    }

    public AppQuestionnairePersonnel(Integer id, Integer questionnaireId, Integer answerId, Date answerDate) {
        this.id = id;
        this.questionnaireId = questionnaireId;
        this.answerId = answerId;
        this.answerDate = answerDate;
    }
}
