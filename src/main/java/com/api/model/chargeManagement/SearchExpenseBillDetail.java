package com.api.model.chargeManagement;

/**
 * 费用账单详情搜索条件
 */
public class SearchExpenseBillDetail {
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
    /**
     * 缴纳人名称
     */
    private String payPeopleName;
    /**
     * 费用类型
     */
    private Integer chargesTemplateDetailId;

    @Override
    public String toString() {
        return "SearchExpenseBillDetail{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", estateId=" + estateId +
                ", years=" + years +
                ", months=" + months +
                ", payPeopleName='" + payPeopleName + '\'' +
                ", chargesTemplateDetailId=" + chargesTemplateDetailId +
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

    public String getPayPeopleName() {
        return payPeopleName;
    }

    public void setPayPeopleName(String payPeopleName) {
        this.payPeopleName = payPeopleName;
    }

    public Integer getChargesTemplateDetailId() {
        return chargesTemplateDetailId;
    }

    public void setChargesTemplateDetailId(Integer chargesTemplateDetailId) {
        this.chargesTemplateDetailId = chargesTemplateDetailId;
    }

    public SearchExpenseBillDetail() {
    }

    public SearchExpenseBillDetail(int pageNum, int size, Integer estateId, Integer years, Integer months, String payPeopleName, Integer chargesTemplateDetailId) {
        this.pageNum = pageNum;
        this.size = size;
        this.estateId = estateId;
        this.years = years;
        this.months = months;
        this.payPeopleName = payPeopleName;
        this.chargesTemplateDetailId = chargesTemplateDetailId;
    }
}
