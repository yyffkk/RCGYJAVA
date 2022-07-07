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
     * 用户主键id
     */
    private Integer id;
    /**
     * 装修状态（6.完工检查中，7.检查通过，8.检查不通过）
     */
    private Integer userDecorationNewStatus;


    @Override
    public String toString() {
        return "ButlerUserDecorationNewSearch{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", id=" + id +
                ", userDecorationNewStatus=" + userDecorationNewStatus +
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

    public Integer getUserDecorationNewStatus() {
        return userDecorationNewStatus;
    }

    public void setUserDecorationNewStatus(Integer userDecorationNewStatus) {
        this.userDecorationNewStatus = userDecorationNewStatus;
    }

    public ButlerUserDecorationNewSearch() {
    }

    public ButlerUserDecorationNewSearch(int pageNum, int size, Integer id, Integer userDecorationNewStatus) {
        this.pageNum = pageNum;
        this.size = size;
        this.id = id;
        this.userDecorationNewStatus = userDecorationNewStatus;
    }
}
