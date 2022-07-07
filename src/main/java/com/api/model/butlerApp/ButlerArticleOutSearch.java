package com.api.model.butlerApp;

/**
 * 管家app 物品出门 搜索条件
 */
public class ButlerArticleOutSearch {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 物品出门状态
     */
    private Integer articleOutStatus;

    @Override
    public String toString() {
        return "ButlerArticleOutSearch{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", articleOutStatus=" + articleOutStatus +
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

    public Integer getArticleOutStatus() {
        return articleOutStatus;
    }

    public void setArticleOutStatus(Integer articleOutStatus) {
        this.articleOutStatus = articleOutStatus;
    }

    public ButlerArticleOutSearch() {
    }

    public ButlerArticleOutSearch(int pageNum, int size, Integer articleOutStatus) {
        this.pageNum = pageNum;
        this.size = size;
        this.articleOutStatus = articleOutStatus;
    }
}
