package com.api.model.butlerApp;

/**
 * 管家app 报事报修-工程维修 搜索条件
 */
public class ButlerRepairEngineeringSearch {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 报事报修工程维修状态
     */
    private Integer repairEngineeringStatus;

    @Override
    public String toString() {
        return "ButlerRepairEngineeringSearch{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", repairEngineeringStatus=" + repairEngineeringStatus +
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

    public Integer getRepairEngineeringStatus() {
        return repairEngineeringStatus;
    }

    public void setRepairEngineeringStatus(Integer repairEngineeringStatus) {
        this.repairEngineeringStatus = repairEngineeringStatus;
    }

    public ButlerRepairEngineeringSearch() {
    }

    public ButlerRepairEngineeringSearch(int pageNum, int size, Integer repairEngineeringStatus) {
        this.pageNum = pageNum;
        this.size = size;
        this.repairEngineeringStatus = repairEngineeringStatus;
    }
}
