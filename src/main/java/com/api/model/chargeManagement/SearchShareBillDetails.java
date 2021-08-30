package com.api.model.chargeManagement;

/**
 * 公摊账单明细搜索条件
 */
public class SearchShareBillDetails {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 公摊账单主键id
     */
    private Integer shareBillId;

    @Override
    public String toString() {
        return "SearchShareBillDetails{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", shareBillId=" + shareBillId +
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

    public Integer getShareBillId() {
        return shareBillId;
    }

    public void setShareBillId(Integer shareBillId) {
        this.shareBillId = shareBillId;
    }

    public SearchShareBillDetails() {
    }

    public SearchShareBillDetails(int pageNum, int size, Integer shareBillId) {
        this.pageNum = pageNum;
        this.size = size;
        this.shareBillId = shareBillId;
    }
}
