package com.api.model.app;

/**
 * app 新版家政服务搜素条件
 */
public class SearchAppHousekeepingService {
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
     * 家政状态
     */
    private Integer housekeepingStatus;

    @Override
    public String toString() {
        return "SearchAppHousekeepingService{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", id=" + id +
                ", housekeepingStatus=" + housekeepingStatus +
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

    public Integer getHousekeepingStatus() {
        return housekeepingStatus;
    }

    public void setHousekeepingStatus(Integer housekeepingStatus) {
        this.housekeepingStatus = housekeepingStatus;
    }

    public SearchAppHousekeepingService() {
    }

    public SearchAppHousekeepingService(int pageNum, int size, Integer id, Integer housekeepingStatus) {
        this.pageNum = pageNum;
        this.size = size;
        this.id = id;
        this.housekeepingStatus = housekeepingStatus;
    }
}
