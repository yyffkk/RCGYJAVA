package com.api.model.butlerApp;

/**
 * 管家app 新版装修搜索条件
 */
public class ButlerUserDecorationNewSearch {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 装修状态（5.申请完工检查，6.检查通过，7.检查不通过）
     */
    private Integer status;


    @Override
    public String toString() {
        return "ButlerUserDecorationNewSearch{" +
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

    public ButlerUserDecorationNewSearch() {
    }

    public ButlerUserDecorationNewSearch(int pageNum, int size, Integer status) {
        this.pageNum = pageNum;
        this.size = size;
        this.status = status;
    }
}
