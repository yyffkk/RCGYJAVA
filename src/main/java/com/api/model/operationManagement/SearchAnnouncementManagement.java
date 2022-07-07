package com.api.model.operationManagement;

/**
 * 公告管理（搜索条件）
 */
public class SearchAnnouncementManagement {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 公告标题
     */
    private String title;
    /**
     * 公告状态
     */
    private Integer status;

    @Override
    public String toString() {
        return "SearchAnnouncementManagement{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", title='" + title + '\'' +
                ", status=" + status +
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public SearchAnnouncementManagement() {
    }

    public SearchAnnouncementManagement(int pageNum, int size, String title, Integer status) {
        this.pageNum = pageNum;
        this.size = size;
        this.title = title;
        this.status = status;
    }
}
