package com.api.model.chargeManagement;

/**
 * 抄表记录搜索条件
 */
public class SearchMeterReadingRecord {
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
        return "SearchMeterReadingRecord{" +
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

    public SearchMeterReadingRecord() {
    }

    public SearchMeterReadingRecord(int pageNum, int size) {
        this.pageNum = pageNum;
        this.size = size;
    }
}
