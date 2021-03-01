package com.api.vo.app;

import java.math.BigDecimal;

/**
 * app装修额外费用Vo list 回显
 */
public class AppDecorationAdditionalCostVo {
    /**
     * 主键id
     */
    private Integer id;
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
        return "AppDecorationAdditionalCostVo{" +
                "id=" + id +
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

    public AppDecorationAdditionalCostVo() {
    }

    public AppDecorationAdditionalCostVo(Integer id, String name, BigDecimal cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }
}
