package com.api.vo.butlerService;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 设施管理 Vo findDetail 回显
 */
public class VoFacilitiesManageDetail {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 设施名称
     */
    private String name;
    /**
     * 设施编号
     */
    private String code;
    /**
     * 设施状态（1.空置中，2.使用中，3.已停用）
     */
    private Integer status;
    /**
     * 设施分类名称
     */
    private String facilitiesCategoryName;
    /**
     * 设施分类
     */
    private Integer facilitiesCategoryId;
    /**
     * 设施品牌
     */
    private String brand;
    /**
     * 采购费用
     */
    private BigDecimal procurementCosts;
    /**
     * 采购厂家
     */
    private String purchasingManufacturer;
    /**
     * 厂家电话
     */
    private String manufacturerPhone;
    /**
     * 质保期限-年
     */
    private Integer warrantyPeriodYears;
    /**
     * 质保期限-月
     */
    private Integer warrantyPeriodMonths;
    /**
     * 设施有效期开始
     */
    private Date validityStart;
    /**
     * 设施有效期结束
     */
    private Date validityEnd;
    /**
     * 上传doc文件路径
     */
    private String fileDocUrl;
    /**
     * 上传doc文件名称
     */
    private String fileDocName;
    /**
     * 备注
     */
    private String remakes;
    /**
     * 创建人名称
     */
    private String createName;
    /**
     * 联系方式
     */
    private String tel;
    /**
     * 设施地址
     */
    private String address;
    /**
     * 创建时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "VoFacilitiesManageDetail{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", status=" + status +
                ", facilitiesCategoryName='" + facilitiesCategoryName + '\'' +
                ", facilitiesCategoryId=" + facilitiesCategoryId +
                ", brand='" + brand + '\'' +
                ", procurementCosts=" + procurementCosts +
                ", purchasingManufacturer='" + purchasingManufacturer + '\'' +
                ", manufacturerPhone='" + manufacturerPhone + '\'' +
                ", warrantyPeriodYears=" + warrantyPeriodYears +
                ", warrantyPeriodMonths=" + warrantyPeriodMonths +
                ", validityStart=" + validityStart +
                ", validityEnd=" + validityEnd +
                ", fileDocUrl='" + fileDocUrl + '\'' +
                ", fileDocName='" + fileDocName + '\'' +
                ", remakes='" + remakes + '\'' +
                ", createName='" + createName + '\'' +
                ", tel='" + tel + '\'' +
                ", address='" + address + '\'' +
                ", createDate=" + createDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getFacilitiesCategoryName() {
        return facilitiesCategoryName;
    }

    public void setFacilitiesCategoryName(String facilitiesCategoryName) {
        this.facilitiesCategoryName = facilitiesCategoryName;
    }

    public Integer getFacilitiesCategoryId() {
        return facilitiesCategoryId;
    }

    public void setFacilitiesCategoryId(Integer facilitiesCategoryId) {
        this.facilitiesCategoryId = facilitiesCategoryId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public BigDecimal getProcurementCosts() {
        return procurementCosts;
    }

    public void setProcurementCosts(BigDecimal procurementCosts) {
        this.procurementCosts = procurementCosts;
    }

    public String getPurchasingManufacturer() {
        return purchasingManufacturer;
    }

    public void setPurchasingManufacturer(String purchasingManufacturer) {
        this.purchasingManufacturer = purchasingManufacturer;
    }

    public String getManufacturerPhone() {
        return manufacturerPhone;
    }

    public void setManufacturerPhone(String manufacturerPhone) {
        this.manufacturerPhone = manufacturerPhone;
    }

    public Integer getWarrantyPeriodYears() {
        return warrantyPeriodYears;
    }

    public void setWarrantyPeriodYears(Integer warrantyPeriodYears) {
        this.warrantyPeriodYears = warrantyPeriodYears;
    }

    public Integer getWarrantyPeriodMonths() {
        return warrantyPeriodMonths;
    }

    public void setWarrantyPeriodMonths(Integer warrantyPeriodMonths) {
        this.warrantyPeriodMonths = warrantyPeriodMonths;
    }

    public Date getValidityStart() {
        return validityStart;
    }

    public void setValidityStart(Date validityStart) {
        this.validityStart = validityStart;
    }

    public Date getValidityEnd() {
        return validityEnd;
    }

    public void setValidityEnd(Date validityEnd) {
        this.validityEnd = validityEnd;
    }

    public String getFileDocUrl() {
        return fileDocUrl;
    }

    public void setFileDocUrl(String fileDocUrl) {
        this.fileDocUrl = fileDocUrl;
    }

    public String getFileDocName() {
        return fileDocName;
    }

    public void setFileDocName(String fileDocName) {
        this.fileDocName = fileDocName;
    }

    public String getRemakes() {
        return remakes;
    }

    public void setRemakes(String remakes) {
        this.remakes = remakes;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public VoFacilitiesManageDetail() {
    }

    public VoFacilitiesManageDetail(Integer id, String name, String code, Integer status, String facilitiesCategoryName, Integer facilitiesCategoryId, String brand, BigDecimal procurementCosts, String purchasingManufacturer, String manufacturerPhone, Integer warrantyPeriodYears, Integer warrantyPeriodMonths, Date validityStart, Date validityEnd, String fileDocUrl, String fileDocName, String remakes, String createName, String tel, String address, Date createDate) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.status = status;
        this.facilitiesCategoryName = facilitiesCategoryName;
        this.facilitiesCategoryId = facilitiesCategoryId;
        this.brand = brand;
        this.procurementCosts = procurementCosts;
        this.purchasingManufacturer = purchasingManufacturer;
        this.manufacturerPhone = manufacturerPhone;
        this.warrantyPeriodYears = warrantyPeriodYears;
        this.warrantyPeriodMonths = warrantyPeriodMonths;
        this.validityStart = validityStart;
        this.validityEnd = validityEnd;
        this.fileDocUrl = fileDocUrl;
        this.fileDocName = fileDocName;
        this.remakes = remakes;
        this.createName = createName;
        this.tel = tel;
        this.address = address;
        this.createDate = createDate;
    }
}
