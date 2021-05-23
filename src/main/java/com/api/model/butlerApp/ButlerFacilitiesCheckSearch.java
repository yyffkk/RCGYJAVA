package com.api.model.butlerApp;

/**
 * 管家app 设施设备检查搜索条件
 */
public class ButlerFacilitiesCheckSearch {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 用户主键id
     */
    private Integer id;
    /**
     * 类型：1.设施，2.设备
     */
    private Integer facilitiesType;
    /**
     * 检查记录状态
     */
    private Integer executeStatus;

    @Override
    public String toString() {
        return "ButlerFacilitiesCheckSearch{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", id=" + id +
                ", facilitiesType=" + facilitiesType +
                ", executeStatus=" + executeStatus +
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFacilitiesType() {
        return facilitiesType;
    }

    public void setFacilitiesType(Integer facilitiesType) {
        this.facilitiesType = facilitiesType;
    }

    public Integer getExecuteStatus() {
        return executeStatus;
    }

    public void setExecuteStatus(Integer executeStatus) {
        this.executeStatus = executeStatus;
    }

    public ButlerFacilitiesCheckSearch() {
    }

    public ButlerFacilitiesCheckSearch(int pageNum, int size, Integer id, Integer facilitiesType, Integer executeStatus) {
        this.pageNum = pageNum;
        this.size = size;
        this.id = id;
        this.facilitiesType = facilitiesType;
        this.executeStatus = executeStatus;
    }
}
