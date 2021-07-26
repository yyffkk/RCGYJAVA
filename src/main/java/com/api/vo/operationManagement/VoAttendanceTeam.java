package com.api.vo.operationManagement;

import java.util.Date;

/**
 * 考勤小队 Vo list 回显
 */
public class VoAttendanceTeam {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 小组名称
     */
    private String name;
    /**
     * 所属部门主键id
     */
    private Integer organizationId;
    /**
     * 所属部门名称
     */
    private String organizationName;
    /**
     * 小组成员名称（名称、名称、名称）
     */
    private String teamMembers;
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
        return "VoAttendanceTeam{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", organizationId=" + organizationId +
                ", organizationName='" + organizationName + '\'' +
                ", teamMembers='" + teamMembers + '\'' +
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

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(String teamMembers) {
        this.teamMembers = teamMembers;
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

    public VoAttendanceTeam() {
    }

    public VoAttendanceTeam(Integer id, String name, Integer organizationId, String organizationName, String teamMembers, Date createDate, Integer createId, String createName) {
        this.id = id;
        this.name = name;
        this.organizationId = organizationId;
        this.organizationName = organizationName;
        this.teamMembers = teamMembers;
        this.createDate = createDate;
        this.createId = createId;
        this.createName = createName;
    }
}
