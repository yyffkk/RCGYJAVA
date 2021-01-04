package com.api.model.chargeManagement;

/**
 * 固定金额分摊--分摊结果 搜索条件
 */
public class SearchFixedAmountAllocationResult {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 楼栋id
     */
    private Integer buildId;
    /**
     * 单元id
     */
    private Integer unitId;
    /**
     * 房间id
     */
    private String estateId;
    /**
     * 业主姓名
     */
    private String name;

    @Override
    public String toString() {
        return "SearchFixedAmountAllocationResult{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", buildId=" + buildId +
                ", unitId=" + unitId +
                ", estateId='" + estateId + '\'' +
                ", name='" + name + '\'' +
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

    public Integer getBuildId() {
        return buildId;
    }

    public void setBuildId(Integer buildId) {
        this.buildId = buildId;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public String getEstateId() {
        return estateId;
    }

    public void setEstateId(String estateId) {
        this.estateId = estateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SearchFixedAmountAllocationResult() {
    }

    public SearchFixedAmountAllocationResult(int pageNum, int size, Integer buildId, Integer unitId, String estateId, String name) {
        this.pageNum = pageNum;
        this.size = size;
        this.buildId = buildId;
        this.unitId = unitId;
        this.estateId = estateId;
        this.name = name;
    }
}
