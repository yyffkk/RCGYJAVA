package com.api.model.butlerApp;

/**
 * 管家app 巡检管理 搜索条件
 */
public class ButlerInspectionSearch {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 巡检状态（1.待巡检，2.已巡检）
     */
    private Integer inspectionStatus;
    /**
     * 用户主键id
     */
    private Integer id;

    @Override
    public String toString() {
        return "ButlerInspectionSearch{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", inspectionStatus=" + inspectionStatus +
                ", id=" + id +
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

    public Integer getInspectionStatus() {
        return inspectionStatus;
    }

    public void setInspectionStatus(Integer inspectionStatus) {
        this.inspectionStatus = inspectionStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ButlerInspectionSearch() {
    }

    public ButlerInspectionSearch(int pageNum, int size, Integer inspectionStatus, Integer id) {
        this.pageNum = pageNum;
        this.size = size;
        this.inspectionStatus = inspectionStatus;
        this.id = id;
    }
}
