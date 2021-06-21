package com.api.model.butlerService;

/**
 * 租赁合同管理 搜索条件
 */
public class SearchLeaseContract {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 模版名称
     */
    private String name;
    /**
     * 启用状态：1.启用，2.停用
     */
    private Integer status;

    @Override
    public String toString() {
        return "SearchLeaseContract{" +
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

    public SearchLeaseContract() {
    }

    public SearchLeaseContract(int pageNum, int size, String name, Integer status) {
        this.pageNum = pageNum;
        this.size = size;
        this.name = name;
        this.status = status;
    }
}
