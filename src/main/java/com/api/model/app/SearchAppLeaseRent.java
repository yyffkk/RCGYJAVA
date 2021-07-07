package com.api.model.app;

/**
 * app 租赁租金账单 搜索条件
 */
public class SearchAppLeaseRent {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 年份
     */
    private int years;
    /**
     * 租赁主键id
     */
    private Integer sysLeaseId;

    @Override
    public String toString() {
        return "SearchAppLeaseRent{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", years=" + years +
                ", sysLeaseId=" + sysLeaseId +
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

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public Integer getSysLeaseId() {
        return sysLeaseId;
    }

    public void setSysLeaseId(Integer sysLeaseId) {
        this.sysLeaseId = sysLeaseId;
    }

    public SearchAppLeaseRent() {
    }

    public SearchAppLeaseRent(int pageNum, int size, int years, Integer sysLeaseId) {
        this.pageNum = pageNum;
        this.size = size;
        this.years = years;
        this.sysLeaseId = sysLeaseId;
    }
}
