package com.api.model.butlerApp;

import java.util.Date;

/**
 * 管家app访客管理 搜索条件
 */
public class ButlerVisitorSearch {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 访客状态
     */
    private Integer visitorStatus;
    /**
     * 当前时间
     */
    private Date nowDate;

    @Override
    public String toString() {
        return "ButlerVisitorSearch{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", visitorStatus=" + visitorStatus +
                ", nowDate=" + nowDate +
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

    public Integer getVisitorStatus() {
        return visitorStatus;
    }

    public void setVisitorStatus(Integer visitorStatus) {
        this.visitorStatus = visitorStatus;
    }

    public Date getNowDate() {
        return nowDate;
    }

    public void setNowDate(Date nowDate) {
        this.nowDate = nowDate;
    }

    public ButlerVisitorSearch() {
    }

    public ButlerVisitorSearch(int pageNum, int size, Integer visitorStatus, Date nowDate) {
        this.pageNum = pageNum;
        this.size = size;
        this.visitorStatus = visitorStatus;
        this.nowDate = nowDate;
    }
}
