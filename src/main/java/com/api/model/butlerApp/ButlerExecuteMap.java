package com.api.model.butlerApp;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 巡检执行路线地图经纬度信息
 */
public class ButlerExecuteMap {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 巡检执行情况主键id
     */
    private Integer executeId;
    /**
     * 经度
     */
    private BigDecimal longitude;
    /**
     * 纬度
     */
    private BigDecimal latitude;
    /**
     * 创建人
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "ButlerExecuteMap{" +
                "id=" + id +
                ", executeId=" + executeId +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", createId=" + createId +
                ", createDate=" + createDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getExecuteId() {
        return executeId;
    }

    public void setExecuteId(Integer executeId) {
        this.executeId = executeId;
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

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public ButlerExecuteMap() {
    }

    public ButlerExecuteMap(Integer id, Integer executeId, BigDecimal longitude, BigDecimal latitude, Integer createId, Date createDate) {
        this.id = id;
        this.executeId = executeId;
        this.longitude = longitude;
        this.latitude = latitude;
        this.createId = createId;
        this.createDate = createDate;
    }
}
