package com.api.vo.my;

import java.util.Date;

/**
 * 我的车辆Vo list  回显
 */
public class MyCarVo {
    /**
     * 车牌号
     */
    private String code;
    /**
     * 车辆状态（1.产权车位2.包年3.包月4.临时）
     */
    private Integer status;
    /**
     * 有效时间结束（仅包年，包月）
     */
    private Date effectiveTimeEnd;

    @Override
    public String toString() {
        return "MyCarVo{" +
                "code='" + code + '\'' +
                ", status=" + status +
                ", effectiveTimeEnd=" + effectiveTimeEnd +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getEffectiveTimeEnd() {
        return effectiveTimeEnd;
    }

    public void setEffectiveTimeEnd(Date effectiveTimeEnd) {
        this.effectiveTimeEnd = effectiveTimeEnd;
    }

    public MyCarVo() {
    }

    public MyCarVo(String code, Integer status, Date effectiveTimeEnd) {
        this.code = code;
        this.status = status;
        this.effectiveTimeEnd = effectiveTimeEnd;
    }
}
