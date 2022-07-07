package com.api.vo.systemDataBigScreen;

/**
 * 商场各分类下报名统计信息
 */
public class SDShopAppointmentNumVo {
    /**
     * 分类名称
     */
    private String name;
    /**
     * 报名数量
     */
    private Integer appointmentNum;

    @Override
    public String toString() {
        return "SDShopAppointmentNumVo{" +
                "name='" + name + '\'' +
                ", appointmentNum=" + appointmentNum +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAppointmentNum() {
        return appointmentNum;
    }

    public void setAppointmentNum(Integer appointmentNum) {
        this.appointmentNum = appointmentNum;
    }

    public SDShopAppointmentNumVo() {
    }

    public SDShopAppointmentNumVo(String name, Integer appointmentNum) {
        this.name = name;
        this.appointmentNum = appointmentNum;
    }
}
