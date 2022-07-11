package com.api.vo.chargeManagement;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 公摊账单
 */
public class VoMeterReadingShareBill {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 抄表记录表主键Id
     */
    private Integer meterReadingRecordId;
    /**
     * 月份
     */
    private String months;
    /**
     * 总用量
     */
    private BigDecimal totals;
    /**
     * 单位
     */
    private String unit;
    /**
     * 单价（水量、电量）
     */
    private BigDecimal unitPrice;
    /**
     * 抄表类型：1.水费，2.电费
     */
    private Integer type;
    /**
     * 费用金额（总用量*单价）
     */
    private BigDecimal cost;
    /**
     * 住户用量
     */
    private BigDecimal householdConsumption;
    /**
     * 住户面积
     */
    private BigDecimal householdArea;
    /**
     * 住户总费用（住户用量*单价）
     */
    private BigDecimal householdCost;
    /**
     * 公摊单价（（总用量-住户总费用）/住户面积）
     */
    private BigDecimal shareUnitPrice;
    /**
     * 收费单位
     */
    private String chargeUnit;
    /**
     * 住户公摊总费用（公摊单价*住户面积）
     */
    private BigDecimal householdShareCost;
    /**
     * 实收金额
     */
    private BigDecimal paidAmount;
    /**
     * 剩余未缴费用
     */
    private BigDecimal unpaidExpenses;
    /**
     * 缴纳状态（1.已完成，2.未完成）
     */
    private Integer status;
    /**
     * 额外费用（费用金额-住户公摊总费用-住户总费用）【富航所承担的公摊费用】
     */
    private BigDecimal additionalCosts;
    /**
     * 费率（单位为%）
     */
    private BigDecimal rate;
    /**
     * 有效时间开始
     */
    private Date effectiveTimeStart;
    /**
     * 有效时间结束
     */
    private Date effectiveTimeEnd;
    /**
     * 备注
     */
    private String remakes;
    /**
     * 创建时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "VoMeterReadingShareBill{" +
                "id=" + id +
                ", meterReadingRecordId=" + meterReadingRecordId +
                ", months='" + months + '\'' +
                ", totals=" + totals +
                ", unit='" + unit + '\'' +
                ", unitPrice=" + unitPrice +
                ", type=" + type +
                ", cost=" + cost +
                ", householdConsumption=" + householdConsumption +
                ", householdArea=" + householdArea +
                ", householdCost=" + householdCost +
                ", shareUnitPrice=" + shareUnitPrice +
                ", chargeUnit='" + chargeUnit + '\'' +
                ", householdShareCost=" + householdShareCost +
                ", paidAmount=" + paidAmount +
                ", unpaidExpenses=" + unpaidExpenses +
                ", status=" + status +
                ", additionalCosts=" + additionalCosts +
                ", rate=" + rate +
                ", effectiveTimeStart=" + effectiveTimeStart +
                ", effectiveTimeEnd=" + effectiveTimeEnd +
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

    public Integer getMeterReadingRecordId() {
        return meterReadingRecordId;
    }

    public void setMeterReadingRecordId(Integer meterReadingRecordId) {
        this.meterReadingRecordId = meterReadingRecordId;
    }

    public String getMonths() {
        return months;
    }

    public void setMonths(String months) {
        this.months = months;
    }

    public BigDecimal getTotals() {
        return totals;
    }

    public void setTotals(BigDecimal totals) {
        this.totals = totals;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getHouseholdConsumption() {
        return householdConsumption;
    }

    public void setHouseholdConsumption(BigDecimal householdConsumption) {
        this.householdConsumption = householdConsumption;
    }

    public BigDecimal getHouseholdArea() {
        return householdArea;
    }

    public void setHouseholdArea(BigDecimal householdArea) {
        this.householdArea = householdArea;
    }

    public BigDecimal getHouseholdCost() {
        return householdCost;
    }

    public void setHouseholdCost(BigDecimal householdCost) {
        this.householdCost = householdCost;
    }

    public BigDecimal getShareUnitPrice() {
        return shareUnitPrice;
    }

    public void setShareUnitPrice(BigDecimal shareUnitPrice) {
        this.shareUnitPrice = shareUnitPrice;
    }

    public String getChargeUnit() {
        return chargeUnit;
    }

    public void setChargeUnit(String chargeUnit) {
        this.chargeUnit = chargeUnit;
    }

    public BigDecimal getHouseholdShareCost() {
        return householdShareCost;
    }

    public void setHouseholdShareCost(BigDecimal householdShareCost) {
        this.householdShareCost = householdShareCost;
    }

    public BigDecimal getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(BigDecimal paidAmount) {
        this.paidAmount = paidAmount;
    }

    public BigDecimal getUnpaidExpenses() {
        return unpaidExpenses;
    }

    public void setUnpaidExpenses(BigDecimal unpaidExpenses) {
        this.unpaidExpenses = unpaidExpenses;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BigDecimal getAdditionalCosts() {
        return additionalCosts;
    }

    public void setAdditionalCosts(BigDecimal additionalCosts) {
        this.additionalCosts = additionalCosts;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public Date getEffectiveTimeStart() {
        return effectiveTimeStart;
    }

    public void setEffectiveTimeStart(Date effectiveTimeStart) {
        this.effectiveTimeStart = effectiveTimeStart;
    }

    public Date getEffectiveTimeEnd() {
        return effectiveTimeEnd;
    }

    public void setEffectiveTimeEnd(Date effectiveTimeEnd) {
        this.effectiveTimeEnd = effectiveTimeEnd;
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

    public VoMeterReadingShareBill() {
    }

    public VoMeterReadingShareBill(Integer id, Integer meterReadingRecordId, String months, BigDecimal totals, String unit, BigDecimal unitPrice, Integer type, BigDecimal cost, BigDecimal householdConsumption, BigDecimal householdArea, BigDecimal householdCost, BigDecimal shareUnitPrice, String chargeUnit, BigDecimal householdShareCost, BigDecimal paidAmount, BigDecimal unpaidExpenses, Integer status, BigDecimal additionalCosts, BigDecimal rate, Date effectiveTimeStart, Date effectiveTimeEnd, String remakes, Date createDate) {
        this.id = id;
        this.meterReadingRecordId = meterReadingRecordId;
        this.months = months;
        this.totals = totals;
        this.unit = unit;
        this.unitPrice = unitPrice;
        this.type = type;
        this.cost = cost;
        this.householdConsumption = householdConsumption;
        this.householdArea = householdArea;
        this.householdCost = householdCost;
        this.shareUnitPrice = shareUnitPrice;
        this.chargeUnit = chargeUnit;
        this.householdShareCost = householdShareCost;
        this.paidAmount = paidAmount;
        this.unpaidExpenses = unpaidExpenses;
        this.status = status;
        this.additionalCosts = additionalCosts;
        this.rate = rate;
        this.effectiveTimeStart = effectiveTimeStart;
        this.effectiveTimeEnd = effectiveTimeEnd;
        this.remakes = remakes;
        this.createDate = createDate;
    }
}
