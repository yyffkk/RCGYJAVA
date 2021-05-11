package com.api.model.app;

/**
 * app 公共资讯 搜素条件
 */
public class SearchAppNews {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 资讯分类主键id(【全部】则传null)
     */
    private Integer newsCategoryId;

    @Override
    public String toString() {
        return "SearchAppNews{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", newsCategoryId=" + newsCategoryId +
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

    public Integer getNewsCategoryId() {
        return newsCategoryId;
    }

    public void setNewsCategoryId(Integer newsCategoryId) {
        this.newsCategoryId = newsCategoryId;
    }

    public SearchAppNews() {
    }

    public SearchAppNews(int pageNum, int size, Integer newsCategoryId) {
        this.pageNum = pageNum;
        this.size = size;
        this.newsCategoryId = newsCategoryId;
    }
}
