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
     * 状态
     */
    private Integer status;

    @Override
    public String toString() {
        return "ButlerRepairEngineeringSearch{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", status=" + status +
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public ButlerRepairEngineeringSearch() {
    }

    public ButlerRepairEngineeringSearch(int pageNum, int size, Integer status) {
        this.pageNum = pageNum;
        this.size = size;
        this.status = status;
    }
}
