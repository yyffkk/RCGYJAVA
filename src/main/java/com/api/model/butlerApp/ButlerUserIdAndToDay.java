package com.api.model.butlerApp;

import java.util.Date;

/**
 * 管家app 用户主键id 和 当前时间
 */
public class ButlerUserIdAndToDay {
    /**
     * 用户主键id
     */
    private Integer userId;
    /**
     * 当前时间
     */
    private Date toDay;

    @Override
    public String toString() {
        return "ButlerUserIdAndToDay{" +
                "userId=" + userId +
                ", toDay=" + toDay +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getToDay() {
        return toDay;
    }

    public void setToDay(Date toDay) {
        this.toDay = toDay;
    }

    public ButlerUserIdAndToDay() {
    }

    public ButlerUserIdAndToDay(Integer userId, Date toDay) {
        this.userId = userId;
        this.toDay = toDay;
    }
}
