package com.api.model.app;

import java.math.BigDecimal;

/**
 * 装修额外费用
 */
public class UserDecorationAdditionalCost {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 装修信息表主键id
     */
    private Integer userDecorationId;
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
        return "UserDecorationAdditional{" +
                "id=" + id +
                ", userDecorationId=" + userDecorationId +
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

    public Integer getUserDecorationId() {
        return userDecorationId;
    }

    public void setUserDecorationId(Integer userDecorationId) {
        this.userDecorationId = userDecorationId;
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

    public UserDecorationAdditionalCost() {
    }

    public UserDecorationAdditionalCost(Integer id, Integer userDecorationId, String name, BigDecimal cost) {
        this.id = id;
        this.userDecorationId = userDecorationId;
        this.name = name;
        this.cost = cost;
    }
}
