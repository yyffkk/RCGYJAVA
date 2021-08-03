package com.api.model.butlerService;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 租赁缴费记录
 */
public class SysLeasePaymentRecords {
    /**
     * 主键id(根据type判断是保证金主键id还是租金主键id)
     */
    private Integer id;
    /**
     * 支付单号
     */
    private String code;
    /**
     * 费用类型（1.保证金，2.租金）
     */
    private Integer type;
    /**
     * 缴费金额
     */
    private BigDecimal payPrice;
    /**
     * 状态（0.未缴纳,1.已缴纳,2.已结算）
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "SysLeasePaymentRecords{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", type=" + type +
                ", payPrice=" + payPrice +
                ", status=" + status +
                ", createDate=" + createDate +
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public BigDecimal getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(BigDecimal payPrice) {
        this.payPrice = payPrice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public SysLeasePaymentRecords() {
    }

    public SysLeasePaymentRecords(Integer id, String code, Integer type, BigDecimal payPrice, Integer status, Date createDate) {
        this.id = id;
        this.code = code;
        this.type = type;
        this.payPrice = payPrice;
        this.status = status;
        this.createDate = createDate;
    }
}
