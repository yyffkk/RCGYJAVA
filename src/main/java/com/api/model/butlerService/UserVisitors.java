package com.api.model.butlerService;

import java.util.Date;

/**
 * 访问管理表信息
 */
public class UserVisitors {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 访问单元房产id
     */
    private Integer buildingUnitEstateId;
    /**
     * 邀请人（业主表）
     */
    private Integer invitePeopleId;
    /**
     * 填写类型(1.业主填写，2.访客填写)
     */
    private Integer type;
    /**
     * 访客姓名
     */
    private String name;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 联系电话
     */
    private String tel;
    /**
     * 是否开车(1.开车，0.不开车)
     */
    private Integer isDrive;
    /**
     * 车牌号
     */
    private String carNum;
    /**
     * 预计到访时间
     */
    private Date expectedVisitDate;
    /**
     * 实际到访时间
     */
    private Date visitDate;
    /**
     * 实际离开时间（最后一次离开时间）
     */
    private Date departureTime;
    /**
     * 有效时间
     */
    private Date effectiveTime;
    /**
     * 访客状态(1.未到，2.已到,3.已过期，4.作废)
     */
    private Integer visitorStatus;
    /**
     * 创建人（业主表）
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 修改人(业主表)
     */
    private Integer modifyId;
    /**
     * 修改时间
     */
    private Date modifyDate;
    /**
     * 核对人(物业表) -1为系统
     */
    private Integer verifierId;
    /**
     * 核对时间
     */
    private Date verifierDate;
    /**
     * 通行证认证码
     */
    private Long accessCode;

    @Override
    public String toString() {
        return "UserVisitors{" +
                "id=" + id +
                ", buildingUnitEstateId=" + buildingUnitEstateId +
                ", invitePeopleId=" + invitePeopleId +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", tel='" + tel + '\'' +
                ", isDrive=" + isDrive +
                ", carNum='" + carNum + '\'' +
                ", expectedVisitDate=" + expectedVisitDate +
                ", visitDate=" + visitDate +
                ", departureTime=" + departureTime +
                ", effectiveTime=" + effectiveTime +
                ", visitorStatus=" + visitorStatus +
                ", createId=" + createId +
                ", createDate=" + createDate +
                ", modifyId=" + modifyId +
                ", modifyDate=" + modifyDate +
                ", verifierId=" + verifierId +
                ", verifierDate=" + verifierDate +
                ", accessCode=" + accessCode +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBuildingUnitEstateId() {
        return buildingUnitEstateId;
    }

    public void setBuildingUnitEstateId(Integer buildingUnitEstateId) {
        this.buildingUnitEstateId = buildingUnitEstateId;
    }

    public Integer getInvitePeopleId() {
        return invitePeopleId;
    }

    public void setInvitePeopleId(Integer invitePeopleId) {
        this.invitePeopleId = invitePeopleId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getIsDrive() {
        return isDrive;
    }

    public void setIsDrive(Integer isDrive) {
        this.isDrive = isDrive;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public Date getExpectedVisitDate() {
        return expectedVisitDate;
    }

    public void setExpectedVisitDate(Date expectedVisitDate) {
        this.expectedVisitDate = expectedVisitDate;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    public Integer getVisitorStatus() {
        return visitorStatus;
    }

    public void setVisitorStatus(Integer visitorStatus) {
        this.visitorStatus = visitorStatus;
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

    public Integer getVerifierId() {
        return verifierId;
    }

    public void setVerifierId(Integer verifierId) {
        this.verifierId = verifierId;
    }

    public Date getVerifierDate() {
        return verifierDate;
    }

    public void setVerifierDate(Date verifierDate) {
        this.verifierDate = verifierDate;
    }

    public Long getAccessCode() {
        return accessCode;
    }

    public void setAccessCode(Long accessCode) {
        this.accessCode = accessCode;
    }

    public UserVisitors() {
    }

    public UserVisitors(Integer id, Integer buildingUnitEstateId, Integer invitePeopleId, Integer type, String name, Integer sex, String tel, Integer isDrive, String carNum, Date expectedVisitDate, Date visitDate, Date departureTime, Date effectiveTime, Integer visitorStatus, Integer createId, Date createDate, Integer modifyId, Date modifyDate, Integer verifierId, Date verifierDate, Long accessCode) {
        this.id = id;
        this.buildingUnitEstateId = buildingUnitEstateId;
        this.invitePeopleId = invitePeopleId;
        this.type = type;
        this.name = name;
        this.sex = sex;
        this.tel = tel;
        this.isDrive = isDrive;
        this.carNum = carNum;
        this.expectedVisitDate = expectedVisitDate;
        this.visitDate = visitDate;
        this.departureTime = departureTime;
        this.effectiveTime = effectiveTime;
        this.visitorStatus = visitorStatus;
        this.createId = createId;
        this.createDate = createDate;
        this.modifyId = modifyId;
        this.modifyDate = modifyDate;
        this.verifierId = verifierId;
        this.verifierDate = verifierDate;
        this.accessCode = accessCode;
    }
}
