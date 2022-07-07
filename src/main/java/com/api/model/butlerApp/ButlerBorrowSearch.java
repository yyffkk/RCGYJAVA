package com.api.model.butlerApp;

/**
 * 管家app 借还管理搜索条件
 */
public class ButlerBorrowSearch {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 借取状态（1.出借中，2.已还，3.待检查）
     */
    private Integer borrowStatus;
    /**
     * 用户所拥有的角色id
     */
    private String roleId;

    @Override
    public String toString() {
        return "ButlerBorrowSearch{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", borrowStatus=" + borrowStatus +
                ", roleId='" + roleId + '\'' +
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

    public Integer getBorrowStatus() {
        return borrowStatus;
    }

    public void setBorrowStatus(Integer borrowStatus) {
        this.borrowStatus = borrowStatus;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public ButlerBorrowSearch() {
    }

    public ButlerBorrowSearch(int pageNum, int size, Integer borrowStatus, String roleId) {
        this.pageNum = pageNum;
        this.size = size;
        this.borrowStatus = borrowStatus;
        this.roleId = roleId;
    }
}
