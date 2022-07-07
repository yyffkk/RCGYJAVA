package com.api.vo.chargeManagement;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 缴费计划 Vo list 回显
 */
public class VoDailyPaymentPlan {
    /**
     * 缴费计划主键id
     */
    private Integer id;
    /**
     * 房屋名称
     */
    private String roomName;
    /**
     * 物业收费标准明细收费主键id
     */
    private Integer chargesTemplateDetailId;
    /**
     * 物业收费标准明细收费名称
     */
    private String chargesTemplateDetailName;
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
     * 创建人名称
     */
    private String createName;
    /**
     * 创建时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "VoDailyPaymentPlan{" +
                "id=" + id +
                ", roomName='" + roomName + '\'' +
                ", chargesTemplateDetailId=" + chargesTemplateDetailId +
                ", chargesTemplateDetailName='" + chargesTemplateDetailName + '\'' +
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
                ", createName='" + createName + '\'' +
                ", createDate=" + createDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Integer getChargesTemplateDetailId() {
        return chargesTemplateDetailId;
    }

    public void setChargesTemplateDetailId(Integer chargesTemplateDetailId) {
        this.chargesTemplateDetailId = chargesTemplateDetailId;
    }

    public String getChargesTemplateDetailName() {
        return chargesTemplateDetailName;
    }

    public void setChargesTemplateDetailName(String chargesTemplateDetailName) {
        this.chargesTemplateDetailName = chargesTemplateDetailName;
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

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public VoDailyPaymentPlan() {
    }

    public VoDailyPaymentPlan(Integer id, String roomName, Integer chargesTemplateDetailId, String chargesTemplateDetailName, Date beginPlanDate, Date endPlanDate, BigDecimal unitPrice, Integer type, Integer num, BigDecimal costPrice, Integer cycle, Integer rate, Integer paymentTime, String remake, String createName, Date createDate) {
        this.id = id;
        this.roomName = roomName;
        this.chargesTemplateDetailId = chargesTemplateDetailId;
        this.chargesTemplateDetailName = chargesTemplateDetailName;
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
        this.createName = createName;
        this.createDate = createDate;
    }
}
