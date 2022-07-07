package com.api.model.system;

/**
 * 数据字典搜索条件
 */
public class SysDataDictionarySearch {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 备注检索
     */
    private String remarks;

    @Override
    public String toString() {
        return "SysDataDictionarySearch{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", remarks='" + remarks + '\'' +
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public SysDataDictionarySearch() {
    }

    public SysDataDictionarySearch(int pageNum, int size, String remarks) {
        this.pageNum = pageNum;
        this.size = size;
        this.remarks = remarks;
    }
}
