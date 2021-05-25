package com.api.model.butlerApp;

/**
 * 管家app 客户访谈搜索条件
 */
public class ButlerInterviewSearch {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 用户主键id
     */
    private Integer id;
    /**
     * 访谈状态：1.待访谈，2.已访谈
     */
    private Integer interviewStatus;

    @Override
    public String toString() {
        return "ButlerInterviewSearch{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", id=" + id +
                ", interviewStatus=" + interviewStatus +
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

    public Integer getInterviewStatus() {
        return interviewStatus;
    }

    public void setInterviewStatus(Integer interviewStatus) {
        this.interviewStatus = interviewStatus;
    }

    public ButlerInterviewSearch() {
    }

    public ButlerInterviewSearch(int pageNum, int size, Integer id, Integer interviewStatus) {
        this.pageNum = pageNum;
        this.size = size;
        this.id = id;
        this.interviewStatus = interviewStatus;
    }
}
