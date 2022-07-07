package com.api.model.app;

/**
 * 新版装修 搜索条件
 */
public class SearchAppUserDecorationNew {
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
     * 装修状态（1.装修申请中，2.装修通过(装修中)，3.装修驳回，5.申请完工检查，6.检查通过，7.检查不通过）
     */
    private Integer userDecorationNewStatus;

    @Override
    public String toString() {
        return "SearchAppUserDecorationNew{" +
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

    public SearchAppUserDecorationNew() {
    }

    public SearchAppUserDecorationNew(int pageNum, int size, Integer id, Integer userDecorationNewStatus) {
        this.pageNum = pageNum;
        this.size = size;
        this.id = id;
        this.userDecorationNewStatus = userDecorationNewStatus;
    }
}
