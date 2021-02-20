package com.api.vo.app;

import com.api.vo.resources.VoResourcesImg;

import java.util.Date;
import java.util.List;

/**
 * 评论消息Vo list 回显
 */
public class AppCommentMessageVo {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 主题id（图片按主题图片来）
     */
    private Integer gambitThemeId;
    /**
     * 被回复人姓名，没有为null
     */
    private String respondentName;
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
     * 评论人/点赞人 姓名
     */
    private String createName;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 照片资源集合
     */
    private List<VoResourcesImg> imgUrls;

    @Override
    public String toString() {
        return "AppCommentMessageVo{" +
                "id=" + id +
                ", gambitThemeId=" + gambitThemeId +
                ", respondentName='" + respondentName + '\'' +
                ", type=" + type +
                ", content='" + content + '\'' +
                ", receiverAccount=" + receiverAccount +
                ", sendStatus=" + sendStatus +
                ", createName='" + createName + '\'' +
                ", createDate=" + createDate +
                ", imgUrls=" + imgUrls +
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

    public String getRespondentName() {
        return respondentName;
    }

    public void setRespondentName(String respondentName) {
        this.respondentName = respondentName;
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

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<VoResourcesImg> getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(List<VoResourcesImg> imgUrls) {
        this.imgUrls = imgUrls;
    }

    public AppCommentMessageVo() {
    }

    public AppCommentMessageVo(Integer id, Integer gambitThemeId, String respondentName, Integer type, String content, Integer receiverAccount, Integer sendStatus, String createName, Date createDate, List<VoResourcesImg> imgUrls) {
        this.id = id;
        this.gambitThemeId = gambitThemeId;
        this.respondentName = respondentName;
        this.type = type;
        this.content = content;
        this.receiverAccount = receiverAccount;
        this.sendStatus = sendStatus;
        this.createName = createName;
        this.createDate = createDate;
        this.imgUrls = imgUrls;
    }
}
