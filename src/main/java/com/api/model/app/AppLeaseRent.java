package com.api.model.app;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 租赁租金账单表
 */
public class AppLeaseRent {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 租赁主键id
     */
    private Integer sysLeaseId;
    /**
     * 需支付金额
     */
    private BigDecimal price;
    /**
     * 租金状态：1.已缴纳，0.未缴纳
     */
    private Integer status;
    /**
     * 创建人id
     */
    private Integer createId;
    /**
     * 创建日期
     */
    private Date createDate;

    @Override
    public String toString() {
        return "AppLeaseRent{" +
                "id=" + id +
                ", sysLeaseId=" + sysLeaseId +
                ", price=" + price +
                ", status=" + status +
                ", createId=" + createId +
                ", createDate=" + createDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSysLeaseId() {
        return sysLeaseId;
    }

    public void setSysLeaseId(Integer sysLeaseId) {
        this.sysLeaseId = sysLeaseId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public AppLeaseRent() {
    }

    public AppLeaseRent(Integer id, Integer sysLeaseId, BigDecimal price, Integer status, Integer createId, Date createDate) {
        this.id = id;
        this.sysLeaseId = sysLeaseId;
        this.price = price;
        this.status = status;
        this.createId = createId;
        this.createDate = createDate;
    }
}
