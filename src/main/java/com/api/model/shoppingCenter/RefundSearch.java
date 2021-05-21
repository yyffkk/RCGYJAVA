package com.api.model.shoppingCenter;

/**
 * 退换货管理搜索条件
 */
public class RefundSearch {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 商品预约编号
     */
    private String code;
    /**
     * 客户期望：1.退货，2.换货
     */
    private Integer backType;
    /**
     * 用户手机号
     */
    private String userTel;
    /**
     * 状态：4.申请退换货，5.申请通过，6.申请驳回
     */
    private Integer status;

    @Override
    public String toString() {
        return "RefundSearch{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", code='" + code + '\'' +
                ", backType=" + backType +
                ", userTel='" + userTel + '\'' +
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getBackType() {
        return backType;
    }

    public void setBackType(Integer backType) {
        this.backType = backType;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public RefundSearch() {
    }

    public RefundSearch(int pageNum, int size, String code, Integer backType, String userTel, Integer status) {
        this.pageNum = pageNum;
        this.size = size;
        this.code = code;
        this.backType = backType;
        this.userTel = userTel;
        this.status = status;
    }
}
