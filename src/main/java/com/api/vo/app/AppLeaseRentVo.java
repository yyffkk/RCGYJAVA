package com.api.vo.app;

import java.math.BigDecimal;
import java.util.Date;

/**
 * app 租赁租金账单 Vo list 回显
 */
public class AppLeaseRentVo {
    /**
     * 主键id（保证金主键id 或 租金主键id 或 剩余需结清租金主键id）
     */
    private Integer id;
    /**
     * 需支付金额
     */
    private BigDecimal price;
    /**
     * 租金状态(缴纳状态)：1.已缴纳，0.未缴纳
     */
    private Integer payStatus;
    /**
     * 创建日期
     */
    private Date createDate;
    /**
     * 缴费类型，1.保证金，2.租金，3.剩余需结清租金
     */
    private Integer type;

    @Override
    public String toString() {
        return "AppLeaseRentVo{" +
                "id=" + id +
                ", price=" + price +
                ", payStatus=" + payStatus +
                ", createDate=" + createDate +
                ", type=" + type +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public AppLeaseRentVo() {
    }

    public AppLeaseRentVo(Integer id, BigDecimal price, Integer payStatus, Date createDate, Integer type) {
        this.id = id;
        this.price = price;
        this.payStatus = payStatus;
        this.createDate = createDate;
        this.type = type;
    }
}
