package com.api.model.butlerService;

/**
 * 物品管理搜索条件
 */
public class SearchArticle {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 物品名称
     */
    private String name;

    @Override
    public String toString() {
        return "SearchArticle{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", name='" + name + '\'' +
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SearchArticle() {
    }

    public SearchArticle(int pageNum, int size, String name) {
        this.pageNum = pageNum;
        this.size = size;
        this.name = name;
    }
}
