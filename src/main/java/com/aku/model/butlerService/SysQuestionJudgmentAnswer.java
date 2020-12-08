package com.aku.model.butlerService;

import java.util.Date;

/**
 * 判断题答案
 */
public class SysQuestionJudgmentAnswer {
    /**
     * 问卷id
     */
    private Integer questionnaireId;
    /**
     * 题目id
     */
    private Integer questionnaireTopicId;
    /**
     * 答案（1.对，0.错）
     */
    private Integer answer;
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
        return "SysQuestionJudgmentAnswer{" +
                "questionnaireId=" + questionnaireId +
                ", questionnaireTopicId=" + questionnaireTopicId +
                ", answer=" + answer +
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

    public Integer getAnswer() {
        return answer;
    }

    public void setAnswer(Integer answer) {
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

    public SysQuestionJudgmentAnswer() {
    }

    public SysQuestionJudgmentAnswer(Integer questionnaireId, Integer questionnaireTopicId, Integer answer, Integer createId, Date createDate) {
        this.questionnaireId = questionnaireId;
        this.questionnaireTopicId = questionnaireTopicId;
        this.answer = answer;
        this.createId = createId;
        this.createDate = createDate;
    }
}
