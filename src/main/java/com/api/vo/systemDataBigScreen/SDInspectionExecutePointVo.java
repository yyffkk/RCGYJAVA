package com.api.vo.systemDataBigScreen;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 系统数据 巡更执行点 Vo 回显
 */
public class SDInspectionExecutePointVo {
    /**
     * 巡检点编号
     */
    private String code;
    /**
     * 巡检点名称
     */
    private String name;
    /**
     * 经度
     */
    private BigDecimal longitude;
    /**
     * 纬度
     */
    private BigDecimal latitude;
    /**
     * 巡检点完成时间
     */
    private Date completeDate;

    @Override
    public String toString() {
        return "SDInspectionExecutePointVo{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", completeDate=" + completeDate +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public Date getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(Date completeDate) {
        this.completeDate = completeDate;
    }

    public SDInspectionExecutePointVo() {
    }

    public SDInspectionExecutePointVo(String code, String name, BigDecimal longitude, BigDecimal latitude, Date completeDate) {
        this.code = code;
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.completeDate = completeDate;
    }
}
