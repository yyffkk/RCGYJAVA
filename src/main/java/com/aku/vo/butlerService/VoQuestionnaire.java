package com.aku.vo.butlerService;

import java.util.Date;

/**
 * 问卷调查 list 回显
 */
public class VoQuestionnaire {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 问卷标题
     */
    private String title;
    /**
     * 答题人员类型（1.无限制，2.业主，3.租户）
     */
    private Integer answerType;
    /**
     * 状态（1.未开始，2.正在进行，3.已开始）
     */
    private Integer status;
    /**
     * 开始时间
     */
    private Date beginDate;
    /**
     * 结束时间
     */
    private Date endDate;
    /**
     * 答题数量
     */
    private Integer answerNum;

    @Override
    public String toString() {
        return "VoQuestionnaire{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", answerType=" + answerType +
                ", status=" + status +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", answerNum=" + answerNum +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getAnswerType() {
        return answerType;
    }

    public void setAnswerType(Integer answerType) {
        this.answerType = answerType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Integer getAnswerNum() {
        return answerNum;
    }

    public void setAnswerNum(Integer answerNum) {
        this.answerNum = answerNum;
    }

    public VoQuestionnaire() {
    }

    public VoQuestionnaire(Integer id, String title, Integer answerType, Integer status, Date beginDate, Date endDate, Integer answerNum) {
        this.id = id;
        this.title = title;
        this.answerType = answerType;
        this.status = status;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.answerNum = answerNum;
    }
}
