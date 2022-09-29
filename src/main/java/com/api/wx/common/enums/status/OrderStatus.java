package com.api.wx.common.enums.status;

/**
 * @author leone
 * @since 2018-05-20
 **/
public enum OrderStatus {

    CREATE(0, "创建"),PAY(1, "支付"),DELIVER(2, "发货"),DELIVERY(3, "运输中"),RECEIVING(4, "收货"),CANCEL(5, "取消"),CLOSE(6, "关闭"),DELETE(7, "删除");

    private int status;

    private String declare;

    OrderStatus(int status, String declare) {
        this.status = status;
        this.declare = declare;
    }

    public int getStatus() {
        return status;
    }

    public String getDeclare() {
        return declare;
    }
}
