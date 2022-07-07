package com.api.vo.chargeManagement;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 押金管理Vo findById 回显
 */
public class VoFindByIdDepositManagement {
    /**
     * 押金管理主键id
     */
    private Integer id;
    /**
     * 费用名称类型(取自 物业收费标准明细表)
     */
    private Integer chargesTemplateDetailId;
    /**
     * 房间号id
     */
    private Integer buildingId;
    /**
     * 单元号id
     */
    private Integer unitId;
    /**
     * 楼栋编号id(房产id)
     */
    private Integer estateId;
    /**
     * 押金人姓名
     */
    private String residentName;
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

    @Override
    public String toString() {
        return "VoFindByIdDepositManagement{" +
                "id=" + id +
                ", chargesTemplateDetailId=" + chargesTemplateDetailId +
                ", buildingId=" + buildingId +
                ", unitId=" + unitId +
                ", estateId=" + estateId +
                ", residentName='" + residentName + '\'' +
                ", residentId=" + residentId +
                ", tel='" + tel + '\'' +
                ", payDate=" + payDate +
                ", depositPrice=" + depositPrice +
                ", froms=" + froms +
                ", payType=" + payType +
                ", renovationDateStart=" + renovationDateStart +
                ", renovationDateEnd=" + renovationDateEnd +
                ", remake='" + remake + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getChargesTemplateDetailId() {
        return chargesTemplateDetailId;
    }

    public void setChargesTemplateDetailId(Integer chargesTemplateDetailId) {
        this.chargesTemplateDetailId = chargesTemplateDetailId;
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public Integer getEstateId() {
        return estateId;
    }

    public void setEstateId(Integer estateId) {
        this.estateId = estateId;
    }

    public String getResidentName() {
        return residentName;
    }

    public void setResidentName(String residentName) {
        this.residentName = residentName;
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

    public VoFindByIdDepositManagement() {
    }

    public VoFindByIdDepositManagement(Integer id, Integer chargesTemplateDetailId, Integer buildingId, Integer unitId, Integer estateId, String residentName, Integer residentId, String tel, Date payDate, BigDecimal depositPrice, Integer froms, Integer payType, Date renovationDateStart, Date renovationDateEnd, String remake) {
        this.id = id;
        this.chargesTemplateDetailId = chargesTemplateDetailId;
        this.buildingId = buildingId;
        this.unitId = unitId;
        this.estateId = estateId;
        this.residentName = residentName;
        this.residentId = residentId;
        this.tel = tel;
        this.payDate = payDate;
        this.depositPrice = depositPrice;
        this.froms = froms;
        this.payType = payType;
        this.renovationDateStart = renovationDateStart;
        this.renovationDateEnd = renovationDateEnd;
        this.remake = remake;
    }
}
