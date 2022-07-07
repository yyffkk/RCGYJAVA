package com.api.model.butlerApp;

/**
 * 管家app 钥匙搜索条件
 */
public class ButlerKeySearch {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 用户主键Id
     */
    private Integer id;

    @Override
    public String toString() {
        return "ButlerKeySearch{" +
                "pageNum=" + pageNum +
                ", size=" + size +
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ButlerKeySearch() {
    }

    public ButlerKeySearch(int pageNum, int size, Integer id) {
        this.pageNum = pageNum;
        this.size = size;
        this.id = id;
    }
}
