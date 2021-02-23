package com.api.model.basicArchives;

/**
 * 模糊查询名称搜索条件
 */
public class SearchFindName {
    /**
     * 名称
     */
    private String name;
    /**
     * 当前页
     */
    private Integer pageNum;
    /**
     * 每页记录数
     */
    private Integer size;

    @Override
    public String toString() {
        return "SearchFindName{" +
                "name='" + name + '\'' +
                ", pageNum=" + pageNum +
                ", size=" + size +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public SearchFindName() {
    }

    public SearchFindName(String name, Integer pageNum, Integer size) {
        this.name = name;
        this.pageNum = pageNum;
        this.size = size;
    }
}
