package com.api.vo.app;

import java.util.Date;

/**
 * app访客通行信息Vo  FindById 回显
 */
public class VisitorAccessFindByIdVo {
    /**
     * 访客主键id
     */
    private Integer id;
    /**
     * 通行证认证码
     */
    private Long accessCode;
    /**
     * 访问单元房产id
     */
    private Integer buildingUnitEstateId;
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
     * 是否开车（1.开车，0.不开车）
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
     * 有效时间
     */
    private Date effectiveTime;
    /**
     * 访客状态(1.未到，2.已到,3.已过期，4.作废)
     */
    private Integer visitorStatus;

    @Override
    public String toString() {
        return "VisitorAccessFindByIdVo{" +
                "id=" + id +
                ", accessCode=" + accessCode +
                ", buildingUnitEstateId=" + buildingUnitEstateId +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", tel='" + tel + '\'' +
                ", isDrive=" + isDrive +
                ", carNum='" + carNum + '\'' +
                ", expectedVisitDate=" + expectedVisitDate +
                ", effectiveTime=" + effectiveTime +
                ", visitorStatus=" + visitorStatus +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getAccessCode() {
        return accessCode;
    }

    public void setAccessCode(Long accessCode) {
        this.accessCode = accessCode;
    }

    public Integer getBuildingUnitEstateId() {
        return buildingUnitEstateId;
    }

    public void setBuildingUnitEstateId(Integer buildingUnitEstateId) {
        this.buildingUnitEstateId = buildingUnitEstateId;
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

    public VisitorAccessFindByIdVo() {
    }

    public VisitorAccessFindByIdVo(Integer id, Long accessCode, Integer buildingUnitEstateId, String name, Integer sex, String tel, Integer isDrive, String carNum, Date expectedVisitDate, Date effectiveTime, Integer visitorStatus) {
        this.id = id;
        this.accessCode = accessCode;
        this.buildingUnitEstateId = buildingUnitEstateId;
        this.name = name;
        this.sex = sex;
        this.tel = tel;
        this.isDrive = isDrive;
        this.carNum = carNum;
        this.expectedVisitDate = expectedVisitDate;
        this.effectiveTime = effectiveTime;
        this.visitorStatus = visitorStatus;
    }
}
