package com.api.model.chargeManagement;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 缴费计划（周期生成缴费记录）
 */
public class DailyPaymentPlan {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 房产id
     */
    private Integer buildingUnitEstateId;
    /**
     * 费用名称类型(取自 物业收费标准明细表)
     */
    private Integer chargesTemplateDetailId;
    /**
     * 计费计划开始时间
     */
    private Date beginPlanDate;
    /**
     * 计费计划结束时间
     */
    private Date endPlanDate;
    /**
     * 计费单价
     */
    private BigDecimal unitPrice;
    /**
     * 计费单位
     */
    private Integer type;
    /**
     * 面积/用量/数量
     */
    private Integer num;
    /**
     * 费用金额
     */
    private BigDecimal costPrice;
    /**
     * 生成周期：1.每月
     */
    private Integer cycle;
    /**
     * 费率（%为单位）
     */
    private Integer rate;
    /**
     * 缴费期限日期(每月几号，只允许填1-28)
     */
    private Integer paymentTime;
    /**
     * 备注
     */
    private String remake;
    /**
     * 创建人
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
        return "DailyPaymentPlan{" +
                "id=" + id +
                ", buildingUnitEstateId=" + buildingUnitEstateId +
                ", chargesTemplateDetailId=" + chargesTemplateDetailId +
                ", beginPlanDate=" + beginPlanDate +
                ", endPlanDate=" + endPlanDate +
                ", unitPrice=" + unitPrice +
                ", type=" + type +
                ", num=" + num +
                ", costPrice=" + costPrice +
                ", cycle=" + cycle +
                ", rate=" + rate +
                ", paymentTime=" + paymentTime +
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

    public Integer getBuildingUnitEstateId() {
        return buildingUnitEstateId;
    }

    public void setBuildingUnitEstateId(Integer buildingUnitEstateId) {
        this.buildingUnitEstateId = buildingUnitEstateId;
    }

    public Integer getChargesTemplateDetailId() {
        return chargesTemplateDetailId;
    }

    public void setChargesTemplateDetailId(Integer chargesTemplateDetailId) {
        this.chargesTemplateDetailId = chargesTemplateDetailId;
    }

    public Date getBeginPlanDate() {
        return beginPlanDate;
    }

    public void setBeginPlanDate(Date beginPlanDate) {
        this.beginPlanDate = beginPlanDate;
    }

    public Date getEndPlanDate() {
        return endPlanDate;
    }

    public void setEndPlanDate(Date endPlanDate) {
        this.endPlanDate = endPlanDate;
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

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public Integer getCycle() {
        return cycle;
    }

    public void setCycle(Integer cycle) {
        this.cycle = cycle;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Integer getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Integer paymentTime) {
        this.paymentTime = paymentTime;
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

    public DailyPaymentPlan() {
    }

    public DailyPaymentPlan(Integer id, Integer buildingUnitEstateId, Integer chargesTemplateDetailId, Date beginPlanDate, Date endPlanDate, BigDecimal unitPrice, Integer type, Integer num, BigDecimal costPrice, Integer cycle, Integer rate, Integer paymentTime, String remake, Integer createId, Date createDate, Integer modifyId, Date modifyDate, Integer isDelete) {
        this.id = id;
        this.buildingUnitEstateId = buildingUnitEstateId;
        this.chargesTemplateDetailId = chargesTemplateDetailId;
        this.beginPlanDate = beginPlanDate;
        this.endPlanDate = endPlanDate;
        this.unitPrice = unitPrice;
        this.type = type;
        this.num = num;
        this.costPrice = costPrice;
        this.cycle = cycle;
        this.rate = rate;
        this.paymentTime = paymentTime;
        this.remake = remake;
        this.createId = createId;
        this.createDate = createDate;
        this.modifyId = modifyId;
        this.modifyDate = modifyDate;
        this.isDelete = isDelete;
    }
}
