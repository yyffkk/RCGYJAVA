package com.api.model.chargeManagement;

/**
 * 预缴详情 搜索条件
 */
public class SearchAdvancePaymentDetail {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 房产主键id
     */
    private Integer estateId;
    /**
     * 年份
     */
    private Integer years;
    /**
     * 月份
     */
    private Integer months;

    @Override
    public String toString() {
        return "SearchAdvancePaymentDetail{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", estateId=" + estateId +
                ", years=" + years +
                ", months=" + months +
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

    public Integer getEstateId() {
        return estateId;
    }

    public void setEstateId(Integer estateId) {
        this.estateId = estateId;
    }

    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }

    public Integer getMonths() {
        return months;
    }

    public void setMonths(Integer months) {
        this.months = months;
    }

    public SearchAdvancePaymentDetail() {
    }

    public SearchAdvancePaymentDetail(int pageNum, int size, Integer estateId, Integer years, Integer months) {
        this.pageNum = pageNum;
        this.size = size;
        this.estateId = estateId;
        this.years = years;
        this.months = months;
    }
}
