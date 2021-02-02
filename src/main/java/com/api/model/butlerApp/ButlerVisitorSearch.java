package com.api.model.butlerApp;

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

    @Override
    public String toString() {
        return "ButlerVisitorSearch{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", visitorStatus=" + visitorStatus +
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

    public ButlerVisitorSearch() {
    }

    public ButlerVisitorSearch(int pageNum, int size, Integer visitorStatus) {
        this.pageNum = pageNum;
        this.size = size;
        this.visitorStatus = visitorStatus;
    }
}
