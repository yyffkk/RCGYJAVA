package com.api.model.businessManagement;

/**
 * 岗位变动 搜素条件
 */
public class SearchStationChange {
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
    private Integer userId;

    @Override
    public String toString() {
        return "SearchStationChange{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", userId=" + userId +
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public SearchStationChange() {
    }

    public SearchStationChange(int pageNum, int size, Integer userId) {
        this.pageNum = pageNum;
        this.size = size;
        this.userId = userId;
    }
}
