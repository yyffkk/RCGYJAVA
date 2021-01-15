package com.api.model.app;

/**
 * 访客通行搜索条件
 */
public class SearchVisitorAccess {
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
     * 访客状态
     */
    private Integer visitorStatus;

    @Override
    public String toString() {
        return "SearchVisitorAccess{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", id=" + id +
                ", visitorStatus=" + visitorStatus +
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

    public Integer getVisitorStatus() {
        return visitorStatus;
    }

    public void setVisitorStatus(Integer visitorStatus) {
        this.visitorStatus = visitorStatus;
    }

    public SearchVisitorAccess() {
    }

    public SearchVisitorAccess(int pageNum, int size, Integer id, Integer visitorStatus) {
        this.pageNum = pageNum;
        this.size = size;
        this.id = id;
        this.visitorStatus = visitorStatus;
    }
}
