package com.api.vo.operationManagement;

import com.api.vo.resources.VoResourcesImg;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 活动信息Vo findById 回显
 */
public class VoFindByIdActivityManagement {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 主办方id
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
     * 照片资源集合
     */
    private List<VoResourcesImg> imgUrls;
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
     * 报名结束时间
     */
    private Date registrationEndTime;
    /**
     * 活动开始时间
     */
    private Date activityStartTime;
    /**
     * 活动结束时间
     */
    private Date activityEndTime;
    /**
     * 参与人数
     */
    private Integer participantsNumber;
    /**
     * 状态：1.未开始，2.进行中，3.已结束
     */
    private Integer status;
    /**
     * 费用名称类型(取自 物业收费标准明细表)
     */
    private Integer chargesTemplateDetailId;
    /**
     * 退费
     */
    private BigDecimal refund;

    @Override
    public String toString() {
        return "VoFindByIdActivityManagement{" +
                "id=" + id +
                ", sponsorId=" + sponsorId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", imgUrls=" + imgUrls +
                ", location='" + location + '\'' +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", registrationStartTime=" + registrationStartTime +
                ", registrationEndTime=" + registrationEndTime +
                ", activityStartTime=" + activityStartTime +
                ", activityEndTime=" + activityEndTime +
                ", participantsNumber=" + participantsNumber +
                ", status=" + status +
                ", chargesTemplateDetailId=" + chargesTemplateDetailId +
                ", refund=" + refund +
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

    public List<VoResourcesImg> getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(List<VoResourcesImg> imgUrls) {
        this.imgUrls = imgUrls;
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

    public Integer getParticipantsNumber() {
        return participantsNumber;
    }

    public void setParticipantsNumber(Integer participantsNumber) {
        this.participantsNumber = participantsNumber;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getChargesTemplateDetailId() {
        return chargesTemplateDetailId;
    }

    public void setChargesTemplateDetailId(Integer chargesTemplateDetailId) {
        this.chargesTemplateDetailId = chargesTemplateDetailId;
    }

    public BigDecimal getRefund() {
        return refund;
    }

    public void setRefund(BigDecimal refund) {
        this.refund = refund;
    }

    public VoFindByIdActivityManagement() {
    }

    public VoFindByIdActivityManagement(Integer id, Integer sponsorId, String title, String content, List<VoResourcesImg> imgUrls, String location, String name, String tel, Date registrationStartTime, Date registrationEndTime, Date activityStartTime, Date activityEndTime, Integer participantsNumber, Integer status, Integer chargesTemplateDetailId, BigDecimal refund) {
        this.id = id;
        this.sponsorId = sponsorId;
        this.title = title;
        this.content = content;
        this.imgUrls = imgUrls;
        this.location = location;
        this.name = name;
        this.tel = tel;
        this.registrationStartTime = registrationStartTime;
        this.registrationEndTime = registrationEndTime;
        this.activityStartTime = activityStartTime;
        this.activityEndTime = activityEndTime;
        this.participantsNumber = participantsNumber;
        this.status = status;
        this.chargesTemplateDetailId = chargesTemplateDetailId;
        this.refund = refund;
    }
}
