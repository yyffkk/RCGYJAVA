package com.api.model.app;

import java.math.BigDecimal;

/**
 * app押金额外费用
 */
public class AppDepositAdditionalCost {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 押金管理主键id
     */
    private Integer sysDepositManagementId;
    /**
     * 附加费用名称
     */
    private String name;
    /**
     * 附加费用金额
     */
    private BigDecimal cost;

    @Override
    public String toString() {
        return "AppDepositAdditionalCost{" +
                "id=" + id +
                ", sysDepositManagementId=" + sysDepositManagementId +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSysDepositManagementId() {
        return sysDepositManagementId;
    }

    public void setSysDepositManagementId(Integer sysDepositManagementId) {
        this.sysDepositManagementId = sysDepositManagementId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public AppDepositAdditionalCost() {
    }

    public AppDepositAdditionalCost(Integer id, Integer sysDepositManagementId, String name, BigDecimal cost) {
        this.id = id;
        this.sysDepositManagementId = sysDepositManagementId;
        this.name = name;
        this.cost = cost;
    }
}
