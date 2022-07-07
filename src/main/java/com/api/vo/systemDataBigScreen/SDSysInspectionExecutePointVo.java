package com.api.vo.systemDataBigScreen;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 巡检执行点（有经纬度）Vo list 回显
 */
public class SDSysInspectionExecutePointVo {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 巡检执行情况主键id
     */
    private Integer executeId;
    /**
     * 巡检点编号
     */
    private String code;
    /**
     * 巡检点名称
     */
    private String name;
    /**
     * 巡检模式（1.巡检模式）【就一个模式】
     */
    private Integer type;
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
        return "SDSysInspectionExecutePointVo{" +
                "id=" + id +
                ", executeId=" + executeId +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", completeDate=" + completeDate +
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public SDSysInspectionExecutePointVo() {
    }

    public SDSysInspectionExecutePointVo(Integer id, Integer executeId, String code, String name, Integer type, BigDecimal longitude, BigDecimal latitude, Date completeDate) {
        this.id = id;
        this.executeId = executeId;
        this.code = code;
        this.name = name;
        this.type = type;
        this.longitude = longitude;
        this.latitude = latitude;
        this.completeDate = completeDate;
    }
}
