package com.api.model.butlerService;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 设施管理信息model
 */
public class FacilitiesManage {
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 设施编号
     */
    private String code;
    /**
     * 设施名称
     */
    private String name;
    /**
     * 设施地址
     */
    private String address;
    /**
     * 设施分类主键id
     */
    private Integer facilitiesCategoryId;
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
     * 创建人id
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 修改人id
     */
    private Integer modifyId;
    /**
     * 修改时间
     */
    private Date modifyDate;
    /**
     * 是否删除，1.非删 0.删除
     */
    private Integer isDelete;

    @Override
    public String toString() {
        return "FacilitiesManage{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", facilitiesCategoryId=" + facilitiesCategoryId +
                ", status=" + status +
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
                ", createId=" + createId +
                ", createDate=" + createDate +
                ", modifyId=" + modifyId +
                ", modifyDate=" + modifyDate +
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getFacilitiesCategoryId() {
        return facilitiesCategoryId;
    }

    public void setFacilitiesCategoryId(Integer facilitiesCategoryId) {
        this.facilitiesCategoryId = facilitiesCategoryId;
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

    public Integer getModifyId() {
        return modifyId;
    }

    public void setModifyId(Integer modifyId) {
        this.modifyId = modifyId;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public FacilitiesManage() {
    }

    public FacilitiesManage(Integer id, String code, String name, String address, Integer facilitiesCategoryId, Integer status, String brand, BigDecimal procurementCosts, String purchasingManufacturer, String manufacturerPhone, Integer warrantyPeriodYears, Integer warrantyPeriodMonths, Date validityStart, Date validityEnd, String fileDocUrl, String fileDocName, String remakes, Integer createId, Date createDate, Integer modifyId, Date modifyDate, Integer isDelete) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.address = address;
        this.facilitiesCategoryId = facilitiesCategoryId;
        this.status = status;
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
        this.createId = createId;
        this.createDate = createDate;
        this.modifyId = modifyId;
        this.modifyDate = modifyDate;
        this.isDelete = isDelete;
    }
}
