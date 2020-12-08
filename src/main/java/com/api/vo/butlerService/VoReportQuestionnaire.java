package com.api.vo.butlerService;

import java.util.Date;
import java.util.List;

/**
 * 问卷调查报表
 */
public class VoReportQuestionnaire {
    /**
     * 问卷调查主键id
     */
    private Integer id;
    /**
     * 问卷总人数
     */
    private Integer answerNum;
    /**
     * 问卷开始时间
     */
    private Date beginDate;
    /**
     * 问卷结束时间
     */
    private Date endDate;
    /**
     * 题目报表集合
     */
    private List<VoReportQuestionnaireTopic> reportQuestionnaireTopicList;

    @Override
    public String toString() {
        return "ReportQuestionnaire{" +
                "id=" + id +
                ", answerNum=" + answerNum +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", reportQuestionnaireTopicList=" + reportQuestionnaireTopicList +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAnswerNum() {
        return answerNum;
    }

    public void setAnswerNum(Integer answerNum) {
        this.answerNum = answerNum;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<VoReportQuestionnaireTopic> getReportQuestionnaireTopicList() {
        return reportQuestionnaireTopicList;
    }

    public void setReportQuestionnaireTopicList(List<VoReportQuestionnaireTopic> reportQuestionnaireTopicList) {
        this.reportQuestionnaireTopicList = reportQuestionnaireTopicList;
    }

    public VoReportQuestionnaire() {
    }

    public VoReportQuestionnaire(Integer id, Integer answerNum, Date beginDate, Date endDate, List<VoReportQuestionnaireTopic> reportQuestionnaireTopicList) {
        this.id = id;
        this.answerNum = answerNum;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.reportQuestionnaireTopicList = reportQuestionnaireTopicList;
    }
}
