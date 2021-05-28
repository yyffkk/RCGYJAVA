package com.api.model.app;

import java.util.Date;

/**
 * app新版装修 model信息
 */
public class AppUserDecorationNew {
    /**
     * 新版装修主键id
     */
    private Integer id;
    /**
     * 装修单元房产名称
     */
    private Integer estateId;
    /**
     * 装修状态（1.装修申请中，2.装修通过(装修中)，3.装修驳回，5.申请完工检查，6.检查通过，7.检查不通过）
     */
    private Integer status;
    /**
     * 装修公司名称
     */
    private String constructionUnit;
    /**
     * 装修负责人名称
     */
    private String director;
    /**
     * 装修负责人联系电话
     */
    private String directorTel;
    /**
     * 装修预计开始时间
     */
    private Date expectedBegin;
    /**
     * 装修预计结束时间
     */
    private Date expectedEnd;
    /**
     * 装修实际开始时间
     */
    private Date actualBegin;
    /**
     * 装修实际结束时间
     */
    private Date actualEnd;
    /**
     * 装修通过/驳回原因
     */
    private String rejectReason;
    /**
     * 审核人id
     */
    private Integer reviewer;
    /**
     * 审核时间
     */
    private Date auditDate;
    /**
     * 检查完工人id（物业表）
     */
    private Integer tracker;
    /**
     * 申请完工检查时间
     */
    private Date applicationCheckDate;
    /**
     * 最后一次完工检查是否合格（1.合格，0.不合格）
     */
    private Integer isQualified;
    /**
     * 申请人id
     */
    private Integer createId;
    /**
     * 申请时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "AppUserDecorationNew{" +
                "id=" + id +
                ", estateId=" + estateId +
                ", status=" + status +
                ", constructionUnit='" + constructionUnit + '\'' +
                ", director='" + director + '\'' +
                ", directorTel='" + directorTel + '\'' +
                ", expectedBegin=" + expectedBegin +
                ", expectedEnd=" + expectedEnd +
                ", actualBegin=" + actualBegin +
                ", actualEnd=" + actualEnd +
                ", rejectReason='" + rejectReason + '\'' +
                ", reviewer=" + reviewer +
                ", auditDate=" + auditDate +
                ", tracker=" + tracker +
                ", applicationCheckDate=" + applicationCheckDate +
                ", isQualified=" + isQualified +
                ", createId=" + createId +
                ", createDate=" + createDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEstateId() {
        return estateId;
    }

    public void setEstateId(Integer estateId) {
        this.estateId = estateId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getConstructionUnit() {
        return constructionUnit;
    }

    public void setConstructionUnit(String constructionUnit) {
        this.constructionUnit = constructionUnit;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDirectorTel() {
        return directorTel;
    }

    public void setDirectorTel(String directorTel) {
        this.directorTel = directorTel;
    }

    public Date getExpectedBegin() {
        return expectedBegin;
    }

    public void setExpectedBegin(Date expectedBegin) {
        this.expectedBegin = expectedBegin;
    }

    public Date getExpectedEnd() {
        return expectedEnd;
    }

    public void setExpectedEnd(Date expectedEnd) {
        this.expectedEnd = expectedEnd;
    }

    public Date getActualBegin() {
        return actualBegin;
    }

    public void setActualBegin(Date actualBegin) {
        this.actualBegin = actualBegin;
    }

    public Date getActualEnd() {
        return actualEnd;
    }

    public void setActualEnd(Date actualEnd) {
        this.actualEnd = actualEnd;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    public Integer getReviewer() {
        return reviewer;
    }

    public void setReviewer(Integer reviewer) {
        this.reviewer = reviewer;
    }

    public Date getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

    public Integer getTracker() {
        return tracker;
    }

    public void setTracker(Integer tracker) {
        this.tracker = tracker;
    }

    public Date getApplicationCheckDate() {
        return applicationCheckDate;
    }

    public void setApplicationCheckDate(Date applicationCheckDate) {
        this.applicationCheckDate = applicationCheckDate;
    }

    public Integer getIsQualified() {
        return isQualified;
    }

    public void setIsQualified(Integer isQualified) {
        this.isQualified = isQualified;
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

    public AppUserDecorationNew() {
    }

    public AppUserDecorationNew(Integer id, Integer estateId, Integer status, String constructionUnit, String director, String directorTel, Date expectedBegin, Date expectedEnd, Date actualBegin, Date actualEnd, String rejectReason, Integer reviewer, Date auditDate, Integer tracker, Date applicationCheckDate, Integer isQualified, Integer createId, Date createDate) {
        this.id = id;
        this.estateId = estateId;
        this.status = status;
        this.constructionUnit = constructionUnit;
        this.director = director;
        this.directorTel = directorTel;
        this.expectedBegin = expectedBegin;
        this.expectedEnd = expectedEnd;
        this.actualBegin = actualBegin;
        this.actualEnd = actualEnd;
        this.rejectReason = rejectReason;
        this.reviewer = reviewer;
        this.auditDate = auditDate;
        this.tracker = tracker;
        this.applicationCheckDate = applicationCheckDate;
        this.isQualified = isQualified;
        this.createId = createId;
        this.createDate = createDate;
    }
}
