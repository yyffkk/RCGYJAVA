package com.api.model.app;

/**
 * app装修管理搜索条件
 */
public class SearchAppDecoration {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 当前房屋的主键id
     */
    private Integer estateId;

    @Override
    public String toString() {
        return "SearchAppDecoration{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", estateId=" + estateId +
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

    public SearchAppDecoration() {
    }

    public SearchAppDecoration(int pageNum, int size, Integer estateId) {
        this.pageNum = pageNum;
        this.size = size;
        this.estateId = estateId;
    }
}
