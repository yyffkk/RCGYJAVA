package com.api.model.chargeManagement;

import com.api.model.remind.SysMessage;

/**
 * 抄表公摊账单推送信息
 */
public class MeterReadingShareBillPush {
    /**
     * 消息列表
     */
    private SysMessage sysMessage;
    /**
     * 公摊账单主键id
     */
    private Integer shareBillId;

    @Override
    public String toString() {
        return "MeterReadingShareBillPush{" +
                "sysMessage=" + sysMessage +
                ", shareBillId=" + shareBillId +
                '}';
    }

    public SysMessage getSysMessage() {
        return sysMessage;
    }

    public void setSysMessage(SysMessage sysMessage) {
        this.sysMessage = sysMessage;
    }

    public Integer getShareBillId() {
        return shareBillId;
    }

    public void setShareBillId(Integer shareBillId) {
        this.shareBillId = shareBillId;
    }

    public MeterReadingShareBillPush() {
    }

    public MeterReadingShareBillPush(SysMessage sysMessage, Integer shareBillId) {
        this.sysMessage = sysMessage;
        this.shareBillId = shareBillId;
    }
}
