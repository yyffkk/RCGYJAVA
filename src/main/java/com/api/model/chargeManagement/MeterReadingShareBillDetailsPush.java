package com.api.model.chargeManagement;

import com.api.model.remind.SysMessage;

/**
 * 抄表公摊账单明细推送信息
 */
public class MeterReadingShareBillDetailsPush {
    /**
     * 消息列表
     */
    private SysMessage sysMessage;
    /**
     * 公摊账单主键id
     */
    private Integer shareBillDetailsId;

    @Override
    public String toString() {
        return "MeterReadingShareBillDetailsPush{" +
                "sysMessage=" + sysMessage +
                ", shareBillDetailsId=" + shareBillDetailsId +
                '}';
    }

    public SysMessage getSysMessage() {
        return sysMessage;
    }

    public void setSysMessage(SysMessage sysMessage) {
        this.sysMessage = sysMessage;
    }

    public Integer getShareBillDetailsId() {
        return shareBillDetailsId;
    }

    public void setShareBillDetailsId(Integer shareBillDetailsId) {
        this.shareBillDetailsId = shareBillDetailsId;
    }

    public MeterReadingShareBillDetailsPush() {
    }

    public MeterReadingShareBillDetailsPush(SysMessage sysMessage, Integer shareBillDetailsId) {
        this.sysMessage = sysMessage;
        this.shareBillDetailsId = shareBillDetailsId;
    }
}
