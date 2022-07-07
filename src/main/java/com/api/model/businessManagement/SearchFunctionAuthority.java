package com.api.model.businessManagement;

/**
 * 功能权限管理 搜索条件
 */
public class SearchFunctionAuthority {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 主属组织id
     */
    private Integer organizationId;
    /**
     * 角色id
     */
    private Integer roleId;

    @Override
    public String toString() {
        return "SearchFunctionAuthority{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", organizationId=" + organizationId +
                ", roleId=" + roleId +
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

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public SearchFunctionAuthority() {
    }

    public SearchFunctionAuthority(int pageNum, int size, Integer organizationId, Integer roleId) {
        this.pageNum = pageNum;
        this.size = size;
        this.organizationId = organizationId;
        this.roleId = roleId;
    }
}
