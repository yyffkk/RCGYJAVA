package com.api.model.butlerService;

import com.api.model.remind.SysMessage;

/**
 * 借还提醒信息
 */
public class BorrowRemind {
    /**
     * 消息列表
     */
    private SysMessage sysMessage;
    /**
     * 借还主键id
     */
    private Integer borrowId;

    @Override
    public String toString() {
        return "BorrowRemind{" +
                "sysMessage=" + sysMessage +
                ", borrowId=" + borrowId +
                '}';
    }

    public SysMessage getSysMessage() {
        return sysMessage;
    }

    public void setSysMessage(SysMessage sysMessage) {
        this.sysMessage = sysMessage;
    }

    public Integer getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(Integer borrowId) {
        this.borrowId = borrowId;
    }

    public BorrowRemind() {
    }

    public BorrowRemind(SysMessage sysMessage, Integer borrowId) {
        this.sysMessage = sysMessage;
        this.borrowId = borrowId;
    }
}
