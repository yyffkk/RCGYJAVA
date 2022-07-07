package com.api.model.chargeManagement;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 押金管理信息model
 */
public class SysDepositManagement {
    /**
     * 押金管理主键id
     */
    private Integer id;
    /**
     * 装修id
     */
    private Integer userDecorationId;
    /**
     * 费用名称类型(取自 物业收费标准明细表)
     */
    private Integer chargesTemplateDetailId;
    /**
     * 房产id
     */
    private Integer buildingUnitEstateId;
    /**
     * 押金人id
     */
    private Integer residentId;
    /**
     * 押金人联系方式
     */
    private String tel;
    /**
     * 缴费时间
     */
    private Date payDate;
    /**
     * 押金金额
     */
    private BigDecimal depositPrice;
    /**
     * 押金状态（初始为1.未退）
     */
    private Integer status;
    /**
     * 来源：1.app，2.线下
     */
    private Integer froms;
    /**
     * 支付方式：1.app支付宝，2.app微信，3.现金，4.线下支付宝，5.线下微信
     */
    private Integer payType;
    /**
     * 装修开始时间
     */
    private Date renovationDateStart;
    /**
     * 装修结束时间
     */
    private Date renovationDateEnd;
    /**
     * 备注
     */
    private String remake;
    /**
     * 创建人（app为-1,显示为押金人姓名）
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 修改人
     */
    private Integer modifyId;
    /**
     * 修改时间
     */
    private Date modifyDate;
    /**
     * 是否删除，0.删除，1.非删
     */
    private Integer isDelete;

    @Override
    public String toString() {
        return "SysDepositManagement{" +
                "id=" + id +
                ", userDecorationId=" + userDecorationId +
                ", chargesTemplateDetailId=" + chargesTemplateDetailId +
                ", buildingUnitEstateId=" + buildingUnitEstateId +
                ", residentId=" + residentId +
                ", tel='" + tel + '\'' +
                ", payDate=" + payDate +
                ", depositPrice=" + depositPrice +
                ", status=" + status +
                ", froms=" + froms +
                ", payType=" + payType +
                ", renovationDateStart=" + renovationDateStart +
                ", renovationDateEnd=" + renovationDateEnd +
                ", remake='" + remake + '\'' +
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

    public Integer getUserDecorationId() {
        return userDecorationId;
    }

    public void setUserDecorationId(Integer userDecorationId) {
        this.userDecorationId = userDecorationId;
    }

    public Integer getChargesTemplateDetailId() {
        return chargesTemplateDetailId;
    }

    public void setChargesTemplateDetailId(Integer chargesTemplateDetailId) {
        this.chargesTemplateDetailId = chargesTemplateDetailId;
    }

    public Integer getBuildingUnitEstateId() {
        return buildingUnitEstateId;
    }

    public void setBuildingUnitEstateId(Integer buildingUnitEstateId) {
        this.buildingUnitEstateId = buildingUnitEstateId;
    }

    public Integer getResidentId() {
        return residentId;
    }

    public void setResidentId(Integer residentId) {
        this.residentId = residentId;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public BigDecimal getDepositPrice() {
        return depositPrice;
    }

    public void setDepositPrice(BigDecimal depositPrice) {
        this.depositPrice = depositPrice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getFroms() {
        return froms;
    }

    public void setFroms(Integer froms) {
        this.froms = froms;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Date getRenovationDateStart() {
        return renovationDateStart;
    }

    public void setRenovationDateStart(Date renovationDateStart) {
        this.renovationDateStart = renovationDateStart;
    }

    public Date getRenovationDateEnd() {
        return renovationDateEnd;
    }

    public void setRenovationDateEnd(Date renovationDateEnd) {
        this.renovationDateEnd = renovationDateEnd;
    }

    public String getRemake() {
        return remake;
    }

    public void setRemake(String remake) {
        this.remake = remake;
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

    public SysDepositManagement() {
    }

    public SysDepositManagement(Integer id, Integer userDecorationId, Integer chargesTemplateDetailId, Integer buildingUnitEstateId, Integer residentId, String tel, Date payDate, BigDecimal depositPrice, Integer status, Integer froms, Integer payType, Date renovationDateStart, Date renovationDateEnd, String remake, Integer createId, Date createDate, Integer modifyId, Date modifyDate, Integer isDelete) {
        this.id = id;
        this.userDecorationId = userDecorationId;
        this.chargesTemplateDetailId = chargesTemplateDetailId;
        this.buildingUnitEstateId = buildingUnitEstateId;
        this.residentId = residentId;
        this.tel = tel;
        this.payDate = payDate;
        this.depositPrice = depositPrice;
        this.status = status;
        this.froms = froms;
        this.payType = payType;
        this.renovationDateStart = renovationDateStart;
        this.renovationDateEnd = renovationDateEnd;
        this.remake = remake;
        this.createId = createId;
        this.createDate = createDate;
        this.modifyId = modifyId;
        this.modifyDate = modifyDate;
        this.isDelete = isDelete;
    }
}
