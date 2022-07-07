package com.api.model.app;

/**
 * 建议咨询/投诉表扬 搜索条件
 */
public class SearchAppAdvice {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 用户id
     */
    private Integer id;
    /**
     * 类型(1.咨询，2.建议，3.投诉，4.表扬)
     */
    private Integer adviceType;

    @Override
    public String toString() {
        return "SearchAppAdvice{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", id=" + id +
                ", adviceType=" + adviceType +
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

    public Integer getAdviceType() {
        return adviceType;
    }

    public void setAdviceType(Integer adviceType) {
        this.adviceType = adviceType;
    }

    public SearchAppAdvice() {
    }

    public SearchAppAdvice(int pageNum, int size, Integer id, Integer adviceType) {
        this.pageNum = pageNum;
        this.size = size;
        this.id = id;
        this.adviceType = adviceType;
    }
}
