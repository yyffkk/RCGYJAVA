package com.api.model.operationManagement;

import java.util.Date;

/**
 * 规程管理搜索条件
 */
public class SearchRegulationManagement {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 规程标题
     */
    private String title;
    /**
     * 发布状态 ，1.已发布 2.未发布
     */
    private Integer status;
    /**
     * 创建人
     */
    private String createName;
    /**
     * 最近修改时间开始
     */
    private Date nearModifyDateStart;
    /**
     * 最近修改时间结束
     */
    private Date nearModifyDateEnd;
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
        return "SearchRegulationManagement{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", title='" + title + '\'' +
                ", status=" + status +
                ", createName='" + createName + '\'' +
                ", nearModifyDateStart=" + nearModifyDateStart +
                ", nearModifyDateEnd=" + nearModifyDateEnd +
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

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Date getNearModifyDateStart() {
        return nearModifyDateStart;
    }

    public void setNearModifyDateStart(Date nearModifyDateStart) {
        this.nearModifyDateStart = nearModifyDateStart;
    }

    public Date getNearModifyDateEnd() {
        return nearModifyDateEnd;
    }

    public void setNearModifyDateEnd(Date nearModifyDateEnd) {
        this.nearModifyDateEnd = nearModifyDateEnd;
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

    public SearchRegulationManagement() {
    }

    public SearchRegulationManagement(int pageNum, int size, String title, Integer status, String createName, Date nearModifyDateStart, Date nearModifyDateEnd, Date createDateStart, Date createDateEnd) {
        this.pageNum = pageNum;
        this.size = size;
        this.title = title;
        this.status = status;
        this.createName = createName;
        this.nearModifyDateStart = nearModifyDateStart;
        this.nearModifyDateEnd = nearModifyDateEnd;
        this.createDateStart = createDateStart;
        this.createDateEnd = createDateEnd;
    }
}
