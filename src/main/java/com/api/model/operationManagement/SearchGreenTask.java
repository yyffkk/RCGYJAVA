package com.api.model.operationManagement;

import java.util.Date;

/**
 * 绿化任务搜索条件
 */
public class SearchGreenTask {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 绿化区域名称
     */
    private String greenAreaName;
    /**
     * 工作内容
     */
    private String content;
    /**
     * 负责人名称
     */
    private String directorName;
    /**
     * 状态 1.待处理，2.已完成
     */
    private Integer status;
    /**
     * 截止时间开始
     */
    private Date endDateStart;
    /**
     * 截止时间结束
     */
    private Date endDateEnd;
    /**
     * 发布时间开始
     */
    private Date createDateStart;
    /**
     * 发布时间结束
     */
    private Date createDateEnd;

    @Override
    public String toString() {
        return "SearchGreenTask{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", greenAreaName='" + greenAreaName + '\'' +
                ", content='" + content + '\'' +
                ", directorName='" + directorName + '\'' +
                ", status=" + status +
                ", endDateStart=" + endDateStart +
                ", endDateEnd=" + endDateEnd +
                ", createDateStart=" + createDateStart +
                ", createDateEnd=" + createDateEnd +
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

    public String getGreenAreaName() {
        return greenAreaName;
    }

    public void setGreenAreaName(String greenAreaName) {
        this.greenAreaName = greenAreaName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getEndDateStart() {
        return endDateStart;
    }

    public void setEndDateStart(Date endDateStart) {
        this.endDateStart = endDateStart;
    }

    public Date getEndDateEnd() {
        return endDateEnd;
    }

    public void setEndDateEnd(Date endDateEnd) {
        this.endDateEnd = endDateEnd;
    }

    public Date getCreateDateStart() {
        return createDateStart;
    }

    public void setCreateDateStart(Date createDateStart) {
        this.createDateStart = createDateStart;
    }

    public Date getCreateDateEnd() {
        return createDateEnd;
    }

    public void setCreateDateEnd(Date createDateEnd) {
        this.createDateEnd = createDateEnd;
    }

    public SearchGreenTask() {
    }

    public SearchGreenTask(int pageNum, int size, String greenAreaName, String content, String directorName, Integer status, Date endDateStart, Date endDateEnd, Date createDateStart, Date createDateEnd) {
        this.pageNum = pageNum;
        this.size = size;
        this.greenAreaName = greenAreaName;
        this.content = content;
        this.directorName = directorName;
        this.status = status;
        this.endDateStart = endDateStart;
        this.endDateEnd = endDateEnd;
        this.createDateStart = createDateStart;
        this.createDateEnd = createDateEnd;
    }
}
