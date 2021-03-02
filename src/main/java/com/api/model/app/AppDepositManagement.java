package com.api.model.app;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * app押金管理model
 */
public class AppDepositManagement {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 装修id
     */
    private Integer userDecorationId;
    /**
     * 订单号
     */
    private String orderCode;
    /**
     * 费用名称类型（取自 物业收费标准明细表）
     */
    private Integer chargesTemplateDetailId;
    /**
     * 缴费时间
     */
    private Date payDate;
    /**
     * 押金金额
     */
    private BigDecimal depositPrice;
    /**
     * 装修额外费用集合
     */
    List<AppDepositAdditionalCost> depositAdditionalCostList;
    /**
     * 状态 1.未退，2.已退
     */
    private Integer status;
    /**
     * 来源：1.app,2.线下
     */
    private Integer froms;
    /**
     * 支付方式：1.app支付宝，2.app微信，3.现金，4.线下支付宝，5.线下微信
     */
    private Integer payType;
    /**
     * 备注
     */
    private String remake;
    /**
     * 创建人（app为-1，显示为申请人姓名）
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 是否删除，0.删除，1.非删
     */
    private Integer isDelete;

    @Override
    public String toString() {
        return "AppDepositManagement{" +
                "id=" + id +
                ", userDecorationId=" + userDecorationId +
                ", orderCode='" + orderCode + '\'' +
                ", chargesTemplateDetailId=" + chargesTemplateDetailId +
                ", payDate=" + payDate +
                ", depositPrice=" + depositPrice +
                ", depositAdditionalCostList=" + depositAdditionalCostList +
                ", status=" + status +
                ", froms=" + froms +
                ", payType=" + payType +
                ", remake='" + remake + '\'' +
                ", createId=" + createId +
                ", createDate=" + createDate +
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

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Integer getChargesTemplateDetailId() {
        return chargesTemplateDetailId;
    }

    public void setChargesTemplateDetailId(Integer chargesTemplateDetailId) {
        this.chargesTemplateDetailId = chargesTemplateDetailId;
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

    public List<AppDepositAdditionalCost> getDepositAdditionalCostList() {
        return depositAdditionalCostList;
    }

    public void setDepositAdditionalCostList(List<AppDepositAdditionalCost> depositAdditionalCostList) {
        this.depositAdditionalCostList = depositAdditionalCostList;
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

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public AppDepositManagement() {
    }

    public AppDepositManagement(Integer id, Integer userDecorationId, String orderCode, Integer chargesTemplateDetailId, Date payDate, BigDecimal depositPrice, List<AppDepositAdditionalCost> depositAdditionalCostList, Integer status, Integer froms, Integer payType, String remake, Integer createId, Date createDate, Integer isDelete) {
        this.id = id;
        this.userDecorationId = userDecorationId;
        this.orderCode = orderCode;
        this.chargesTemplateDetailId = chargesTemplateDetailId;
        this.payDate = payDate;
        this.depositPrice = depositPrice;
        this.depositAdditionalCostList = depositAdditionalCostList;
        this.status = status;
        this.froms = froms;
        this.payType = payType;
        this.remake = remake;
        this.createId = createId;
        this.createDate = createDate;
        this.isDelete = isDelete;
    }
}
