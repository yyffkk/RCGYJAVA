package com.api.model.my;

import java.util.Date;
/**
 * 房产认证model
 */
public class MyHouse {
    /**
     * 住户id
     */
    private Integer residentId;
    /**
     * 房产id
     */
    private Integer estateId;
    /**
     * 姓名
     */
    private String name;
    /**
     * 住户类型（1审核业主，2审核亲属，3审核租客）
     */
    private Integer type;
    /**
     * 证件类型（1身份证，2营业执照，3.军人证）
     */
    private Integer idType;
    /**
     * 证件号码
     */
    private String idNumber;
    /**
     * 审核状态（1.未审核，3.审核失败，4.审核成功）
     */
    private Integer status;
    /**
     * 有效时间开始（只限租客）
     */
    private Date effectiveTimeStart;
    /**
     * 有效时间结束（只限租客）
     */
    private Date effectiveTimeEnd;
    /**
     * 审核人id(物业表，系统自动审核成功为-1)
     */
    private Integer reviewer;
    /**
     * 审核时间
     */
    private Date reviewerDate;
    /**
     * 是否删除，1.非删 0.删除
     */
    private Integer isDelete;
    /**
     * 创建时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "MyHouse{" +
                "residentId=" + residentId +
                ", estateId=" + estateId +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", idType=" + idType +
                ", idNumber='" + idNumber + '\'' +
                ", status=" + status +
                ", effectiveTimeStart=" + effectiveTimeStart +
                ", effectiveTimeEnd=" + effectiveTimeEnd +
                ", reviewer=" + reviewer +
                ", reviewerDate=" + reviewerDate +
                ", isDelete=" + isDelete +
                ", createDate=" + createDate +
                '}';
    }

    public Integer getResidentId() {
        return residentId;
    }

    public void setResidentId(Integer residentId) {
        this.residentId = residentId;
    }

    public Integer getEstateId() {
        return estateId;
    }

    public void setEstateId(Integer estateId) {
        this.estateId = estateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getEffectiveTimeStart() {
        return effectiveTimeStart;
    }

    public void setEffectiveTimeStart(Date effectiveTimeStart) {
        this.effectiveTimeStart = effectiveTimeStart;
    }

    public Date getEffectiveTimeEnd() {
        return effectiveTimeEnd;
    }

    public void setEffectiveTimeEnd(Date effectiveTimeEnd) {
        this.effectiveTimeEnd = effectiveTimeEnd;
    }

    public Integer getReviewer() {
        return reviewer;
    }

    public void setReviewer(Integer reviewer) {
        this.reviewer = reviewer;
    }

    public Date getReviewerDate() {
        return reviewerDate;
    }

    public void setReviewerDate(Date reviewerDate) {
        this.reviewerDate = reviewerDate;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public MyHouse() {
    }

    public MyHouse(Integer residentId, Integer estateId, String name, Integer type, Integer idType, String idNumber, Integer status, Date effectiveTimeStart, Date effectiveTimeEnd, Integer reviewer, Date reviewerDate, Integer isDelete, Date createDate) {
        this.residentId = residentId;
        this.estateId = estateId;
        this.name = name;
        this.type = type;
        this.idType = idType;
        this.idNumber = idNumber;
        this.status = status;
        this.effectiveTimeStart = effectiveTimeStart;
        this.effectiveTimeEnd = effectiveTimeEnd;
        this.reviewer = reviewer;
        this.reviewerDate = reviewerDate;
        this.isDelete = isDelete;
        this.createDate = createDate;
    }
}
