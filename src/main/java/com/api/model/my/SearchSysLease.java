package com.api.model.my;

/**
 * 租赁管理 搜索条件
 */
public class SearchSysLease {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 用户手机号
     */
    private String tel;
    /**
     * 父类租赁主键id，正整数代表是续签租赁（数字绝对值代表上一份租赁的主键id），0代表是第一次租赁，负整数代表是变更租赁（数字绝对值代表上一份租赁的主键id）
     */
    private Integer leaseParentId;

    @Override
    public String toString() {
        return "SearchSysLease{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", tel='" + tel + '\'' +
                ", leaseParentId=" + leaseParentId +
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

    public Integer getLeaseParentId() {
        return leaseParentId;
    }

    public void setLeaseParentId(Integer leaseParentId) {
        this.leaseParentId = leaseParentId;
    }

    public SearchSysLease() {
    }

    public SearchSysLease(int pageNum, int size, String tel, Integer leaseParentId) {
        this.pageNum = pageNum;
        this.size = size;
        this.tel = tel;
        this.leaseParentId = leaseParentId;
    }
}
