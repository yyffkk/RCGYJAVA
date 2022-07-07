package com.api.model.butlerService;

import java.util.Date;

/**
 * 巡检执行情况
 */
public class SysInspectionExecute {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 巡检计划主键id
     */
    private Integer inspectionPlanId;
    /**
     * 计划当次巡检开始时间
     */
    private Date beginDate;
    /**
     * 计划当次巡检结束时间
     */
    private Date endDate;
    /**
     * 实际当次巡检开始时间
     */
    private Date actualBeginDate;
    /**
     * 实际当次巡检结束时间
     */
    private Date actualEndDate;
    /**
     * 排序,第几次巡检
     */
    private Integer sort;

    @Override
    public String toString() {
        return "SysInspectionExecute{" +
                "id=" + id +
                ", inspectionPlanId=" + inspectionPlanId +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", actualBeginDate=" + actualBeginDate +
                ", actualEndDate=" + actualEndDate +
                ", sort=" + sort +
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

    public SysInspectionExecute() {
    }

    public SysInspectionExecute(Integer id, Integer inspectionPlanId, Date beginDate, Date endDate, Date actualBeginDate, Date actualEndDate, Integer sort) {
        this.id = id;
        this.inspectionPlanId = inspectionPlanId;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.actualBeginDate = actualBeginDate;
        this.actualEndDate = actualEndDate;
        this.sort = sort;
    }
}
