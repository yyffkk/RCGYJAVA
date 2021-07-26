package com.api.model.operationManagement;

/**
 * 考勤排班计划搜索条件
 */
public class SearchAttendanceSchedulingPlan {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 计划名称
     */
    private String name;
    /***
     * 状态：1.启用，2.停用
     */
    private Integer status;
    /**
     * 所属部门主键id
     */
    private Integer organizationId;
    /**
     * 创建人主键id
     */
    private Integer createId;
    /**
     * 考勤小组主键id
     */
    private Integer teamId;

    @Override
    public String toString() {
        return "SearchAttendanceSchedulingPlan{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", organizationId=" + organizationId +
                ", createId=" + createId +
                ", teamId=" + teamId +
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public SearchAttendanceSchedulingPlan() {
    }

    public SearchAttendanceSchedulingPlan(int pageNum, int size, String name, Integer status, Integer organizationId, Integer createId, Integer teamId) {
        this.pageNum = pageNum;
        this.size = size;
        this.name = name;
        this.status = status;
        this.organizationId = organizationId;
        this.createId = createId;
        this.teamId = teamId;
    }
}
