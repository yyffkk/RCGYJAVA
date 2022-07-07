package com.api.model.operationManagement;

/**
 * 客户访谈搜索条件
 */
public class SearchInterview {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 客户手机号
     */
    private String tel;
    /**
     * 访谈状态：1.未访谈，2.已访谈
     */
    private Integer status;

    @Override
    public String toString() {
        return "SearchInterview{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", tel='" + tel + '\'' +
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public SearchInterview() {
    }

    public SearchInterview(int pageNum, int size, String tel, Integer status) {
        this.pageNum = pageNum;
        this.size = size;
        this.tel = tel;
        this.status = status;
    }
}
