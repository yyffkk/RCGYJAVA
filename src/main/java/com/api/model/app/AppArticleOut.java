package com.api.model.app;

import java.util.Arrays;
import java.util.Date;

/**
 * app 物品出户
 */
public class AppArticleOut {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 业主id
     */
    private Integer residentId;
    /**
     * 房产id
     */
    private Integer buildingUnitEstateId;
    /**
     * 物品名称
     */
    private String name;
    /**
     * 重量(1. <50kg , 2. 50kg-100kg , 3. >100kg)
     */
    private Integer weight;
    /**
     * 搬运方式（1.自己搬运，2.搬家公司）
     */
    private Integer approach;
    /**
     * 搬家公司手机号
     */
    private String movingCompanyTel;
    /**
     * 预计出门时间
     */
    private Date expectedTime;
    /**
     * 实际出门时间
     */
    private Date actualTime;
    /**
     * 出口
     */
    private Integer export;
    /**
     * 状态(1.待出门，2.已出门，3.驳回申请)
     */
    private Integer status;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 申请人（用户业主表）
     */
    private Integer applicantId;
    /**
     * 申请时间
     */
    private Date applicantDate;
    /**
     * 审核人（系统用户表）
     */
    private Integer reviewId;
    /**
     * 审核时间
     */
    private Date reviewDate;
    /**
     * 照片资源路径数组
     */
    private String[] imgUrls;

    @Override
    public String toString() {
        return "AppArticleOut{" +
                "id=" + id +
                ", residentId=" + residentId +
                ", buildingUnitEstateId=" + buildingUnitEstateId +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", approach=" + approach +
                ", movingCompanyTel='" + movingCompanyTel + '\'' +
                ", expectedTime=" + expectedTime +
                ", actualTime=" + actualTime +
                ", export=" + export +
                ", status=" + status +
                ", remarks='" + remarks + '\'' +
                ", applicantId=" + applicantId +
                ", applicantDate=" + applicantDate +
                ", reviewId=" + reviewId +
                ", reviewDate=" + reviewDate +
                ", imgUrls=" + Arrays.toString(imgUrls) +
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

    public String getMovingCompanyTel() {
        return movingCompanyTel;
    }

    public void setMovingCompanyTel(String movingCompanyTel) {
        this.movingCompanyTel = movingCompanyTel;
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

    public String[] getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(String[] imgUrls) {
        this.imgUrls = imgUrls;
    }

    public AppArticleOut() {
    }

    public AppArticleOut(Integer id, Integer residentId, Integer buildingUnitEstateId, String name, Integer weight, Integer approach, String movingCompanyTel, Date expectedTime, Date actualTime, Integer export, Integer status, String remarks, Integer applicantId, Date applicantDate, Integer reviewId, Date reviewDate, String[] imgUrls) {
        this.id = id;
        this.residentId = residentId;
        this.buildingUnitEstateId = buildingUnitEstateId;
        this.name = name;
        this.weight = weight;
        this.approach = approach;
        this.movingCompanyTel = movingCompanyTel;
        this.expectedTime = expectedTime;
        this.actualTime = actualTime;
        this.export = export;
        this.status = status;
        this.remarks = remarks;
        this.applicantId = applicantId;
        this.applicantDate = applicantDate;
        this.reviewId = reviewId;
        this.reviewDate = reviewDate;
        this.imgUrls = imgUrls;
    }
}
