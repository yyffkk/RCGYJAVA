package com.api.vo.app;

import java.util.Date;

/**
 * app维修信息
 */
public class AppDispatchListVo {
    /**
     * 订单编号
     */
    private String code;
    /**
     * 下单时间
     */
    private Date orderDate;
    /**
     * 派工类型（1.无偿服务，2.有偿服务）
     */
    private Integer type;
    /**
     * 维修人员名称
     */
    private String operatorName;
    /**
     * 分配人名称
     */
    private String distributorName;

    @Override
    public String toString() {
        return "AppDispatchListVo{" +
                "code='" + code + '\'' +
                ", orderDate=" + orderDate +
                ", type=" + type +
                ", operatorName='" + operatorName + '\'' +
                ", distributorName='" + distributorName + '\'' +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getDistributorName() {
        return distributorName;
    }

    public void setDistributorName(String distributorName) {
        this.distributorName = distributorName;
    }

    public AppDispatchListVo() {
    }

    public AppDispatchListVo(String code, Date orderDate, Integer type, String operatorName, String distributorName) {
        this.code = code;
        this.orderDate = orderDate;
        this.type = type;
        this.operatorName = operatorName;
        this.distributorName = distributorName;
    }
}
