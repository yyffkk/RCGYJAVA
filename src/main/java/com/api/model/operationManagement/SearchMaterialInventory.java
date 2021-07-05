package com.api.model.operationManagement;

/**
 * 物资盘点搜索条件
 */
public class SearchMaterialInventory {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 盘点期次
     */
    private String periodTime;

    @Override
    public String toString() {
        return "SearchMaterialInventory{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", periodTime='" + periodTime + '\'' +
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

    public String getPeriodTime() {
        return periodTime;
    }

    public void setPeriodTime(String periodTime) {
        this.periodTime = periodTime;
    }

    public SearchMaterialInventory() {
    }

    public SearchMaterialInventory(int pageNum, int size, String periodTime) {
        this.pageNum = pageNum;
        this.size = size;
        this.periodTime = periodTime;
    }
}
