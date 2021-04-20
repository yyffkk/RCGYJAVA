package com.api.vo.butlerApp;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 巡检执行路线地图经纬度信息 回显
 */
public class ButlerExecuteMapVo {
    /**
     * 主键id
     */
    private Integer id;
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
        return "ButlerExecuteMapVo{" +
                "id=" + id +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", createDate=" + createDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public ButlerExecuteMapVo() {
    }

    public ButlerExecuteMapVo(Integer id, BigDecimal longitude, BigDecimal latitude, Date createDate) {
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
        this.createDate = createDate;
    }
}
