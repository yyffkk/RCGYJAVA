package com.api.vo.systemDataBigScreen;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 系统数据 巡更执行路线 Vo 回显
 */
public class SDInspectionExecuteMapVo {
    /**
     * 经度
     */
    private BigDecimal longitude;
    /**
     * 纬度
     */
    private BigDecimal latitude;
    /**
     * 创建时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "SDInspectionExecuteMapVo{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                ", createDate=" + createDate +
                '}';
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public SDInspectionExecuteMapVo() {
    }

    public SDInspectionExecuteMapVo(BigDecimal longitude, BigDecimal latitude, Date createDate) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.createDate = createDate;
    }
}
