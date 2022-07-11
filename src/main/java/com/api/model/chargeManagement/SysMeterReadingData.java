package com.api.model.chargeManagement;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 抄表数据
 */
public class SysMeterReadingData {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 抄表类型（1.水量，2.电量）
     */
    private Integer type;
    /**
     * 当前总量
     */
    private BigDecimal quantity;
    /**
     * 更新时间
     */
    private Date updateDate;

    @Override
    public String toString() {
        return "SysMeterReadingData{" +
                "id=" + id +
                ", type=" + type +
                ", quantity=" + quantity +
                ", updateDate=" + updateDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public SysMeterReadingData() {
    }

    public SysMeterReadingData(Integer id, Integer type, BigDecimal quantity, Date updateDate) {
        this.id = id;
        this.type = type;
        this.quantity = quantity;
        this.updateDate = updateDate;
    }
}
