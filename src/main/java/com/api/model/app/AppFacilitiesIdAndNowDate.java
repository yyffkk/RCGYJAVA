package com.api.model.app;

import java.util.Date;

/**
 * app 设施主键id 和 当前时间
 */
public class AppFacilitiesIdAndNowDate {
    /**
     * 设施主键id
     */
    private Integer facilitiesId;
    /**
     * 当前时间
     */
    private Date nowDate;

    @Override
    public String toString() {
        return "AppFacilitiesIdAndNowDate{" +
                "facilitiesId=" + facilitiesId +
                ", nowDate=" + nowDate +
                '}';
    }

    public Integer getFacilitiesId() {
        return facilitiesId;
    }

    public void setFacilitiesId(Integer facilitiesId) {
        this.facilitiesId = facilitiesId;
    }

    public Date getNowDate() {
        return nowDate;
    }

    public void setNowDate(Date nowDate) {
        this.nowDate = nowDate;
    }

    public AppFacilitiesIdAndNowDate() {
    }

    public AppFacilitiesIdAndNowDate(Integer facilitiesId, Date nowDate) {
        this.facilitiesId = facilitiesId;
        this.nowDate = nowDate;
    }
}
