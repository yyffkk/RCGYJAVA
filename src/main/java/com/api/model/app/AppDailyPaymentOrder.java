package com.api.model.app;


import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

/**
 * app生活缴纳 支付订单信息
 */
public class AppDailyPaymentOrder {
    /**
     * 日常缴费订单信息主键id
     */
    private Integer id;
    /**
     * 缴费主键id数组
     */
    private int[] ids;
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


    @Override
    public String toString() {
        return "AppDailyPaymentOrder{" +
                "ids=" + Arrays.toString(ids) +
                ", id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", payType=" + payType +
                ", payPrice=" + payPrice +
                ", createId=" + createId +
                ", createDate=" + createDate +
                '}';
    }

    public int[] getIds() {
        return ids;
    }

    public void setIds(int[] ids) {
        this.ids = ids;
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

    public AppDailyPaymentOrder() {
    }

    public AppDailyPaymentOrder(int[] ids, Integer id, String code, String name, String tel, Integer payType, BigDecimal payPrice, Integer createId, Date createDate) {
        this.ids = ids;
        this.id = id;
        this.code = code;
        this.name = name;
        this.tel = tel;
        this.payType = payType;
        this.payPrice = payPrice;
        this.createId = createId;
        this.createDate = createDate;
    }
}
