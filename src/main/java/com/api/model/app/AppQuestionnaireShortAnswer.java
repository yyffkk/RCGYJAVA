package com.api.model.app;

import java.util.Date;

/**
 * 开放题答案
 */
public class AppQuestionnaireShortAnswer {
    /**
     * 问卷id
     */
    private Integer questionnaireId;
    /**
     * 题目id
     */
    private Integer questionnaireTopicId;
    /**
     * 答案（简答题内容）
     */
    private String answer;
    /**
     * 创建人
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "AppQuestionnaireShortAnswer{" +
                "questionnaireId=" + questionnaireId +
                ", questionnaireTopicId=" + questionnaireTopicId +
                ", answer='" + answer + '\'' +
                ", createId=" + createId +
                ", createDate=" + createDate +
                '}';
    }

    public Integer getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(Integer questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    public Integer getQuestionnaireTopicId() {
        return questionnaireTopicId;
    }

    public void setQuestionnaireTopicId(Integer questionnaireTopicId) {
        this.questionnaireTopicId = questionnaireTopicId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public AppQuestionnaireShortAnswer() {
    }

    public AppQuestionnaireShortAnswer(Integer questionnaireId, Integer questionnaireTopicId, String answer, Integer createId, Date createDate) {
        this.questionnaireId = questionnaireId;
        this.questionnaireTopicId = questionnaireTopicId;
        this.answer = answer;
        this.createId = createId;
        this.createDate = createDate;
    }
}
