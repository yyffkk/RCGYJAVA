package com.api.model.butlerService;

import java.util.Date;

/**
 * 设施/设备检查计划model
 */
public class FacilitiesPlan {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 设施/设备计划编号
     */
    private String code;
    /**
     * 设施/设备管理主键id
     */
    private Integer facilitiesManageId;
    /**
     * 检查人id
     */
    private Integer examiner;
    /**
     * 状态：1.开启，2.关闭
     */
    private Integer status;
    /**
     * 计划开始时间
     */
    private Date planBeginDate;
    /**
     * 持续时间,单位为分种
     */
    private Integer spaceTime;
    /**
     * 检查频率【类型】类型：1.每天，2.每周，3.每月
     */
    private Integer checkRateType;
    /**
     * 创建人id
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 是否删除:1.非删，2.删除
     */
    private Integer isDelete;

    @Override
    public String toString() {
        return "FacilitiesPlan{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", facilitiesManageId=" + facilitiesManageId +
                ", examiner=" + examiner +
                ", status=" + status +
                ", planBeginDate=" + planBeginDate +
                ", spaceTime=" + spaceTime +
                ", checkRateType=" + checkRateType +
                ", createId=" + createId +
                ", createDate=" + createDate +
                ", isDelete=" + isDelete +
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

    public Integer getFacilitiesManageId() {
        return facilitiesManageId;
    }

    public void setFacilitiesManageId(Integer facilitiesManageId) {
        this.facilitiesManageId = facilitiesManageId;
    }

    public Integer getExaminer() {
        return examiner;
    }

    public void setExaminer(Integer examiner) {
        this.examiner = examiner;
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

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public FacilitiesPlan() {
    }

    public FacilitiesPlan(Integer id, String code, Integer facilitiesManageId, Integer examiner, Integer status, Date planBeginDate, Integer spaceTime, Integer checkRateType, Integer createId, Date createDate, Integer isDelete) {
        this.id = id;
        this.code = code;
        this.facilitiesManageId = facilitiesManageId;
        this.examiner = examiner;
        this.status = status;
        this.planBeginDate = planBeginDate;
        this.spaceTime = spaceTime;
        this.checkRateType = checkRateType;
        this.createId = createId;
        this.createDate = createDate;
        this.isDelete = isDelete;
    }
}
