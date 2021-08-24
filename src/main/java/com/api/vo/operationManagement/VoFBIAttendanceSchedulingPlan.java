package com.api.vo.operationManagement;

import java.util.List;

/**
 * 考勤排班计划 findById Vo 回显
 */
public class VoFBIAttendanceSchedulingPlan {
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
     * 排班计划详情Vo集合
     */
    private List<SysAttendanceSchedulingPlanDetailVo> sysAttendanceSchedulingPlanDetailVoList;
    /**
     * 考勤排班计划例外情况Vo集合
     */
    private List<SysAttendanceSchedulingPlanExceptionVo> sysAttendanceSchedulingPlanExceptionVOList;

    @Override
    public String toString() {
        return "VoFBIAttendanceSchedulingPlan{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teamId=" + teamId +
                ", teamName='" + teamName + '\'' +
                ", status=" + status +
                ", organizationName='" + organizationName + '\'' +
                ", sysAttendanceSchedulingPlanDetailVoList=" + sysAttendanceSchedulingPlanDetailVoList +
                ", sysAttendanceSchedulingPlanExceptionVOList=" + sysAttendanceSchedulingPlanExceptionVOList +
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

    public List<SysAttendanceSchedulingPlanDetailVo> getSysAttendanceSchedulingPlanDetailVoList() {
        return sysAttendanceSchedulingPlanDetailVoList;
    }

    public void setSysAttendanceSchedulingPlanDetailVoList(List<SysAttendanceSchedulingPlanDetailVo> sysAttendanceSchedulingPlanDetailVoList) {
        this.sysAttendanceSchedulingPlanDetailVoList = sysAttendanceSchedulingPlanDetailVoList;
    }

    public List<SysAttendanceSchedulingPlanExceptionVo> getSysAttendanceSchedulingPlanExceptionVOList() {
        return sysAttendanceSchedulingPlanExceptionVOList;
    }

    public void setSysAttendanceSchedulingPlanExceptionVOList(List<SysAttendanceSchedulingPlanExceptionVo> sysAttendanceSchedulingPlanExceptionVOList) {
        this.sysAttendanceSchedulingPlanExceptionVOList = sysAttendanceSchedulingPlanExceptionVOList;
    }

    public VoFBIAttendanceSchedulingPlan() {
    }

    public VoFBIAttendanceSchedulingPlan(Integer id, String name, Integer teamId, String teamName, Integer status, String organizationName, List<SysAttendanceSchedulingPlanDetailVo> sysAttendanceSchedulingPlanDetailVoList, List<SysAttendanceSchedulingPlanExceptionVo> sysAttendanceSchedulingPlanExceptionVOList) {
        this.id = id;
        this.name = name;
        this.teamId = teamId;
        this.teamName = teamName;
        this.status = status;
        this.organizationName = organizationName;
        this.sysAttendanceSchedulingPlanDetailVoList = sysAttendanceSchedulingPlanDetailVoList;
        this.sysAttendanceSchedulingPlanExceptionVOList = sysAttendanceSchedulingPlanExceptionVOList;
    }
}
