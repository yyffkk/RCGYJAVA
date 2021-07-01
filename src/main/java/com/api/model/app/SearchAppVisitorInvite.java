package com.api.model.app;

/**
 * 新版的访客邀请管理 搜索条件
 */
public class SearchAppVisitorInvite {
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
     * 新版访客邀请状态(状态：1.已分享，2.已提交，3.已过期（此状态数据库不存在，数据判断出来的），为null时，查询所有状态)
     */
    private Integer visitorInviteStatus;

    @Override
    public String toString() {
        return "SearchAppVisitorInvite{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", id=" + id +
                ", visitorInviteStatus=" + visitorInviteStatus +
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

    public Integer getVisitorInviteStatus() {
        return visitorInviteStatus;
    }

    public void setVisitorInviteStatus(Integer visitorInviteStatus) {
        this.visitorInviteStatus = visitorInviteStatus;
    }

    public SearchAppVisitorInvite() {
    }

    public SearchAppVisitorInvite(int pageNum, int size, Integer id, Integer visitorInviteStatus) {
        this.pageNum = pageNum;
        this.size = size;
        this.id = id;
        this.visitorInviteStatus = visitorInviteStatus;
    }
}
