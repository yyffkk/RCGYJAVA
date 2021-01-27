package com.api.model.butlerService;

import java.util.Date;

/**
 * 问卷调查搜索条件
 */
public class SearchQuestionnaire {
    /**
     * 当前页数
     */
    private Integer pageNum;
    /**
     * 每页记录数
     */
    private Integer size;
    /**
     * 问卷标题
     */
    private String title;
    /**
     * 状态(1.未开始，2.正在进行，3.已结束)
     */
    private Integer status;
    /**
     * 当前时间（用于判断状态）
     */
    private Date nowDate;
    /**
     * 问卷对象（答题人员类型）【1.无限制，2.业主，3.租户】
     */
    private Integer answerType;

    @Override
    public String toString() {
        return "SearchQuestionnaire{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", title='" + title + '\'' +
                ", status=" + status +
                ", nowDate=" + nowDate +
                ", answerType=" + answerType +
                '}';
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getNowDate() {
        return nowDate;
    }

    public void setNowDate(Date nowDate) {
        this.nowDate = nowDate;
    }

    public Integer getAnswerType() {
        return answerType;
    }

    public void setAnswerType(Integer answerType) {
        this.answerType = answerType;
    }

    public SearchQuestionnaire() {
    }

    public SearchQuestionnaire(Integer pageNum, Integer size, String title, Integer status, Date nowDate, Integer answerType) {
        this.pageNum = pageNum;
        this.size = size;
        this.title = title;
        this.status = status;
        this.nowDate = nowDate;
        this.answerType = answerType;
    }
}
