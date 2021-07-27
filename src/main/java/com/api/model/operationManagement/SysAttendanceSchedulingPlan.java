package com.api.model.operationManagement;

import java.util.Date;
import java.util.List;

/**
 * 考勤排班计划model
 */
public class SysAttendanceSchedulingPlan {
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
     * 状态：1.启用，2.停用
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 创建人id
     */
    private Integer createId;
    /**
     * 排班计划详情集合
     */
    private List<SysAttendanceSchedulingPlanDetail> sysAttendanceSchedulingPlanDetails;
    /**
     * 考勤排班计划例外情况集合
     */
    private List<SysAttendanceSchedulingPlanException> sysAttendanceSchedulingPlanExceptionList;

    @Override
    public String toString() {
        return "SysAttendanceSchedulingPlan{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teamId=" + teamId +
                ", status=" + status +
                ", createDate=" + createDate +
                ", createId=" + createId +
                ", sysAttendanceSchedulingPlanDetails=" + sysAttendanceSchedulingPlanDetails +
                ", sysAttendanceSchedulingPlanExceptionList=" + sysAttendanceSchedulingPlanExceptionList +
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public List<SysAttendanceSchedulingPlanDetail> getSysAttendanceSchedulingPlanDetails() {
        return sysAttendanceSchedulingPlanDetails;
    }

    public void setSysAttendanceSchedulingPlanDetails(List<SysAttendanceSchedulingPlanDetail> sysAttendanceSchedulingPlanDetails) {
        this.sysAttendanceSchedulingPlanDetails = sysAttendanceSchedulingPlanDetails;
    }

    public List<SysAttendanceSchedulingPlanException> getSysAttendanceSchedulingPlanExceptionList() {
        return sysAttendanceSchedulingPlanExceptionList;
    }

    public void setSysAttendanceSchedulingPlanExceptionList(List<SysAttendanceSchedulingPlanException> sysAttendanceSchedulingPlanExceptionList) {
        this.sysAttendanceSchedulingPlanExceptionList = sysAttendanceSchedulingPlanExceptionList;
    }

    public SysAttendanceSchedulingPlan() {
    }

    public SysAttendanceSchedulingPlan(Integer id, String name, Integer teamId, Integer status, Date createDate, Integer createId, List<SysAttendanceSchedulingPlanDetail> sysAttendanceSchedulingPlanDetails, List<SysAttendanceSchedulingPlanException> sysAttendanceSchedulingPlanExceptionList) {
        this.id = id;
        this.name = name;
        this.teamId = teamId;
        this.status = status;
        this.createDate = createDate;
        this.createId = createId;
        this.sysAttendanceSchedulingPlanDetails = sysAttendanceSchedulingPlanDetails;
        this.sysAttendanceSchedulingPlanExceptionList = sysAttendanceSchedulingPlanExceptionList;
    }
}
