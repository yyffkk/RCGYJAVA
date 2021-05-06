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
    private Integer DailyPaymentId;

    @Override
    public String toString() {
        return "DailyPaymentPush{" +
                "sysMessage=" + sysMessage +
                ", DailyPaymentId=" + DailyPaymentId +
                '}';
    }

    public SysMessage getSysMessage() {
        return sysMessage;
    }

    public void setSysMessage(SysMessage sysMessage) {
        this.sysMessage = sysMessage;
    }

    public Integer getDailyPaymentId() {
        return DailyPaymentId;
    }

    public void setDailyPaymentId(Integer dailyPaymentId) {
        DailyPaymentId = dailyPaymentId;
    }

    public DailyPaymentPush() {
    }

    public DailyPaymentPush(SysMessage sysMessage, Integer dailyPaymentId) {
        this.sysMessage = sysMessage;
        DailyPaymentId = dailyPaymentId;
    }
}
