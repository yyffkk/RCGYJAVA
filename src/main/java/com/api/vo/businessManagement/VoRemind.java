package com.api.vo.businessManagement;

import java.util.Date;

/**
 * 提醒通知Vo list 回显
 */
public class VoRemind {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 标题
     */
    private String title;
    /**
     * 消息内容
     */
    private String content;
    /**
     * 发送时间
     */
    private Date sendDate;
    /**
     * 发送人姓名
     */
    private String senderName;
    /**
     * 发送类型（1.系统广播，2.管理员消息）
     */
    private Integer type;
    /**
     * 接收人姓名
     */
    private String receiverAccountName;
    /**
     * 发送状态（1.发送成功（未读），3.已读）
     */
    private Integer sendStatus;

    @Override
    public String toString() {
        return "VoRemind{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", sendDate=" + sendDate +
                ", senderName='" + senderName + '\'' +
                ", type=" + type +
                ", receiverAccountName='" + receiverAccountName + '\'' +
                ", sendStatus=" + sendStatus +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getReceiverAccountName() {
        return receiverAccountName;
    }

    public void setReceiverAccountName(String receiverAccountName) {
        this.receiverAccountName = receiverAccountName;
    }

    public Integer getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(Integer sendStatus) {
        this.sendStatus = sendStatus;
    }

    public VoRemind() {
    }

    public VoRemind(Integer id, String title, String content, Date sendDate, String senderName, Integer type, String receiverAccountName, Integer sendStatus) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.sendDate = sendDate;
        this.senderName = senderName;
        this.type = type;
        this.receiverAccountName = receiverAccountName;
        this.sendStatus = sendStatus;
    }
}
