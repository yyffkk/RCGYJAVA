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
     * 接收人id
     */
    private Integer receiverAccountId;

    @Override
    public String toString() {
        return "DailyPaymentPush{" +
                "sysMessage=" + sysMessage +
                ", receiverAccountId=" + receiverAccountId +
                '}';
    }

    public SysMessage getSysMessage() {
        return sysMessage;
    }

    public void setSysMessage(SysMessage sysMessage) {
        this.sysMessage = sysMessage;
    }

    public Integer getReceiverAccountId() {
        return receiverAccountId;
    }

    public void setReceiverAccountId(Integer receiverAccountId) {
        this.receiverAccountId = receiverAccountId;
    }

    public DailyPaymentPush() {
    }

    public DailyPaymentPush(SysMessage sysMessage, Integer receiverAccountId) {
        this.sysMessage = sysMessage;
        this.receiverAccountId = receiverAccountId;
    }
}
