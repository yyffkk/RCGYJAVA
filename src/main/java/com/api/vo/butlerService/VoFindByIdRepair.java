package com.api.vo.butlerService;

import java.util.Date;

/**
 * 报事报修 Vo findById 回显
 */
public class VoFindByIdRepair {
    /**
     * 报修主键id
     */
    private Integer id;
    /**
     * 报修区域（服务类型 1.公区维修（户外维修） 2.家庭维修）
     */
    private Integer type;
    /**
     * 报修详情
     */
    private String reportDetail;
    /**
     * 报修人
     */
    private Integer repairman;
    /**
     * 报修人姓名
     */
    private String repairName;
    /**
     * 联系电话
     */
    private String tel;
    /**
     * 预约时间
     */
    private Date appointmentTime;
    /**
     * 报修来源
     */
    private Integer froms;
    /**
     * 录单人姓名
     */
    private String createName;
    /**
     * 录单时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "VoFindByIdRepair{" +
                "id=" + id +
                ", type=" + type +
                ", reportDetail='" + reportDetail + '\'' +
                ", repairman=" + repairman +
                ", repairName='" + repairName + '\'' +
                ", tel='" + tel + '\'' +
                ", appointmentTime=" + appointmentTime +
                ", froms=" + froms +
                ", createName='" + createName + '\'' +
                ", createDate=" + createDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getReportDetail() {
        return reportDetail;
    }

    public void setReportDetail(String reportDetail) {
        this.reportDetail = reportDetail;
    }

    public Integer getRepairman() {
        return repairman;
    }

    public void setRepairman(Integer repairman) {
        this.repairman = repairman;
    }

    public String getRepairName() {
        return repairName;
    }

    public void setRepairName(String repairName) {
        this.repairName = repairName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(Date appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public Integer getFroms() {
        return froms;
    }

    public void setFroms(Integer froms) {
        this.froms = froms;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public VoFindByIdRepair() {
    }

    public VoFindByIdRepair(Integer id, Integer type, String reportDetail, Integer repairman, String repairName, String tel, Date appointmentTime, Integer froms, String createName, Date createDate) {
        this.id = id;
        this.type = type;
        this.reportDetail = reportDetail;
        this.repairman = repairman;
        this.repairName = repairName;
        this.tel = tel;
        this.appointmentTime = appointmentTime;
        this.froms = froms;
        this.createName = createName;
        this.createDate = createDate;
    }
}
