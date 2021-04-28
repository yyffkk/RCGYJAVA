package com.api.model.app;

/**
 * app 设施预约 搜索条件
 */
public class SearchAppFacilitiesAppointment {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 设施预约类别（1.我的预约，2.历史预约）
     */
    private Integer facilitiesType;

    @Override
    public String toString() {
        return "SearchAppFacilitiesAppointment{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", facilitiesType=" + facilitiesType +
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

    public Integer getFacilitiesType() {
        return facilitiesType;
    }

    public void setFacilitiesType(Integer facilitiesType) {
        this.facilitiesType = facilitiesType;
    }

    public SearchAppFacilitiesAppointment() {
    }

    public SearchAppFacilitiesAppointment(int pageNum, int size, Integer facilitiesType) {
        this.pageNum = pageNum;
        this.size = size;
        this.facilitiesType = facilitiesType;
    }
}
