package com.api.vo.butlerApp;

import java.util.Date;

/**
 * 巡检管理 Vo findDetailById 回显
 */
public class ButlerInspectionFDBIVo {
    /**
     * 巡检执行情况主键id
     */
    private Integer id;
    /**
     * 巡检计划主键id
     */
    private Integer inspectionPlanId;
    /**
     * 巡检执行情况编号（巡检计划编号+巡检执行情况sort）
     */
    private String code;
    /**
     * 巡检执行情况名称
     */
    private String name;
    /**
     * 巡检执行情况计划开始时间
     */
    private Date beginDate;
    /**
     * 巡检执行情况计划结束时间
     */
    private Date endDate;
    /**
     * 巡检执行情况实际开始时间
     */
    private Date actualBeginDate;
    /**
     * 巡检执行情况实际结束时间
     */
    private Date actualEndDate;
    /**
     * 排序，巡检计划的第几次执行
     */
    private Integer sort;
    /**
     * 巡检状态（1.待巡检，2.已巡检，3.巡检中，4.未巡检）
     */
    private Integer status;

    @Override
    public String toString() {
        return "ButlerInspectionFDBIVo{" +
                "id=" + id +
                ", inspectionPlanId=" + inspectionPlanId +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", actualBeginDate=" + actualBeginDate +
                ", actualEndDate=" + actualEndDate +
                ", sort=" + sort +
                ", status=" + status +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInspectionPlanId() {
        return inspectionPlanId;
    }

    public void setInspectionPlanId(Integer inspectionPlanId) {
        this.inspectionPlanId = inspectionPlanId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getActualBeginDate() {
        return actualBeginDate;
    }

    public void setActualBeginDate(Date actualBeginDate) {
        this.actualBeginDate = actualBeginDate;
    }

    public Date getActualEndDate() {
        return actualEndDate;
    }

    public void setActualEndDate(Date actualEndDate) {
        this.actualEndDate = actualEndDate;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public ButlerInspectionFDBIVo() {
    }

    public ButlerInspectionFDBIVo(Integer id, Integer inspectionPlanId, String code, String name, Date beginDate, Date endDate, Date actualBeginDate, Date actualEndDate, Integer sort, Integer status) {
        this.id = id;
        this.inspectionPlanId = inspectionPlanId;
        this.code = code;
        this.name = name;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.actualBeginDate = actualBeginDate;
        this.actualEndDate = actualEndDate;
        this.sort = sort;
        this.status = status;
    }
}
