package com.api.vo.butlerApp;

import java.util.Date;
import java.util.List;

/**
 * 管家app 新版装修管理Vo list 回显
 */
public class ButlerUserDecorationNewVo {
    /**
     * 新版装修主键id
     */
    private Integer id;
    /**
     * 装修单元房产名称
     */
    private String roomName;
    /**
     * 装修状态（1.装修申请中，2.装修通过，3.装修驳回，4.装修中，5.申请完工检查，6.检查通过，7.检查不通过）
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
     * 审核人名称
     */
    private String reviewerName;
    /**
     * 审核时间
     */
    private Date auditDate;
    /**
     * 检查完工人名称（物业表）
     */
    private String trackerName;
    /**
     * 最后一次完工检查是否合格（1.合格，0.不合格）
     */
    private Integer isQualified;
    /**
     * 申请人名称
     */
    private String createName;
    /**
     * 申请时间
     */
    private Date createDate;
    /**
     * 管家app 新版装修管理-完工检查记录Vo list 回显
     */
    private List<ButlerUserDecorationNewCheckVo> checkVoList;

    @Override
    public String toString() {
        return "ButlerUserDecorationNewVo{" +
                "id=" + id +
                ", roomName='" + roomName + '\'' +
                ", status=" + status +
                ", constructionUnit='" + constructionUnit + '\'' +
                ", director='" + director + '\'' +
                ", directorTel='" + directorTel + '\'' +
                ", expectedBegin=" + expectedBegin +
                ", expectedEnd=" + expectedEnd +
                ", actualBegin=" + actualBegin +
                ", actualEnd=" + actualEnd +
                ", rejectReason='" + rejectReason + '\'' +
                ", reviewerName='" + reviewerName + '\'' +
                ", auditDate=" + auditDate +
                ", trackerName='" + trackerName + '\'' +
                ", isQualified=" + isQualified +
                ", createName='" + createName + '\'' +
                ", createDate=" + createDate +
                ", checkVoList=" + checkVoList +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
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

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }

    public Date getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

    public String getTrackerName() {
        return trackerName;
    }

    public void setTrackerName(String trackerName) {
        this.trackerName = trackerName;
    }

    public Integer getIsQualified() {
        return isQualified;
    }

    public void setIsQualified(Integer isQualified) {
        this.isQualified = isQualified;
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

    public List<ButlerUserDecorationNewCheckVo> getCheckVoList() {
        return checkVoList;
    }

    public void setCheckVoList(List<ButlerUserDecorationNewCheckVo> checkVoList) {
        this.checkVoList = checkVoList;
    }

    public ButlerUserDecorationNewVo() {
    }

    public ButlerUserDecorationNewVo(Integer id, String roomName, Integer status, String constructionUnit, String director, String directorTel, Date expectedBegin, Date expectedEnd, Date actualBegin, Date actualEnd, String rejectReason, String reviewerName, Date auditDate, String trackerName, Integer isQualified, String createName, Date createDate, List<ButlerUserDecorationNewCheckVo> checkVoList) {
        this.id = id;
        this.roomName = roomName;
        this.status = status;
        this.constructionUnit = constructionUnit;
        this.director = director;
        this.directorTel = directorTel;
        this.expectedBegin = expectedBegin;
        this.expectedEnd = expectedEnd;
        this.actualBegin = actualBegin;
        this.actualEnd = actualEnd;
        this.rejectReason = rejectReason;
        this.reviewerName = reviewerName;
        this.auditDate = auditDate;
        this.trackerName = trackerName;
        this.isQualified = isQualified;
        this.createName = createName;
        this.createDate = createDate;
        this.checkVoList = checkVoList;
    }
}
