package com.api.model.butlerApp;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

/**
 * 管家app 处理完成结果详情
 */
public class ButlerHandleCompleteDetail {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 派工单id
     */
    private Integer dispatchListId;
    /**
     * 处理完成情况
     */
    private String detail;
    /**
     * 更换材料清单（含辅材）
     */
    private String materialList;
    /**
     * 人工费
     */
    private BigDecimal laborCost;
    /**
     * 材料费
     */
    private BigDecimal materialCost;
    /**
     * 总计费
     */
    private BigDecimal totalCost;
    /**
     * 报修结果（1.完成，0.未完成）
     */
    private Integer repairResult;
    /**
     * 完成时间
     */
    private Date completeDate;
    /**
     * 创建人
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 照片上传路径数组
     */
    private String[] fileUrls;

    @Override
    public String toString() {
        return "ButlerHandleCompleteDetail{" +
                "id=" + id +
                ", dispatchListId=" + dispatchListId +
                ", detail='" + detail + '\'' +
                ", materialList='" + materialList + '\'' +
                ", laborCost=" + laborCost +
                ", materialCost=" + materialCost +
                ", totalCost=" + totalCost +
                ", repairResult=" + repairResult +
                ", completeDate=" + completeDate +
                ", createId=" + createId +
                ", createDate=" + createDate +
                ", fileUrls=" + Arrays.toString(fileUrls) +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDispatchListId() {
        return dispatchListId;
    }

    public void setDispatchListId(Integer dispatchListId) {
        this.dispatchListId = dispatchListId;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getMaterialList() {
        return materialList;
    }

    public void setMaterialList(String materialList) {
        this.materialList = materialList;
    }

    public BigDecimal getLaborCost() {
        return laborCost;
    }

    public void setLaborCost(BigDecimal laborCost) {
        this.laborCost = laborCost;
    }

    public BigDecimal getMaterialCost() {
        return materialCost;
    }

    public void setMaterialCost(BigDecimal materialCost) {
        this.materialCost = materialCost;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public Integer getRepairResult() {
        return repairResult;
    }

    public void setRepairResult(Integer repairResult) {
        this.repairResult = repairResult;
    }

    public Date getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(Date completeDate) {
        this.completeDate = completeDate;
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

    public String[] getFileUrls() {
        return fileUrls;
    }

    public void setFileUrls(String[] fileUrls) {
        this.fileUrls = fileUrls;
    }

    public ButlerHandleCompleteDetail() {
    }

    public ButlerHandleCompleteDetail(Integer id, Integer dispatchListId, String detail, String materialList, BigDecimal laborCost, BigDecimal materialCost, BigDecimal totalCost, Integer repairResult, Date completeDate, Integer createId, Date createDate, String[] fileUrls) {
        this.id = id;
        this.dispatchListId = dispatchListId;
        this.detail = detail;
        this.materialList = materialList;
        this.laborCost = laborCost;
        this.materialCost = materialCost;
        this.totalCost = totalCost;
        this.repairResult = repairResult;
        this.completeDate = completeDate;
        this.createId = createId;
        this.createDate = createDate;
        this.fileUrls = fileUrls;
    }
}
