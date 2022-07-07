package com.api.model.app;

/**
 * 用户主键id 和 商品预约主键id
 */
public class UserIdAndGoodsAppointmentId {
    /**
     * 用户主键id
     */
    private Integer id;
    /**
     * 商品预约主键id
     */
    private Integer goodsAppointmentId;

    @Override
    public String toString() {
        return "UserIdAndGoodsAppointmentId{" +
                "id=" + id +
                ", goodsAppointmentId=" + goodsAppointmentId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodsAppointmentId() {
        return goodsAppointmentId;
    }

    public void setGoodsAppointmentId(Integer goodsAppointmentId) {
        this.goodsAppointmentId = goodsAppointmentId;
    }

    public UserIdAndGoodsAppointmentId() {
    }

    public UserIdAndGoodsAppointmentId(Integer goodsAppointmentId) {
        this.goodsAppointmentId = goodsAppointmentId;
    }
}
