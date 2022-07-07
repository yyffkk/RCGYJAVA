package com.api.model.app;

import java.util.Date;

/**
 * 评论通知消息列表
 */
public class AppCommentMessage {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 主题id（图片按主题图片来）
     */
    private Integer gambitThemeId;
    /**
     * 被回复人id，没有为-1
     */
    private Integer respondentId;
    /**
     * 类型：1.评论，2.点赞
     */
    private Integer type;
    /**
     * 内容
     */
    private String content;
    /**
     * 接收人id
     */
    private Integer receiverAccount;
    /**
     * 发送状态（0.未发或不成功，1.发送成功（未读），3.已读）
     */
    private Integer sendStatus;
    /**
     * 评论人/点赞人
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "AppCommentMessage{" +
                "id=" + id +
                ", gambitThemeId=" + gambitThemeId +
                ", respondentId=" + respondentId +
                ", type=" + type +
                ", content='" + content + '\'' +
                ", receiverAccount=" + receiverAccount +
                ", sendStatus=" + sendStatus +
                ", createId=" + createId +
                ", createDate=" + createDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGambitThemeId() {
        return gambitThemeId;
    }

    public void setGambitThemeId(Integer gambitThemeId) {
        this.gambitThemeId = gambitThemeId;
    }

    public Integer getRespondentId() {
        return respondentId;
    }

    public void setRespondentId(Integer respondentId) {
        this.respondentId = respondentId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public AppCommentMessage() {
    }

    public AppCommentMessage(Integer id, Integer gambitThemeId, Integer respondentId, Integer type, String content, Integer receiverAccount, Integer sendStatus, Integer createId, Date createDate) {
        this.id = id;
        this.gambitThemeId = gambitThemeId;
        this.respondentId = respondentId;
        this.type = type;
        this.content = content;
        this.receiverAccount = receiverAccount;
        this.sendStatus = sendStatus;
        this.createId = createId;
        this.createDate = createDate;
    }
}
