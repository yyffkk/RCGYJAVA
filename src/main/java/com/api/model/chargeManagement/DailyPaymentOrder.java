package com.api.model.chargeManagement;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 日常缴费订单信息
 */
public class DailyPaymentOrder {
    /**
     * 日常缴费订单信息主键id
     */
    private Integer id;
    /**
     * 支付单号
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
     * 付款方式
     */
    private Integer payType;
    /**
     * 付款金额
     */
    private BigDecimal payPrice;
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
     * 备注
     */
    private String remake;
    /**
     * 是否打印该日常缴费订单（1.确认并开始打印，0.确认但不打印）
     */
    private Integer isPrinting;

    @Override
    public String toString() {
        return "DailyPaymentOrder{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", payType=" + payType +
                ", payPrice=" + payPrice +
                ", createId=" + createId +
                ", createDate=" + createDate +
                ", modifyId=" + modifyId +
                ", modifyDate=" + modifyDate +
                ", remake='" + remake + '\'' +
                ", isPrinting=" + isPrinting +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getRemake() {
        return remake;
    }

    public void setRemake(String remake) {
        this.remake = remake;
    }

    public Integer getIsPrinting() {
        return isPrinting;
    }

    public void setIsPrinting(Integer isPrinting) {
        this.isPrinting = isPrinting;
    }

    public DailyPaymentOrder() {
    }

    public DailyPaymentOrder(Integer id, String code, String name, String tel, Integer payType, BigDecimal payPrice, Integer createId, Date createDate, Integer modifyId, Date modifyDate, String remake, Integer isPrinting) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.tel = tel;
        this.payType = payType;
        this.payPrice = payPrice;
        this.createId = createId;
        this.createDate = createDate;
        this.modifyId = modifyId;
        this.modifyDate = modifyDate;
        this.remake = remake;
        this.isPrinting = isPrinting;
    }
}
