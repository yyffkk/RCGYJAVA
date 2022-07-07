package com.api.model.butlerApp;

/**
 * 管家app 绿化任务搜索条件
 */
public class ButlerGreenSearch {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 状态 1.待处理，2.已完成，3.未完成（不为数据库数据）
     */
    private Integer greenStatus;
    /**
     * 用户主键id
     */
    private Integer id;
    /**
     * 当前用户 角色ID，用'，'隔开，格式为(1,2)
     */
    private String roleId;

    @Override
    public String toString() {
        return "ButlerGreenSearch{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", greenStatus=" + greenStatus +
                ", id=" + id +
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

    public Integer getGreenStatus() {
        return greenStatus;
    }

    public void setGreenStatus(Integer greenStatus) {
        this.greenStatus = greenStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public ButlerGreenSearch() {
    }

    public ButlerGreenSearch(int pageNum, int size, Integer greenStatus, Integer id, String roleId) {
        this.pageNum = pageNum;
        this.size = size;
        this.greenStatus = greenStatus;
        this.id = id;
        this.roleId = roleId;
    }
}
