package com.api.model.operationManagement;


import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

/**
 * 活动管理model
 */
public class ActivityManagement {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 主办方
     */
    private Integer sponsorId;
    /**
     * 活动标题
     */
    private String title;
    /**
     * 活动内容
     */
    private String content;
    /**
     * 图片资源路径数组
     */
    private String[] fileUrls;
    /**
     * 活动地点
     */
    private String location;
    /**
     * 报名开始时间
     */
    private Date registrationStartTime;
    /**
     * 报名截止时间
     */
    private Date registrationEndTime;
    /**
     * 活动开始时间
     */
    private Date activityStartTime;
    /**
     * 活动截止时间
     */
    private Date activityEndTime;
    /**
     * 参与人数
     */
    private Integer participantsNumber;
    /**
     * 收费标准
     */
    private Integer chargesTemplateDetailId;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 退费
     */
    private BigDecimal refund;
    /**
     * 联系人
     */
    private String name;
    /**
     * 联系方式
     */
    private String tel;
    /**
     * 创建人
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
    /**
     * 是否删除，0.删除，1.非删
     */
    private Integer isDelete;

    @Override
    public String toString() {
        return "ActivityManagement{" +
                "id=" + id +
                ", sponsorId=" + sponsorId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", fileUrls=" + Arrays.toString(fileUrls) +
                ", location='" + location + '\'' +
                ", registrationStartTime=" + registrationStartTime +
                ", registrationEndTime=" + registrationEndTime +
                ", activityStartTime=" + activityStartTime +
                ", activityEndTime=" + activityEndTime +
                ", participantsNumber=" + participantsNumber +
                ", chargesTemplateDetailId=" + chargesTemplateDetailId +
                ", status=" + status +
                ", refund=" + refund +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", createId=" + createId +
                ", createDate=" + createDate +
                ", modifyId=" + modifyId +
                ", modifyDate=" + modifyDate +
                ", isDelete=" + isDelete +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSponsorId() {
        return sponsorId;
    }

    public void setSponsorId(Integer sponsorId) {
        this.sponsorId = sponsorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String[] getFileUrls() {
        return fileUrls;
    }

    public void setFileUrls(String[] fileUrls) {
        this.fileUrls = fileUrls;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public Integer getParticipantsNumber() {
        return participantsNumber;
    }

    public void setParticipantsNumber(Integer participantsNumber) {
        this.participantsNumber = participantsNumber;
    }

    public Integer getChargesTemplateDetailId() {
        return chargesTemplateDetailId;
    }

    public void setChargesTemplateDetailId(Integer chargesTemplateDetailId) {
        this.chargesTemplateDetailId = chargesTemplateDetailId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BigDecimal getRefund() {
        return refund;
    }

    public void setRefund(BigDecimal refund) {
        this.refund = refund;
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

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public ActivityManagement() {
    }

    public ActivityManagement(Integer id, Integer sponsorId, String title, String content, String[] fileUrls, String location, Date registrationStartTime, Date registrationEndTime, Date activityStartTime, Date activityEndTime, Integer participantsNumber, Integer chargesTemplateDetailId, Integer status, BigDecimal refund, String name, String tel, Integer createId, Date createDate, Integer modifyId, Date modifyDate, Integer isDelete) {
        this.id = id;
        this.sponsorId = sponsorId;
        this.title = title;
        this.content = content;
        this.fileUrls = fileUrls;
        this.location = location;
        this.registrationStartTime = registrationStartTime;
        this.registrationEndTime = registrationEndTime;
        this.activityStartTime = activityStartTime;
        this.activityEndTime = activityEndTime;
        this.participantsNumber = participantsNumber;
        this.chargesTemplateDetailId = chargesTemplateDetailId;
        this.status = status;
        this.refund = refund;
        this.name = name;
        this.tel = tel;
        this.createId = createId;
        this.createDate = createDate;
        this.modifyId = modifyId;
        this.modifyDate = modifyDate;
        this.isDelete = isDelete;
    }
}
