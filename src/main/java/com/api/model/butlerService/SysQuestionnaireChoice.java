package com.api.model.butlerService;

import java.util.Date;

/**
 * 选择题选项信息
 */
public class SysQuestionnaireChoice {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 选项（A,B,C,D）
     */
    private String options;
    /**
     * 选项对应答案
     */
    private String answer;
    /**
     * 问卷id
     */
    private Integer questionnaireId;
    /**
     * 题目id
     */
    private Integer questionnaireTopicId;
    /**
     * 创建人
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 修改人（物业表）
     */
    private Integer modifyId;
    /**
     * 修改时间
     */
    private Date modifyDate;

    @Override
    public String toString() {
        return "SysQuestionnaireChoice{" +
                "id=" + id +
                ", options='" + options + '\'' +
                ", answer='" + answer + '\'' +
                ", questionnaireId=" + questionnaireId +
                ", questionnaireTopicId=" + questionnaireTopicId +
                ", createId=" + createId +
                ", createDate=" + createDate +
                ", modifyId=" + modifyId +
                ", modifyDate=" + modifyDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
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

    public Integer getModifyId() {
        return modifyId;
    }

    public void setModifyId(Integer modifyId) {
        this.modifyId = modifyId;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public SysQuestionnaireChoice() {
    }

    public SysQuestionnaireChoice(Integer id, String options, String answer, Integer questionnaireId, Integer questionnaireTopicId, Integer createId, Date createDate, Integer modifyId, Date modifyDate) {
        this.id = id;
        this.options = options;
        this.answer = answer;
        this.questionnaireId = questionnaireId;
        this.questionnaireTopicId = questionnaireTopicId;
        this.createId = createId;
        this.createDate = createDate;
        this.modifyId = modifyId;
        this.modifyDate = modifyDate;
    }
}
