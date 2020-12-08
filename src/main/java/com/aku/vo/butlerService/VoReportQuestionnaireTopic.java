package com.aku.vo.butlerService;

import java.util.List;

/**
 * 问卷调查报表--题目
 */
public class VoReportQuestionnaireTopic {
    /**
     * 题目id
     */
    private Integer id;
    /**
     * 题目类型
     */
    private Integer type;
    /**
     * 题目内容
     */
    private String topic;
    /**
     * 答题总人数（此题目）
     */
    private Integer answerNum;
    /**
     * 选择项集合（当type为1，2，3 选择题时有效）
     */
    private List<VoReportQuestionnaireChoice> reportQuestionnaireChoiceList;
    /**
     * 选【对】的数量（当type为4 判断题时有效）
     */
    private Integer trueNum;
    /**
     * 选【错】的数量（当type为4 判断题时有效）
     */
    private Integer falseNum;

    @Override
    public String toString() {
        return "VoReportQuestionnaireTopic{" +
                "id=" + id +
                ", type=" + type +
                ", topic='" + topic + '\'' +
                ", answerNum=" + answerNum +
                ", reportQuestionnaireChoiceList=" + reportQuestionnaireChoiceList +
                ", trueNum=" + trueNum +
                ", falseNum=" + falseNum +
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

    public Integer getAnswerNum() {
        return answerNum;
    }

    public void setAnswerNum(Integer answerNum) {
        this.answerNum = answerNum;
    }

    public List<VoReportQuestionnaireChoice> getReportQuestionnaireChoiceList() {
        return reportQuestionnaireChoiceList;
    }

    public void setReportQuestionnaireChoiceList(List<VoReportQuestionnaireChoice> reportQuestionnaireChoiceList) {
        this.reportQuestionnaireChoiceList = reportQuestionnaireChoiceList;
    }

    public Integer getTrueNum() {
        return trueNum;
    }

    public void setTrueNum(Integer trueNum) {
        this.trueNum = trueNum;
    }

    public Integer getFalseNum() {
        return falseNum;
    }

    public void setFalseNum(Integer falseNum) {
        this.falseNum = falseNum;
    }

    public VoReportQuestionnaireTopic() {
    }

    public VoReportQuestionnaireTopic(Integer id, Integer type, String topic, Integer answerNum, List<VoReportQuestionnaireChoice> reportQuestionnaireChoiceList, Integer trueNum, Integer falseNum) {
        this.id = id;
        this.type = type;
        this.topic = topic;
        this.answerNum = answerNum;
        this.reportQuestionnaireChoiceList = reportQuestionnaireChoiceList;
        this.trueNum = trueNum;
        this.falseNum = falseNum;
    }
}
