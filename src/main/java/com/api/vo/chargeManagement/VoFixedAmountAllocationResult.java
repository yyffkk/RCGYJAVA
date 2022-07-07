package com.api.vo.chargeManagement;

import com.api.vo.resources.VoResourcesImg;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 固定金额分摊Vo list
 */
public class VoFixedAmountAllocationResult {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 分摊日期
     */
    private Date shareDate;
    /**
     * 楼栋号
     */
    private Integer buildingNo;
    /**
     * 单元号
     */
    private Integer unitNo;
    /**
     * 室号
     */
    private String roomNumber;
    /**
     * 业主名称
     */
    private String name;
    /**
     * 联系方式
     */
    private String tel;
    /**
     * 建筑面积
     */
    private BigDecimal constructionArea;
    /**
     * 费用名称
     */
    private String costName;
    /**
     * 分摊金额
     */
    private BigDecimal sharePrice;
    /**
     * 起始日期
     */
    private Date startDate;
    /**
     * 截止日期
     */
    private Date endDate;
    /**
     * 缴费状态
     */
    private Integer status;
    /**
     * 照片资源集合（缴费凭证）
     */
    private List<VoResourcesImg> imgUrls;

    @Override
    public String toString() {
        return "VoFixedAmountAllocationResult{" +
                "id=" + id +
                ", shareDate=" + shareDate +
                ", buildingNo=" + buildingNo +
                ", unitNo=" + unitNo +
                ", roomNumber='" + roomNumber + '\'' +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", constructionArea=" + constructionArea +
                ", costName='" + costName + '\'' +
                ", sharePrice=" + sharePrice +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", status=" + status +
                ", imgUrls=" + imgUrls +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getShareDate() {
        return shareDate;
    }

    public void setShareDate(Date shareDate) {
        this.shareDate = shareDate;
    }

    public Integer getBuildingNo() {
        return buildingNo;
    }

    public void setBuildingNo(Integer buildingNo) {
        this.buildingNo = buildingNo;
    }

    public Integer getUnitNo() {
        return unitNo;
    }

    public void setUnitNo(Integer unitNo) {
        this.unitNo = unitNo;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public BigDecimal getConstructionArea() {
        return constructionArea;
    }

    public void setConstructionArea(BigDecimal constructionArea) {
        this.constructionArea = constructionArea;
    }

    public String getCostName() {
        return costName;
    }

    public void setCostName(String costName) {
        this.costName = costName;
    }

    public BigDecimal getSharePrice() {
        return sharePrice;
    }

    public void setSharePrice(BigDecimal sharePrice) {
        this.sharePrice = sharePrice;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<VoResourcesImg> getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(List<VoResourcesImg> imgUrls) {
        this.imgUrls = imgUrls;
    }

    public VoFixedAmountAllocationResult() {
    }

    public VoFixedAmountAllocationResult(Integer id, Date shareDate, Integer buildingNo, Integer unitNo, String roomNumber, String name, String tel, BigDecimal constructionArea, String costName, BigDecimal sharePrice, Date startDate, Date endDate, Integer status, List<VoResourcesImg> imgUrls) {
        this.id = id;
        this.shareDate = shareDate;
        this.buildingNo = buildingNo;
        this.unitNo = unitNo;
        this.roomNumber = roomNumber;
        this.name = name;
        this.tel = tel;
        this.constructionArea = constructionArea;
        this.costName = costName;
        this.sharePrice = sharePrice;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.imgUrls = imgUrls;
    }
}
