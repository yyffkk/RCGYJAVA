package com.api.model.operationManagement;

import java.util.Date;

/**
 * 活动管理搜索条件
 */
public class SearchActivityManagement {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 活动标题
     */
    private String title;
    /**
     * 活动开始时间 开始
     */
    private Date activityStartTimeStart;
    /**
     * 活动开始时间 结束
     */
    private Date activityStartTimeEnd;
    /**
     * 活动状态
     */
    private Integer status;

    @Override
    public String toString() {
        return "SearchActivityManagement{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", title='" + title + '\'' +
                ", activityStartTimeStart=" + activityStartTimeStart +
                ", activityStartTimeEnd=" + activityStartTimeEnd +
                ", status=" + status +
                '}';
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getActivityStartTimeStart() {
        return activityStartTimeStart;
    }

    public void setActivityStartTimeStart(Date activityStartTimeStart) {
        this.activityStartTimeStart = activityStartTimeStart;
    }

    public Date getActivityStartTimeEnd() {
        return activityStartTimeEnd;
    }

    public void setActivityStartTimeEnd(Date activityStartTimeEnd) {
        this.activityStartTimeEnd = activityStartTimeEnd;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public SearchActivityManagement() {
    }

    public SearchActivityManagement(int pageNum, int size, String title, Date activityStartTimeStart, Date activityStartTimeEnd, Integer status) {
        this.pageNum = pageNum;
        this.size = size;
        this.title = title;
        this.activityStartTimeStart = activityStartTimeStart;
        this.activityStartTimeEnd = activityStartTimeEnd;
        this.status = status;
    }
}
