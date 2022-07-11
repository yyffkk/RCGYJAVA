package com.api.model.chargeManagement;

/**
 * 公摊账单搜索条件
 */
public class SearchShareBill {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;

    @Override
    public String toString() {
        return "SearchShareBill{" +
                "pageNum=" + pageNum +
                ", size=" + size +
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

    public SearchShareBill() {
    }

    public SearchShareBill(int pageNum, int size) {
        this.pageNum = pageNum;
        this.size = size;
    }
}
