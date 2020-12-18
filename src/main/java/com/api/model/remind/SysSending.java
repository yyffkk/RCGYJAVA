package com.api.model.remind;

import java.util.Date;

/**
 * 消息接收列表
 */
public class SysSending {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 消息id
     */
    private Integer messageId;
    /**
     * 接收人id
     */
    private Integer receiverAccount;
    /**
     * 发送日期
     */
    private Date sendDate;
    /**
     * 发送状态（0.未发或不成功1.发送成功，3.已读）
     */
    private Integer sendStatus;

    @Override
    public String toString() {
        return "SysSending{" +
                "id=" + id +
                ", messageId=" + messageId +
                ", receiverAccount=" + receiverAccount +
                ", sendDate=" + sendDate +
                ", sendStatus=" + sendStatus +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public Integer getReceiverAccount() {
        return receiverAccount;
    }

    public void setReceiverAccount(Integer receiverAccount) {
        this.receiverAccount = receiverAccount;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public Integer getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(Integer sendStatus) {
        this.sendStatus = sendStatus;
    }

    public SysSending() {
    }

    public SysSending(Integer id, Integer messageId, Integer receiverAccount, Date sendDate, Integer sendStatus) {
        this.id = id;
        this.messageId = messageId;
        this.receiverAccount = receiverAccount;
        this.sendDate = sendDate;
        this.sendStatus = sendStatus;
    }
}
