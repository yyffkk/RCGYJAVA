package com.api.vo.my;

import java.util.Date;

/**
 * 我的车位Vo list  回显
 */
public class MyParkingSpaceVo {
    /**
     * 车位编号
     */
    private String code;
    /**
     * 车位类型（1.产权车位，2.临时车位）
     */
    private Integer type;
    /**
     * 有效时间结束（仅出租）
     */
    private Date effectiveTimeEnd;

    @Override
    public String toString() {
        return "MyParkingSpaceVo{" +
                "code='" + code + '\'' +
                ", type=" + type +
                ", effectiveTimeEnd=" + effectiveTimeEnd +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getEffectiveTimeEnd() {
        return effectiveTimeEnd;
    }

    public void setEffectiveTimeEnd(Date effectiveTimeEnd) {
        this.effectiveTimeEnd = effectiveTimeEnd;
    }

    public MyParkingSpaceVo() {
    }

    public MyParkingSpaceVo(String code, Integer type, Date effectiveTimeEnd) {
        this.code = code;
        this.type = type;
        this.effectiveTimeEnd = effectiveTimeEnd;
    }
}
