package com.api.model.app;

import java.util.Date;

/**
 * app延长装修信息
 */
public class AppExtendDecoration {
    /**
     * 装修主键id
     */
    private Integer decorationId;
    /**
     * 延长时间（单位为天）
     */
    private Integer extendTime;
    /**
     * 延长原因
     */
    private String extendReasons;
    /**
     * 延长预计结束时间
     */
    private Date extendDate;

    @Override
    public String toString() {
        return "AppExtendDecoration{" +
                "decorationId=" + decorationId +
                ", extendTime=" + extendTime +
                ", extendReasons='" + extendReasons + '\'' +
                ", extendDate=" + extendDate +
                '}';
    }

    public Integer getDecorationId() {
        return decorationId;
    }

    public void setDecorationId(Integer decorationId) {
        this.decorationId = decorationId;
    }

    public Integer getExtendTime() {
        return extendTime;
    }

    public void setExtendTime(Integer extendTime) {
        this.extendTime = extendTime;
    }

    public String getExtendReasons() {
        return extendReasons;
    }

    public void setExtendReasons(String extendReasons) {
        this.extendReasons = extendReasons;
    }

    public Date getExtendDate() {
        return extendDate;
    }

    public void setExtendDate(Date extendDate) {
        this.extendDate = extendDate;
    }

    public AppExtendDecoration() {
    }

    public AppExtendDecoration(Integer decorationId, Integer extendTime, String extendReasons, Date extendDate) {
        this.decorationId = decorationId;
        this.extendTime = extendTime;
        this.extendReasons = extendReasons;
        this.extendDate = extendDate;
    }
}
