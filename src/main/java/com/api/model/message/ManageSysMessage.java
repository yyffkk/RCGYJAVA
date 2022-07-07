package com.api.model.message;

import java.util.Date;

/**
 * 后台消息列表 model
 */
public class ManageSysMessage {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 消息内容
     */
    private String content;
    /**
     * 消息类型（1.报事报修，2.装修，3.绿化任务，4.卫生任务,5.家政服务,6.建议咨询，7.订单）
     */
    private Integer type;
    /**
     * 关联的主键id（报事报修id,装修id,绿化任务id,卫生任务id，新版家政服务主键id,建议咨询主键id，7.订单）
     */
    private Integer relationId;
    /**
     * 接收人id
     */
    private Integer receiverAccountId;
    /**
     * 发送人id（消息传出方）
     */
    private Integer senderId;
    /**
     * 发送人类型：1.管家，2.业主
     */
    private Integer senderType;
    /**
     * 发送状态（0.未发或不成功，1.发送成功（未读）3.已读）
     */
    private Integer sendStatus;
    /**
     * 发送时间
     */
    private Date sendDate;

    @Override
    public String toString() {
        return "ManageSysMessage{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", type=" + type +
                ", relationId=" + relationId +
                ", receiverAccountId=" + receiverAccountId +
                ", senderId=" + senderId +
                ", senderType=" + senderType +
                ", sendStatus=" + sendStatus +
                ", sendDate=" + sendDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getRelationId() {
        return relationId;
    }

    public void setRelationId(Integer relationId) {
        this.relationId = relationId;
    }

    public Integer getReceiverAccountId() {
        return receiverAccountId;
    }

    public void setReceiverAccountId(Integer receiverAccountId) {
        this.receiverAccountId = receiverAccountId;
    }

    public Integer getSenderId() {
        return senderId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    public Integer getSenderType() {
        return senderType;
    }

    public void setSenderType(Integer senderType) {
        this.senderType = senderType;
    }

    public Integer getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(Integer sendStatus) {
        this.sendStatus = sendStatus;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public ManageSysMessage() {
    }

    public ManageSysMessage(Integer id, String content, Integer type, Integer relationId, Integer receiverAccountId, Integer senderId, Integer senderType, Integer sendStatus, Date sendDate) {
        this.id = id;
        this.content = content;
        this.type = type;
        this.relationId = relationId;
        this.receiverAccountId = receiverAccountId;
        this.senderId = senderId;
        this.senderType = senderType;
        this.sendStatus = sendStatus;
        this.sendDate = sendDate;
    }
}
