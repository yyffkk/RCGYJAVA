package com.api.model.butlerApp;

/**
 * 管家app  新版家政服务搜索条件
 */
public class ButlerHousekeepingServiceSearch {
    /**
     * 用户id
     */
    private Integer id;
    /**
     * 当前用户 角色ID，用'，'隔开，格式为(1,2)
     */
    private String roleId;
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 家政服务状态
     */
    private Integer housekeepingServiceStatus;

    @Override
    public String toString() {
        return "ButlerHousekeepingServiceSearch{" +
                "id=" + id +
                ", roleId='" + roleId + '\'' +
                ", pageNum=" + pageNum +
                ", size=" + size +
                ", housekeepingServiceStatus=" + housekeepingServiceStatus +
                '}';
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

    public Integer getHousekeepingServiceStatus() {
        return housekeepingServiceStatus;
    }

    public void setHousekeepingServiceStatus(Integer housekeepingServiceStatus) {
        this.housekeepingServiceStatus = housekeepingServiceStatus;
    }

    public ButlerHousekeepingServiceSearch() {
    }

    public ButlerHousekeepingServiceSearch(Integer id, String roleId, int pageNum, int size, Integer housekeepingServiceStatus) {
        this.id = id;
        this.roleId = roleId;
        this.pageNum = pageNum;
        this.size = size;
        this.housekeepingServiceStatus = housekeepingServiceStatus;
    }
}
