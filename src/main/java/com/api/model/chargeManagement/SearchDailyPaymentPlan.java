package com.api.model.chargeManagement;

/**
 * 缴费计划搜索条件
 */
public class SearchDailyPaymentPlan {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 房产id
     */
    private Integer buildingUnitEstateId;

    @Override
    public String toString() {
        return "SearchDailyPaymentPlan{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", buildingUnitEstateId=" + buildingUnitEstateId +
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

    public Integer getBuildingUnitEstateId() {
        return buildingUnitEstateId;
    }

    public void setBuildingUnitEstateId(Integer buildingUnitEstateId) {
        this.buildingUnitEstateId = buildingUnitEstateId;
    }

    public SearchDailyPaymentPlan() {
    }

    public SearchDailyPaymentPlan(int pageNum, int size, Integer buildingUnitEstateId) {
        this.pageNum = pageNum;
        this.size = size;
        this.buildingUnitEstateId = buildingUnitEstateId;
    }
}
