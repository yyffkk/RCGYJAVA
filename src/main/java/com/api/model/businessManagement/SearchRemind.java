package com.api.model.businessManagement;

/**
 * 提醒通知搜索条件
 */
public class SearchRemind {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 标题
     */
    private String title;
    /**
     * 发送类型（1.系统广播，2.管理员消息）
     */
    private Integer type;

    @Override
    public String toString() {
        return "SearchRemind{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", title='" + title + '\'' +
                ", type=" + type +
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public SearchRemind() {
    }

    public SearchRemind(int pageNum, int size, String title, Integer type) {
        this.pageNum = pageNum;
        this.size = size;
        this.title = title;
        this.type = type;
    }
}
