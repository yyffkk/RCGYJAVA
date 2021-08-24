package com.api.vo.butlerService;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 设施管理 Vo list 回显
 */
public class VoFacilitiesManage {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 设施编号
     */
    private String code;
    /**
     * 设施分类名称
     */
    private String facilitiesCategoryName;
    /**
     * 设施名称
     */
    private String name;
    /**
     * 添加人
     */
    private String createName;
    /**
     * 设施状态（1.空置中，2.使用中，3.已停用）
     */
    private Integer status;
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
    private Date validity_start;
    /**
     * 设施有效期结束
     */
    private Date validity_end;
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
     * 添加时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "VoFacilitiesManage{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", facilitiesCategoryName='" + facilitiesCategoryName + '\'' +
                ", name='" + name + '\'' +
                ", createName='" + createName + '\'' +
                ", status=" + status +
                ", brand='" + brand + '\'' +
                ", procurementCosts=" + procurementCosts +
                ", purchasingManufacturer='" + purchasingManufacturer + '\'' +
                ", manufacturerPhone='" + manufacturerPhone + '\'' +
                ", warrantyPeriodYears=" + warrantyPeriodYears +
                ", warrantyPeriodMonths=" + warrantyPeriodMonths +
                ", validity_start=" + validity_start +
                ", validity_end=" + validity_end +
                ", fileDocUrl='" + fileDocUrl + '\'' +
                ", fileDocName='" + fileDocName + '\'' +
                ", remakes='" + remakes + '\'' +
                ", createDate=" + createDate +
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

    public String getFacilitiesCategoryName() {
        return facilitiesCategoryName;
    }

    public void setFacilitiesCategoryName(String facilitiesCategoryName) {
        this.facilitiesCategoryName = facilitiesCategoryName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Date getValidity_start() {
        return validity_start;
    }

    public void setValidity_start(Date validity_start) {
        this.validity_start = validity_start;
    }

    public Date getValidity_end() {
        return validity_end;
    }

    public void setValidity_end(Date validity_end) {
        this.validity_end = validity_end;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public VoFacilitiesManage() {
    }

    public VoFacilitiesManage(Integer id, String code, String facilitiesCategoryName, String name, String createName, Integer status, String brand, BigDecimal procurementCosts, String purchasingManufacturer, String manufacturerPhone, Integer warrantyPeriodYears, Integer warrantyPeriodMonths, Date validity_start, Date validity_end, String fileDocUrl, String fileDocName, String remakes, Date createDate) {
        this.id = id;
        this.code = code;
        this.facilitiesCategoryName = facilitiesCategoryName;
        this.name = name;
        this.createName = createName;
        this.status = status;
        this.brand = brand;
        this.procurementCosts = procurementCosts;
        this.purchasingManufacturer = purchasingManufacturer;
        this.manufacturerPhone = manufacturerPhone;
        this.warrantyPeriodYears = warrantyPeriodYears;
        this.warrantyPeriodMonths = warrantyPeriodMonths;
        this.validity_start = validity_start;
        this.validity_end = validity_end;
        this.fileDocUrl = fileDocUrl;
        this.fileDocName = fileDocName;
        this.remakes = remakes;
        this.createDate = createDate;
    }
}
