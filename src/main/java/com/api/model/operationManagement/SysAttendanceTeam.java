package com.api.model.operationManagement;

import java.util.Date;

/**
 * 考勤小组管理model
 */
public class SysAttendanceTeam {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 小组名称
     */
    private String name;
    /**
     * 所属部门主键Id
     */
    private Integer organizationId;
    /**
     * 小组成员
     */
    private String teamMembers;
    /**
     * 创建人id
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 修改人
     */
    private Integer modifyId;
    /**
     * 修改时间
     */
    private Date modifyDate;

    @Override
    public String toString() {
        return "SysAttendanceTeam{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", organizationId=" + organizationId +
                ", teamMembers='" + teamMembers + '\'' +
                ", createId=" + createId +
                ", createDate=" + createDate +
                ", modifyId=" + modifyId +
                ", modifyDate=" + modifyDate +
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

    public String getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(String teamMembers) {
        this.teamMembers = teamMembers;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getModifyId() {
        return modifyId;
    }

    public void setModifyId(Integer modifyId) {
        this.modifyId = modifyId;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public SysAttendanceTeam() {
    }

    public SysAttendanceTeam(Integer id, String name, Integer organizationId, String teamMembers, Integer createId, Date createDate, Integer modifyId, Date modifyDate) {
        this.id = id;
        this.name = name;
        this.organizationId = organizationId;
        this.teamMembers = teamMembers;
        this.createId = createId;
        this.createDate = createDate;
        this.modifyId = modifyId;
        this.modifyDate = modifyDate;
    }
}
