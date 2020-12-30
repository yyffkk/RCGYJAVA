package com.api.vo.operationManagement;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 活动管理 Vo list 回显
 */
public class VoActivityManagement {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 活动标题
     */
    private String title;
    /**
     * 主办方
     */
    private String sponsorUnit;
    /**
     * 活动地点
     */
    private String location;
    /**
     * 联系人
     */
    private String name;
    /**
     * 联系方式
     */
    private String tel;
    /**
     * 报名开始时间
     */
    private Date registrationStartTime;
    /**
     * 报名截止时间
     */
    private Date registrationEndTime;
    /**
     * 开始时间
     */
    private Date activityStartTime;
    /**
     * 结束时间
     */
    private Date activityEndTime;
    /**
     * 活动状态
     */
    private Integer status;
    /**
     * 报名人数
     */
    private Integer registrationNumber;
    /**
     * 参与人数
     */
    private Integer participantsNumber;
    /**
     * 收费标准名称
     */
    private String chargesTemplateDetailName;
    /**
     * 退费
     */
    private BigDecimal refund;
    /**
     * 创建人
     */
    private String createName;
    /**
     * 更新时间
     */
    private Date updateDate;

    @Override
    public String toString() {
        return "VoActivityManagement{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", sponsorUnit='" + sponsorUnit + '\'' +
                ", location='" + location + '\'' +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", registrationStartTime=" + registrationStartTime +
                ", registrationEndTime=" + registrationEndTime +
                ", activityStartTime=" + activityStartTime +
                ", activityEndTime=" + activityEndTime +
                ", status=" + status +
                ", registrationNumber=" + registrationNumber +
                ", participantsNumber=" + participantsNumber +
                ", chargesTemplateDetailName='" + chargesTemplateDetailName + '\'' +
                ", refund=" + refund +
                ", createName='" + createName + '\'' +
                ", updateDate=" + updateDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSponsorUnit() {
        return sponsorUnit;
    }

    public void setSponsorUnit(String sponsorUnit) {
        this.sponsorUnit = sponsorUnit;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getRegistrationStartTime() {
        return registrationStartTime;
    }

    public void setRegistrationStartTime(Date registrationStartTime) {
        this.registrationStartTime = registrationStartTime;
    }

    public Date getRegistrationEndTime() {
        return registrationEndTime;
    }

    public void setRegistrationEndTime(Date registrationEndTime) {
        this.registrationEndTime = registrationEndTime;
    }

    public Date getActivityStartTime() {
        return activityStartTime;
    }

    public void setActivityStartTime(Date activityStartTime) {
        this.activityStartTime = activityStartTime;
    }

    public Date getActivityEndTime() {
        return activityEndTime;
    }

    public void setActivityEndTime(Date activityEndTime) {
        this.activityEndTime = activityEndTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(Integer registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Integer getParticipantsNumber() {
        return participantsNumber;
    }

    public void setParticipantsNumber(Integer participantsNumber) {
        this.participantsNumber = participantsNumber;
    }

    public String getChargesTemplateDetailName() {
        return chargesTemplateDetailName;
    }

    public void setChargesTemplateDetailName(String chargesTemplateDetailName) {
        this.chargesTemplateDetailName = chargesTemplateDetailName;
    }

    public BigDecimal getRefund() {
        return refund;
    }

    public void setRefund(BigDecimal refund) {
        this.refund = refund;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public VoActivityManagement() {
    }

    public VoActivityManagement(Integer id, String title, String sponsorUnit, String location, String name, String tel, Date registrationStartTime, Date registrationEndTime, Date activityStartTime, Date activityEndTime, Integer status, Integer registrationNumber, Integer participantsNumber, String chargesTemplateDetailName, BigDecimal refund, String createName, Date updateDate) {
        this.id = id;
        this.title = title;
        this.sponsorUnit = sponsorUnit;
        this.location = location;
        this.name = name;
        this.tel = tel;
        this.registrationStartTime = registrationStartTime;
        this.registrationEndTime = registrationEndTime;
        this.activityStartTime = activityStartTime;
        this.activityEndTime = activityEndTime;
        this.status = status;
        this.registrationNumber = registrationNumber;
        this.participantsNumber = participantsNumber;
        this.chargesTemplateDetailName = chargesTemplateDetailName;
        this.refund = refund;
        this.createName = createName;
        this.updateDate = updateDate;
    }
}
