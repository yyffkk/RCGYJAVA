package com.api.vo.app;

import java.math.BigDecimal;
import java.util.List;

/**
 * app抄表账单信息回显
 */
public class AppMeterShareVo {
    /**
     * 抄表账单主键id
     */
    private Integer id;
    /**
     * 抄表年月份
     */
    private String months;
    /**
     * 抄表类型：1.水费，2.电费
     */
    private Integer type;
    /**
     * 未缴纳数量
     */
    private Integer num;
    /**
     * 未缴纳总金额
     */
    private BigDecimal total;
    /**
     * app抄表账单详情信息回显
     */
    private List<AppMeterShareDetailsVo> appMeterShareDetailsVos;

    @Override
    public String toString() {
        return "AppMeterShareVo{" +
                "id=" + id +
                ", months='" + months + '\'' +
                ", type=" + type +
                ", num=" + num +
                ", total=" + total +
                ", appMeterShareDetailsVos=" + appMeterShareDetailsVos +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMonths() {
        return months;
    }

    public void setMonths(String months) {
        this.months = months;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<AppMeterShareDetailsVo> getAppMeterShareDetailsVos() {
        return appMeterShareDetailsVos;
    }

    public void setAppMeterShareDetailsVos(List<AppMeterShareDetailsVo> appMeterShareDetailsVos) {
        this.appMeterShareDetailsVos = appMeterShareDetailsVos;
    }

    public AppMeterShareVo() {
    }

    public AppMeterShareVo(Integer id, String months, Integer type, Integer num, BigDecimal total, List<AppMeterShareDetailsVo> appMeterShareDetailsVos) {
        this.id = id;
        this.months = months;
        this.type = type;
        this.num = num;
        this.total = total;
        this.appMeterShareDetailsVos = appMeterShareDetailsVos;
    }
}
