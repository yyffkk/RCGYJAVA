package com.aku.model.butlerService;

import java.util.Date;

/**
 * 问卷选择答案
 */
public class SysQuestionChoiceAnswer {
    /**
     * 问卷id
     */
    private Integer questionnaireId;
    /**
     * 题目id
     */
    private Integer questionnaireTopicId;
    /**
     * 答案选项（选择题选项表id）
     */
    private Integer questionnaireMultipleChoiceId;
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
        return "SysQuestionChoiceAnswer{" +
                "questionnaireId=" + questionnaireId +
                ", questionnaireTopicId=" + questionnaireTopicId +
                ", questionnaireMultipleChoiceId=" + questionnaireMultipleChoiceId +
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

    public Integer getQuestionnaireMultipleChoiceId() {
        return questionnaireMultipleChoiceId;
    }

    public void setQuestionnaireMultipleChoiceId(Integer questionnaireMultipleChoiceId) {
        this.questionnaireMultipleChoiceId = questionnaireMultipleChoiceId;
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

    public SysQuestionChoiceAnswer() {
    }

    public SysQuestionChoiceAnswer(Integer questionnaireId, Integer questionnaireTopicId, Integer questionnaireMultipleChoiceId, Integer createId, Date createDate) {
        this.questionnaireId = questionnaireId;
        this.questionnaireTopicId = questionnaireTopicId;
        this.questionnaireMultipleChoiceId = questionnaireMultipleChoiceId;
        this.createId = createId;
        this.createDate = createDate;
    }
}
