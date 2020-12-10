package com.api.model.butlerService;

/**
 * 开放题搜索条件
 */
public class SearchShortAnswer {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 题目主键id
     */
    private Integer id;

    @Override
    public String toString() {
        return "SearchShortAnswer{" +
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

    public SearchShortAnswer() {
    }

    public SearchShortAnswer(int pageNum, int size, Integer id) {
        this.pageNum = pageNum;
        this.size = size;
        this.id = id;
    }
}
