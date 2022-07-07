package com.api.model.remind;

import java.util.Date;

/**
 * 消息列表
 */
public class SysMessage {
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
     * 创建时间
     */
    private Date generateDate;
    /**
     * 发送时间
     */
    private Date sendDate;
    /**
     * 发送人id（系统发送为-1）
     */
    private Integer sender;
    /**
     * 发送类型（1.系统广播，2.管理员消息）
     */
    private Integer type;

    @Override
    public String toString() {
        return "SysMessage{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", generateDate=" + generateDate +
                ", sendDate=" + sendDate +
                ", sender=" + sender +
                ", type=" + type +
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

    public Date getGenerateDate() {
        return generateDate;
    }

    public void setGenerateDate(Date generateDate) {
        this.generateDate = generateDate;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public Integer getSender() {
        return sender;
    }

    public void setSender(Integer sender) {
        this.sender = sender;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public SysMessage() {
    }

    public SysMessage(Integer id, String title, String content, Date generateDate, Date sendDate, Integer sender, Integer type) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.generateDate = generateDate;
        this.sendDate = sendDate;
        this.sender = sender;
        this.type = type;
    }
}
