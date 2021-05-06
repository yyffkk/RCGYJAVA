package com.api.model.chargeManagement;

import com.api.model.remind.SysMessage;


/**
 * 日常缴费推送信息
 */
public class DailyPaymentPush {
    /**
     * 消息列表
     */
    private SysMessage sysMessage;
    /**
     * 日常缴费主键id
     */
    private Integer dailyPaymentId;

    @Override
    public String toString() {
        return "DailyPaymentPush{" +
                "sysMessage=" + sysMessage +
                ", dailyPaymentId=" + dailyPaymentId +
                '}';
    }

    public SysMessage getSysMessage() {
        return sysMessage;
    }

    public void setSysMessage(SysMessage sysMessage) {
        this.sysMessage = sysMessage;
    }

    public Integer getDailyPaymentId() {
        return dailyPaymentId;
    }

    public void setDailyPaymentId(Integer dailyPaymentId) {
        this.dailyPaymentId = dailyPaymentId;
    }

    public DailyPaymentPush() {
    }

    public DailyPaymentPush(SysMessage sysMessage, Integer dailyPaymentId) {
        this.sysMessage = sysMessage;
        this.dailyPaymentId = dailyPaymentId;
    }
}
