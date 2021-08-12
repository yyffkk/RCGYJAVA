package com.api.vo.chargeManagement;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 预缴信息 Vo findById 回显
 */
public class VoAdvancePaymentDetail {
    /**
     * 预缴订单主键id
     */
    private Integer id;
    /**
     * 创建时间
     */
    private Date createId;
    /**
     * 金额
     */
    private BigDecimal payPrice;
    /**
     * 备注
     */
    private String remake;
    /**
     * 支付方式 付款方式（1.支付宝，2.微信，3.线下，4.自动扣除）
     */
    private Integer payType;

    @Override
    public String toString() {
        return "VoAdvancePaymentDetail{" +
                "id=" + id +
                ", createId=" + createId +
                ", payPrice=" + payPrice +
                ", remake='" + remake + '\'' +
                ", payType=" + payType +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateId() {
        return createId;
    }

    public void setCreateId(Date createId) {
        this.createId = createId;
    }

    public BigDecimal getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(BigDecimal payPrice) {
        this.payPrice = payPrice;
    }

    public String getRemake() {
        return remake;
    }

    public void setRemake(String remake) {
        this.remake = remake;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public VoAdvancePaymentDetail() {
    }

    public VoAdvancePaymentDetail(Integer id, Date createId, BigDecimal payPrice, String remake, Integer payType) {
        this.id = id;
        this.createId = createId;
        this.payPrice = payPrice;
        this.remake = remake;
        this.payType = payType;
    }
}
