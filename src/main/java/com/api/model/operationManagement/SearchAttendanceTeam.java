package com.api.model.operationManagement;

/**
 * 考勤小组管理 搜索条件
 */
public class SearchAttendanceTeam {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /***
     * 小组名称
     */
    private String name;
    /**
     * 所属部门id
     */
    private Integer organizationId;
    /**
     * 小组成员id
     */
    private Integer teamMembersId;
    /**
     * 创建人id
     */
    private Integer createId;

    @Override
    public String toString() {
        return "SearchAttendanceTeam{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", name='" + name + '\'' +
                ", organizationId=" + organizationId +
                ", teamMembersId=" + teamMembersId +
                ", createId=" + createId +
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public Integer getTeamMembersId() {
        return teamMembersId;
    }

    public void setTeamMembersId(Integer teamMembersId) {
        this.teamMembersId = teamMembersId;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public SearchAttendanceTeam() {
    }

    public SearchAttendanceTeam(int pageNum, int size, String name, Integer organizationId, Integer teamMembersId, Integer createId) {
        this.pageNum = pageNum;
        this.size = size;
        this.name = name;
        this.organizationId = organizationId;
        this.teamMembersId = teamMembersId;
        this.createId = createId;
    }
}
