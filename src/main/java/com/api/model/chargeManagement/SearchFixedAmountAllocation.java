package com.api.model.chargeManagement;

/**
 * 固定金额分摊 搜索条件
 */
public class SearchFixedAmountAllocation {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 费用名称
     */
    private String name;
    /**
     * 状态，1.未分摊，2.已分摊
     */
    private Integer status;

    @Override
    public String toString() {
        return "SearchFixedAmountAllocation{" +
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

    public SearchFixedAmountAllocation() {
    }

    public SearchFixedAmountAllocation(int pageNum, int size, String name, Integer status) {
        this.pageNum = pageNum;
        this.size = size;
        this.name = name;
        this.status = status;
    }
}
