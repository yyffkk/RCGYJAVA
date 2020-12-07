package com.aku.model.butlerService;

import java.util.Date;
import java.util.List;

/**
 * 题目表信息
 */
public class SysQuestionnaireTopic {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 答题类型（1.单选，2.多选，3.下拉单选，4.判断题，5.开放题）
     */
    private Integer type;
    /**
     * 题目
     */
    private String topic;
    /**
     * 选择题选项信息集合（仅选择题需要填写）
     */
    private List<SysQuestionnaireChoice> sysQuestionnaireChoiceList;
    /**
     * 问卷id
     */
    private Integer questionnaireId;
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
        return "SysQuestionnaireTopic{" +
                "id=" + id +
                ", type=" + type +
                ", topic='" + topic + '\'' +
                ", sysQuestionnaireChoiceList=" + sysQuestionnaireChoiceList +
                ", questionnaireId=" + questionnaireId +
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public List<SysQuestionnaireChoice> getSysQuestionnaireChoiceList() {
        return sysQuestionnaireChoiceList;
    }

    public void setSysQuestionnaireChoiceList(List<SysQuestionnaireChoice> sysQuestionnaireChoiceList) {
        this.sysQuestionnaireChoiceList = sysQuestionnaireChoiceList;
    }

    public Integer getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(Integer questionnaireId) {
        this.questionnaireId = questionnaireId;
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

    public SysQuestionnaireTopic() {
    }

    public SysQuestionnaireTopic(Integer id, Integer type, String topic, List<SysQuestionnaireChoice> sysQuestionnaireChoiceList, Integer questionnaireId, Integer createId, Date createDate, Integer modifyId, Date modifyDate) {
        this.id = id;
        this.type = type;
        this.topic = topic;
        this.sysQuestionnaireChoiceList = sysQuestionnaireChoiceList;
        this.questionnaireId = questionnaireId;
        this.createId = createId;
        this.createDate = createDate;
        this.modifyId = modifyId;
        this.modifyDate = modifyDate;
    }
}
