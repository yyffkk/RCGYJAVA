package com.api.vo.operationManagement;

import java.sql.Date;

/**
 * 考勤排班计划 Vo list 回显
 */
public class VoAttendanceSchedulingPlan {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 计划名称
     */
    private String name;
    /**
     * 考勤小组主键id
     */
    private Integer teamId;
    /**
     * 考勤小组名称
     */
    private String teamName;
    /**
     * 状态：1.启用，2.停用
     */
    private Integer status;
    /**
     * 所属部门名称
     */
    private String organizationName;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 创建人id
     */
    private Integer createId;
    /**
     * 创建人名称
     */
    private String createName;

    @Override
    public String toString() {
        return "VoAttendanceSchedulingPlan{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teamId=" + teamId +
                ", teamName='" + teamName + '\'' +
                ", status=" + status +
                ", organizationName='" + organizationName + '\'' +
                ", createDate=" + createDate +
                ", createId=" + createId +
                ", createName='" + createName + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public VoAttendanceSchedulingPlan() {
    }

    public VoAttendanceSchedulingPlan(Integer id, String name, Integer teamId, String teamName, Integer status, String organizationName, Date createDate, Integer createId, String createName) {
        this.id = id;
        this.name = name;
        this.teamId = teamId;
        this.teamName = teamName;
        this.status = status;
        this.organizationName = organizationName;
        this.createDate = createDate;
        this.createId = createId;
        this.createName = createName;
    }
}
