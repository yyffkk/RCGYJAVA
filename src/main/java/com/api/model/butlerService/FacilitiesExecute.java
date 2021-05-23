package com.api.model.butlerService;

import java.util.Date;

/**
 * 设施/设备检查执行情况
 */
public class FacilitiesExecute {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 状态：1.待完成，2.已完成，3.未完成（数据库不存该状态）
     */
    private Integer status;
    /**
     * 设施/设备巡检计划主键id
     */
    private Integer facilitiesPlanId;
    /**
     * 设施/设备计划当次检查开始时间
     */
    private Date beginDate;
    /**
     * 设施/设备计划当次检查结束时间
     */
    private Date endDate;
    /**
     * 设施/设备实际检查时间
     */
    private Date checkDate;
    /**
     * 设施/设备情况：1.正常，2.异常
     */
    private Integer situation;
    /**
     * 设施/设备检查报告
     */
    private String detail;
    /**
     * 排序，设施/设备检查计划的第几次执行
     */
    private Integer sort;

    @Override
    public String toString() {
        return "FacilitiesExecute{" +
                "id=" + id +
                ", status=" + status +
                ", facilitiesPlanId=" + facilitiesPlanId +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", checkDate=" + checkDate +
                ", situation=" + situation +
                ", detail='" + detail + '\'' +
                ", sort=" + sort +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getFacilitiesPlanId() {
        return facilitiesPlanId;
    }

    public void setFacilitiesPlanId(Integer facilitiesPlanId) {
        this.facilitiesPlanId = facilitiesPlanId;
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

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    public Integer getSituation() {
        return situation;
    }

    public void setSituation(Integer situation) {
        this.situation = situation;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public FacilitiesExecute() {
    }

    public FacilitiesExecute(Integer id, Integer status, Integer facilitiesPlanId, Date beginDate, Date endDate, Date checkDate, Integer situation, String detail, Integer sort) {
        this.id = id;
        this.status = status;
        this.facilitiesPlanId = facilitiesPlanId;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.checkDate = checkDate;
        this.situation = situation;
        this.detail = detail;
        this.sort = sort;
    }
}
