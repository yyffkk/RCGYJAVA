package com.api.model.app;

import java.util.Date;

/**
 * 用户类型 和 当前时间
 */
public class TypeAndNowDate {
    /**
     * 用户类型
     */
    private Integer type;
    /**
     * 当前时间
     */
    private Date nowDate;

    @Override
    public String toString() {
        return "typeAndNowDate{" +
                "type=" + type +
                ", nowDate=" + nowDate +
                '}';
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getNowDate() {
        return nowDate;
    }

    public void setNowDate(Date nowDate) {
        this.nowDate = nowDate;
    }

    public TypeAndNowDate() {
    }

    public TypeAndNowDate(Integer type, Date nowDate) {
        this.type = type;
        this.nowDate = nowDate;
    }
}
