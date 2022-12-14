package com.api.model.alipay;

import java.math.BigDecimal;
import java.util.Date;

/**
 * app 生活缴费-预充值支付订单model
 */
public class SysAdvancePaymentOrder {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 充值的房产id
     */
    private Integer estateId;
    /**
     * 预充值支付账单支付单号
     */
    private String code;
    /**
     * 缴费人名称
     */
    private String name;
    /**
     * 联系方式
     */
    private String tel;
    /**
     * 付款方式（1.支付宝，2.微信）
     */
    private Integer payType;
    /**
     * 付款金额
     */
    private BigDecimal payPrice;
    /**
     * 创建人(app 为-1)
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 付款状态:0.交易创建并等待买家付款，1.未付款交易超时关闭或支付完成后全额退款，2.交易支付成功，3.交易结束并不可退款
     */
    private Integer status;

    @Override
    public String toString() {
        return "SysAdvancePaymentOrder{" +
                "id=" + id +
                ", estateId=" + estateId +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", payType=" + payType +
                ", payPrice=" + payPrice +
                ", createId=" + createId +
                ", createDate=" + createDate +
                ", status=" + status +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEstateId() {
        return estateId;
    }

    public void setEstateId(Integer estateId) {
        this.estateId = estateId;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public BigDecimal getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(BigDecimal payPrice) {
        this.payPrice = payPrice;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public SysAdvancePaymentOrder() {
    }

    public SysAdvancePaymentOrder(Integer id, Integer estateId, String code, String name, String tel, Integer payType, BigDecimal payPrice, Integer createId, Date createDate, Integer status) {
        this.id = id;
        this.estateId = estateId;
        this.code = code;
        this.name = name;
        this.tel = tel;
        this.payType = payType;
        this.payPrice = payPrice;
        this.createId = createId;
        this.createDate = createDate;
        this.status = status;
    }
}
