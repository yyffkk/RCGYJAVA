package com.api.model.alipay;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 支付宝订单
 */
public class AliPaymentOrder {
    /**
     * 商家订单主键
     */
    private String clubOrderId;
    /**
     * 商户订单号
     */
    private String outTradeNo;
    /**
     * 交易状态
     */
    private Byte tradeStatus;
    /**
     * 订单金额
     */
    private BigDecimal totalAmount;
    /**
     * 实收金额
     */
    private BigDecimal receiptAmount;
    /**
     * 开票金额
     */
    private BigDecimal invoiceAmount;
    /**
     * 付款金额
     */
    private BigDecimal buyerPayAmount;
    /**
     * 总退款金额
     */
    private BigDecimal refundFee;
    /**
     * 通知时间:yyyy-MM-dd HH:mm:ss
     */
    private Date notifyTime;
    /**
     * 交易创建时间:yyyy-MM-dd HH:mm:ss
     */
    private Date gmtCreate;
    /**
     * 交易付款时间
     */
    private Date gmtPayment;
    /**
     * 交易退款时间
     */
    private Date gmtRefund;
    /**
     * 交易结束时间
     */
    private Date gmtClose;
    /**
     * 支付宝的交易号
     */
    private String tradeNo;
    /**
     * 商户业务号(商户业务ID，主要是退款通知中返回退款申请的流水号)
     */
    private String outBizNo;
    /**
     * 买家支付宝账号
     */
    private String buyerLogonId;
    /**
     * 卖家支付宝用户号
     */
    private String sellerId;
    /**
     * 卖家支付宝账号
     */
    private String sellerEmail;

    @Override
    public String toString() {
        return "AliPaymentOrder{" +
                "clubOrderId='" + clubOrderId + '\'' +
                ", outTradeNo='" + outTradeNo + '\'' +
                ", tradeStatus=" + tradeStatus +
                ", totalAmount=" + totalAmount +
                ", receiptAmount=" + receiptAmount +
                ", invoiceAmount=" + invoiceAmount +
                ", buyerPayAmount=" + buyerPayAmount +
                ", refundFee=" + refundFee +
                ", notifyTime=" + notifyTime +
                ", gmtCreate=" + gmtCreate +
                ", gmtPayment=" + gmtPayment +
                ", gmtRefund=" + gmtRefund +
                ", gmtClose=" + gmtClose +
                ", tradeNo='" + tradeNo + '\'' +
                ", outBizNo='" + outBizNo + '\'' +
                ", buyerLogonId='" + buyerLogonId + '\'' +
                ", sellerId='" + sellerId + '\'' +
                ", sellerEmail='" + sellerEmail + '\'' +
                '}';
    }

    public String getClubOrderId() {
        return clubOrderId;
    }

    public void setClubOrderId(String clubOrderId) {
        this.clubOrderId = clubOrderId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public Byte getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(Byte tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getReceiptAmount() {
        return receiptAmount;
    }

    public void setReceiptAmount(BigDecimal receiptAmount) {
        this.receiptAmount = receiptAmount;
    }

    public BigDecimal getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(BigDecimal invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public BigDecimal getBuyerPayAmount() {
        return buyerPayAmount;
    }

    public void setBuyerPayAmount(BigDecimal buyerPayAmount) {
        this.buyerPayAmount = buyerPayAmount;
    }

    public BigDecimal getRefundFee() {
        return refundFee;
    }

    public void setRefundFee(BigDecimal refundFee) {
        this.refundFee = refundFee;
    }

    public Date getNotifyTime() {
        return notifyTime;
    }

    public void setNotifyTime(Date notifyTime) {
        this.notifyTime = notifyTime;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtPayment() {
        return gmtPayment;
    }

    public void setGmtPayment(Date gmtPayment) {
        this.gmtPayment = gmtPayment;
    }

    public Date getGmtRefund() {
        return gmtRefund;
    }

    public void setGmtRefund(Date gmtRefund) {
        this.gmtRefund = gmtRefund;
    }

    public Date getGmtClose() {
        return gmtClose;
    }

    public void setGmtClose(Date gmtClose) {
        this.gmtClose = gmtClose;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getOutBizNo() {
        return outBizNo;
    }

    public void setOutBizNo(String outBizNo) {
        this.outBizNo = outBizNo;
    }

    public String getBuyerLogonId() {
        return buyerLogonId;
    }

    public void setBuyerLogonId(String buyerLogonId) {
        this.buyerLogonId = buyerLogonId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerEmail() {
        return sellerEmail;
    }

    public void setSellerEmail(String sellerEmail) {
        this.sellerEmail = sellerEmail;
    }

    public AliPaymentOrder() {
    }

    public AliPaymentOrder(String clubOrderId, String outTradeNo, Byte tradeStatus, BigDecimal totalAmount, BigDecimal receiptAmount, BigDecimal invoiceAmount, BigDecimal buyerPayAmount, BigDecimal refundFee, Date notifyTime, Date gmtCreate, Date gmtPayment, Date gmtRefund, Date gmtClose, String tradeNo, String outBizNo, String buyerLogonId, String sellerId, String sellerEmail) {
        this.clubOrderId = clubOrderId;
        this.outTradeNo = outTradeNo;
        this.tradeStatus = tradeStatus;
        this.totalAmount = totalAmount;
        this.receiptAmount = receiptAmount;
        this.invoiceAmount = invoiceAmount;
        this.buyerPayAmount = buyerPayAmount;
        this.refundFee = refundFee;
        this.notifyTime = notifyTime;
        this.gmtCreate = gmtCreate;
        this.gmtPayment = gmtPayment;
        this.gmtRefund = gmtRefund;
        this.gmtClose = gmtClose;
        this.tradeNo = tradeNo;
        this.outBizNo = outBizNo;
        this.buyerLogonId = buyerLogonId;
        this.sellerId = sellerId;
        this.sellerEmail = sellerEmail;
    }
}
