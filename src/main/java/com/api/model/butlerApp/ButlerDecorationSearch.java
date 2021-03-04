package com.api.model.butlerApp;

/**
 * 管家app 装修管理搜索条件
 */
public class ButlerDecorationSearch {
    /**
     * 当前页数
     */
    private int pageNum;
    /***
     * 每页记录数
     */
    private int size;
    /**
     * 操作状态(1.待指派【当检查跟踪人为null且装修状态为>1】，2.已指派（待执行）【装修状态为<5】，3.已完成【装修状态为>=5】,4.全部)
     */
    private int operationStatus;
    /**
     * 用户所拥有的角色id
     */
    private String roleId;

    @Override
    public String toString() {
        return "ButlerDecorationSearch{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", operationStatus=" + operationStatus +
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

    public int getOperationStatus() {
        return operationStatus;
    }

    public void setOperationStatus(int operationStatus) {
        this.operationStatus = operationStatus;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public ButlerDecorationSearch() {
    }

    public ButlerDecorationSearch(int pageNum, int size, int operationStatus, String roleId) {
        this.pageNum = pageNum;
        this.size = size;
        this.operationStatus = operationStatus;
        this.roleId = roleId;
    }
}
