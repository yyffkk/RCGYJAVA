package com.aku.model.butlerService;

/**
 * 违禁关键字 搜索条件
 */
public class SearchProhibitedKeywords {
    /**
     * 当前页数
     */
    private Integer pageNum;
    /**
     * 每页记录数
     */
    private Integer size;
    /**
     * 违禁关键字
     */
    private String keywords;
    /**
     * 替换后显示的字符
     */
    private String replace;

    @Override
    public String toString() {
        return "SearchProhibitedKeywords{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", keywords='" + keywords + '\'' +
                ", replace='" + replace + '\'' +
                '}';
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

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getReplace() {
        return replace;
    }

    public void setReplace(String replace) {
        this.replace = replace;
    }

    public SearchProhibitedKeywords() {
    }

    public SearchProhibitedKeywords(Integer pageNum, Integer size, String keywords, String replace) {
        this.pageNum = pageNum;
        this.size = size;
        this.keywords = keywords;
        this.replace = replace;
    }
}
