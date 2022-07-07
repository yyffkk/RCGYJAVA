package com.api.vo.app;

import java.math.BigDecimal;
import java.util.Date;

/**
 * app装修退款单Vo 回显
 */
public class AppDepositRefundOrderVo {
    /**
     * 装修主键id
     */
    private Integer id;
    /**
     * 装修状态(-1.申请中，-2.申请不通过，-3.申请通过，1.未开始（已付押金），2.装修中，3.完工检查申请中，4.完工检查不通过，5.完工检查通过，6.申请退款中，7.装修结束（已退押金），8.已作废)
     */
    private Integer status;
    /**
     * 退款账户（支付账户）
     */
    private String payAccount;
    /**
     * 押金金额（退款金额）
     */
    private BigDecimal depositPrice;
    /**
     * 申请退款时间
     */
    private Date applicationRefundDate;
    /**
     * 退款时间(到账时间)
     */
    private Integer refundDate;
    /**
     * 退款单号
     */
    private String code;

    @Override
    public String toString() {
        return "AppDepositRefundOrderVo{" +
                "id=" + id +
                ", status=" + status +
                ", payAccount='" + payAccount + '\'' +
                ", depositPrice=" + depositPrice +
                ", applicationRefundDate=" + applicationRefundDate +
                ", refundDate=" + refundDate +
                ", code='" + code + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPayAccount() {
        return payAccount;
    }

    public void setPayAccount(String payAccount) {
        this.payAccount = payAccount;
    }

    public BigDecimal getDepositPrice() {
        return depositPrice;
    }

    public void setDepositPrice(BigDecimal depositPrice) {
        this.depositPrice = depositPrice;
    }

    public Date getApplicationRefundDate() {
        return applicationRefundDate;
    }

    public void setApplicationRefundDate(Date applicationRefundDate) {
        this.applicationRefundDate = applicationRefundDate;
    }

    public Integer getRefundDate() {
        return refundDate;
    }

    public void setRefundDate(Integer refundDate) {
        this.refundDate = refundDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public AppDepositRefundOrderVo() {
    }

    public AppDepositRefundOrderVo(Integer id, Integer status, String payAccount, BigDecimal depositPrice, Date applicationRefundDate, Integer refundDate, String code) {
        this.id = id;
        this.status = status;
        this.payAccount = payAccount;
        this.depositPrice = depositPrice;
        this.applicationRefundDate = applicationRefundDate;
        this.refundDate = refundDate;
        this.code = code;
    }
}
