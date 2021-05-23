package com.api.vo.butlerService;

import java.util.Date;

/**
 * 设施设备检查计划Vo list 回显
 */
public class VoFacilitiesPlan {
    /**
     * 设施设备检查计划主键id
     */
    private Integer id;
    /**
     * 设施设备检查计划编号
     */
    private String code;
    /**
     * 设施设备名称
     */
    private String facilitiesName;
    /**
     * 检查人姓名
     */
    private String examinerName;
    /**
     * 检查人手机号
     */
    private String examinerTel;
    /**
     * 状态：1.开启，2.停用
     */
    private Integer status;
    /**
     * 计划开始时间
     */
    private Date planBeginDate;
    /**
     * 单次持续时间,单位为分种
     */
    private Integer spaceTime;
    /**
     * 检查频率【类型】类型：1.每天，2.每周，3.每月
     */
    private Integer checkRateType;
    /**
     * 创建人姓名
     */
    private String createName;

    @Override
    public String toString() {
        return "VoFacilitiesPlan{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", facilitiesName='" + facilitiesName + '\'' +
                ", examinerName='" + examinerName + '\'' +
                ", examinerTel='" + examinerTel + '\'' +
                ", status=" + status +
                ", planBeginDate=" + planBeginDate +
                ", spaceTime=" + spaceTime +
                ", checkRateType=" + checkRateType +
                ", createName='" + createName + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFacilitiesName() {
        return facilitiesName;
    }

    public void setFacilitiesName(String facilitiesName) {
        this.facilitiesName = facilitiesName;
    }

    public String getExaminerName() {
        return examinerName;
    }

    public void setExaminerName(String examinerName) {
        this.examinerName = examinerName;
    }

    public String getExaminerTel() {
        return examinerTel;
    }

    public void setExaminerTel(String examinerTel) {
        this.examinerTel = examinerTel;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getPlanBeginDate() {
        return planBeginDate;
    }

    public void setPlanBeginDate(Date planBeginDate) {
        this.planBeginDate = planBeginDate;
    }

    public Integer getSpaceTime() {
        return spaceTime;
    }

    public void setSpaceTime(Integer spaceTime) {
        this.spaceTime = spaceTime;
    }

    public Integer getCheckRateType() {
        return checkRateType;
    }

    public void setCheckRateType(Integer checkRateType) {
        this.checkRateType = checkRateType;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public VoFacilitiesPlan() {
    }

    public VoFacilitiesPlan(Integer id, String code, String facilitiesName, String examinerName, String examinerTel, Integer status, Date planBeginDate, Integer spaceTime, Integer checkRateType, String createName) {
        this.id = id;
        this.code = code;
        this.facilitiesName = facilitiesName;
        this.examinerName = examinerName;
        this.examinerTel = examinerTel;
        this.status = status;
        this.planBeginDate = planBeginDate;
        this.spaceTime = spaceTime;
        this.checkRateType = checkRateType;
        this.createName = createName;
    }
}
