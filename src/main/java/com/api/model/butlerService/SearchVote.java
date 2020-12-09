package com.api.model.butlerService;

import java.util.Date;

/**
 * 投票搜索条件
 */
public class SearchVote {
    /**
     * 当前页数
     */
    private Integer pageNum;
    /**
     * 每页记录数
     */
    private Integer size;
    /**
     * 标题
     */
    private String title;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 投票开始时间
     */
    private Date beginDate;
    /**
     * 投票结束时间
     */
    private Date endDate;

    @Override
    public String toString() {
        return "SearchVote{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", title='" + title + '\'' +
                ", status=" + status +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
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

    public SearchVote() {
    }

    public SearchVote(Integer pageNum, Integer size, String title, Integer status, Date beginDate, Date endDate) {
        this.pageNum = pageNum;
        this.size = size;
        this.title = title;
        this.status = status;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

}
