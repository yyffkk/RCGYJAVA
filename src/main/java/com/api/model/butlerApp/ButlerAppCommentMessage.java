package com.api.model.butlerApp;

import java.util.Date;

/**
 * 管家app 评价消息model
 */
public class ButlerAppCommentMessage {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 消息类型（1.报事报修）
     */
    private Integer type;
    /**
     * 关联的主键id（工单表主键id）
     */
    private Integer relationId;
    /**
     * 接收人id
     */
    private Integer receiverAccount;
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
        return "ButlerAppCommentMessage{" +
                "id=" + id +
                ", type=" + type +
                ", relationId=" + relationId +
                ", receiverAccount=" + receiverAccount +
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

    public Integer getReceiverAccount() {
        return receiverAccount;
    }

    public void setReceiverAccount(Integer receiverAccount) {
        this.receiverAccount = receiverAccount;
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

    public ButlerAppCommentMessage() {
    }

    public ButlerAppCommentMessage(Integer id, Integer type, Integer relationId, Integer receiverAccount, Integer sendStatus, Date sendDate) {
        this.id = id;
        this.type = type;
        this.relationId = relationId;
        this.receiverAccount = receiverAccount;
        this.sendStatus = sendStatus;
        this.sendDate = sendDate;
    }
}
