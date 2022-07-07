package com.api.model.app;

/**
 * app 商品主键id 和 预约数量
 */
public class AppGoodsIdAndAppointmentNum {
    /**
     * 商品主键id
     */
    private Integer goodsId;
    /**
     * 预约数量
     */
    private Integer appointmentNum;

    @Override
    public String toString() {
        return "AppGoodsIdAndAppointmentNum{" +
                "goodsId=" + goodsId +
                ", appointmentNum=" + appointmentNum +
                '}';
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getAppointmentNum() {
        return appointmentNum;
    }

    public void setAppointmentNum(Integer appointmentNum) {
        this.appointmentNum = appointmentNum;
    }

    public AppGoodsIdAndAppointmentNum() {
    }

    public AppGoodsIdAndAppointmentNum(Integer goodsId, Integer appointmentNum) {
        this.goodsId = goodsId;
        this.appointmentNum = appointmentNum;
    }
}
