package com.aku.model.butlerService;

import java.util.Date;

/**
 * 物品出门表
 */
public class UserArticleOut {
    private Integer id;
    private Integer residentId;
    private Integer buildingUnitEstateId;
    private String name;
    private Integer weight;
    private Integer approach;
    private Date expectedTime;
    private Date actualTime;
    private Integer export;
    private Integer status;
    private String remarks;
    private Integer applicantId;
    private Date applicantDate;
    private Integer reviewId;
    private Date reviewDate;

    @Override
    public String toString() {
        return "UserArticleOut{" +
                "id=" + id +
                ", residentId=" + residentId +
                ", buildingUnitEstateId=" + buildingUnitEstateId +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", approach=" + approach +
                ", expectedTime=" + expectedTime +
                ", actualTime=" + actualTime +
                ", export=" + export +
                ", status=" + status +
                ", remarks='" + remarks + '\'' +
                ", applicantId=" + applicantId +
                ", applicantDate=" + applicantDate +
                ", reviewId=" + reviewId +
                ", reviewDate=" + reviewDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getResidentId() {
        return residentId;
    }

    public void setResidentId(Integer residentId) {
        this.residentId = residentId;
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

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getApproach() {
        return approach;
    }

    public void setApproach(Integer approach) {
        this.approach = approach;
    }

    public Date getExpectedTime() {
        return expectedTime;
    }

    public void setExpectedTime(Date expectedTime) {
        this.expectedTime = expectedTime;
    }

    public Date getActualTime() {
        return actualTime;
    }

    public void setActualTime(Date actualTime) {
        this.actualTime = actualTime;
    }

    public Integer getExport() {
        return export;
    }

    public void setExport(Integer export) {
        this.export = export;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Integer applicantId) {
        this.applicantId = applicantId;
    }

    public Date getApplicantDate() {
        return applicantDate;
    }

    public void setApplicantDate(Date applicantDate) {
        this.applicantDate = applicantDate;
    }

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    public UserArticleOut() {
    }

    public UserArticleOut(Integer id, Integer residentId, Integer buildingUnitEstateId, String name, Integer weight, Integer approach, Date expectedTime, Date actualTime, Integer export, Integer status, String remarks, Integer applicantId, Date applicantDate, Integer reviewId, Date reviewDate) {
        this.id = id;
        this.residentId = residentId;
        this.buildingUnitEstateId = buildingUnitEstateId;
        this.name = name;
        this.weight = weight;
        this.approach = approach;
        this.expectedTime = expectedTime;
        this.actualTime = actualTime;
        this.export = export;
        this.status = status;
        this.remarks = remarks;
        this.applicantId = applicantId;
        this.applicantDate = applicantDate;
        this.reviewId = reviewId;
        this.reviewDate = reviewDate;
    }
}
