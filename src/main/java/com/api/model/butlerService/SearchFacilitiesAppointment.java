package com.api.model.butlerService;

import java.util.Date;

/**
 * 设施预约管理 搜索条件
 */
public class SearchFacilitiesAppointment {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 设施编号
     */
    private String code;
    /**
     * 设施分类主键id
     */
    private Integer facilitiesCategoryId;
    /**
     * 预约人id
     */
    private Integer appointmentId;
    /**
     * 预约状态（1.未签到，2.已签到，3.已作废，4.已取消,5.已结束）
     */
    private Integer status;
    /**
     * 预约开始时间
     */
    private Date appointmentStartDate;
    /**
     * 预约结束时间
     */
    private Date appointmentEndDate;
    /**
     * 申请开始时间
     */
    private Date createStartDate;
    /**
     * 申请结束时间
     */
    private Date createEndDate;

    @Override
    public String toString() {
        return "SearchFacilitiesAppointment{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", code='" + code + '\'' +
                ", facilitiesCategoryId=" + facilitiesCategoryId +
                ", appointmentId=" + appointmentId +
                ", status=" + status +
                ", appointmentStartDate=" + appointmentStartDate +
                ", appointmentEndDate=" + appointmentEndDate +
                ", createStartDate=" + createStartDate +
                ", createEndDate=" + createEndDate +
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getFacilitiesCategoryId() {
        return facilitiesCategoryId;
    }

    public void setFacilitiesCategoryId(Integer facilitiesCategoryId) {
        this.facilitiesCategoryId = facilitiesCategoryId;
    }

    public Integer getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Integer appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getAppointmentStartDate() {
        return appointmentStartDate;
    }

    public void setAppointmentStartDate(Date appointmentStartDate) {
        this.appointmentStartDate = appointmentStartDate;
    }

    public Date getAppointmentEndDate() {
        return appointmentEndDate;
    }

    public void setAppointmentEndDate(Date appointmentEndDate) {
        this.appointmentEndDate = appointmentEndDate;
    }

    public Date getCreateStartDate() {
        return createStartDate;
    }

    public void setCreateStartDate(Date createStartDate) {
        this.createStartDate = createStartDate;
    }

    public Date getCreateEndDate() {
        return createEndDate;
    }

    public void setCreateEndDate(Date createEndDate) {
        this.createEndDate = createEndDate;
    }

    public SearchFacilitiesAppointment() {
    }

    public SearchFacilitiesAppointment(int pageNum, int size, String code, Integer facilitiesCategoryId, Integer appointmentId, Integer status, Date appointmentStartDate, Date appointmentEndDate, Date createStartDate, Date createEndDate) {
        this.pageNum = pageNum;
        this.size = size;
        this.code = code;
        this.facilitiesCategoryId = facilitiesCategoryId;
        this.appointmentId = appointmentId;
        this.status = status;
        this.appointmentStartDate = appointmentStartDate;
        this.appointmentEndDate = appointmentEndDate;
        this.createStartDate = createStartDate;
        this.createEndDate = createEndDate;
    }
}
