package com.api.model.butlerApp;

import com.api.model.remind.SysMessage;

/**
 * 管家app 借还提醒信息
 */
public class ButlerBorrowRemind {
    /**
     * 消息列表
     */
    private ButlerMessage butlerMessage;
    /**
     * 借还主键id
     */
    private Integer borrowId;

    @Override
    public String toString() {
        return "ButlerBorrowRemind{" +
                "butlerMessage=" + butlerMessage +
                ", borrowId=" + borrowId +
                '}';
    }

    public ButlerMessage getButlerMessage() {
        return butlerMessage;
    }

    public void setButlerMessage(ButlerMessage butlerMessage) {
        this.butlerMessage = butlerMessage;
    }

    public Integer getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(Integer borrowId) {
        this.borrowId = borrowId;
    }

    public ButlerBorrowRemind() {
    }

    public ButlerBorrowRemind(ButlerMessage butlerMessage, Integer borrowId) {
        this.butlerMessage = butlerMessage;
        this.borrowId = borrowId;
    }
}
