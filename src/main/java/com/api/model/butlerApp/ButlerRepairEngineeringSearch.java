package com.api.model.butlerApp;

/**
 * 管家app 报事报修-工程维修 搜索条件
 */
public class ButlerRepairEngineeringSearch {
    /**
     * 用户id
     */
    private Integer id;
    /**
     * 当前用户 角色ID，用'，'隔开，格式为(1,2)
     */
    private String roleId;
    /**
     * 组织ID全路径  用‘:’分割
     */
    private String organizationIdPath;
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 报事报修工程维修状态
     */
    private Integer repairEngineeringStatus;

    @Override
    public String toString() {
        return "ButlerRepairEngineeringSearch{" +
                "id=" + id +
                ", roleId='" + roleId + '\'' +
                ", organizationIdPath='" + organizationIdPath + '\'' +
                ", pageNum=" + pageNum +
                ", size=" + size +
                ", repairEngineeringStatus=" + repairEngineeringStatus +
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

    public String getOrganizationIdPath() {
        return organizationIdPath;
    }

    public void setOrganizationIdPath(String organizationIdPath) {
        this.organizationIdPath = organizationIdPath;
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

    public Integer getRepairEngineeringStatus() {
        return repairEngineeringStatus;
    }

    public void setRepairEngineeringStatus(Integer repairEngineeringStatus) {
        this.repairEngineeringStatus = repairEngineeringStatus;
    }

    public ButlerRepairEngineeringSearch() {
    }

    public ButlerRepairEngineeringSearch(Integer id, String roleId, String organizationIdPath, int pageNum, int size, Integer repairEngineeringStatus) {
        this.id = id;
        this.roleId = roleId;
        this.organizationIdPath = organizationIdPath;
        this.pageNum = pageNum;
        this.size = size;
        this.repairEngineeringStatus = repairEngineeringStatus;
    }
}
