package com.api.model.butlerService;

/**
 * 物品明细管理搜索条件
 */
public class SearchArticleDetail {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 物品名称
     */
    private String name;
    /**
     * 状态（1.正常，2.破损）
     */
    private Integer status;

    @Override
    public String toString() {
        return "SearchArticleDetail{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", name='" + name + '\'' +
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public SearchArticleDetail() {
    }

    public SearchArticleDetail(int pageNum, int size, String name, Integer status) {
        this.pageNum = pageNum;
        this.size = size;
        this.name = name;
        this.status = status;
    }
}
