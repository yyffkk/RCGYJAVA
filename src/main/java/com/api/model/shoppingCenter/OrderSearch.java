package com.api.model.shoppingCenter;

/**
 * 订单搜索条件
 */
public class OrderSearch {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 商品预约主键id
     */
    private Integer id;
    /**
     * 状态：1.待发货，2.已发货，3.已收货
     */
    private Integer status;
    /**
     * 用户手机号
     */
    private String userTel;

    @Override
    public String toString() {
        return "OrderSearch{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", id=" + id +
                ", status=" + status +
                ", userTel='" + userTel + '\'' +
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public OrderSearch() {
    }

    public OrderSearch(int pageNum, int size, Integer id, Integer status, String userTel) {
        this.pageNum = pageNum;
        this.size = size;
        this.id = id;
        this.status = status;
        this.userTel = userTel;
    }
}
