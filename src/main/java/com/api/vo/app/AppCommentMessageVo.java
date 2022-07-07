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
     * 发送状态（0.未发或不成功，1.发送成功（未读），3.已读）
     */
    private Integer sendStatus;
    /**
     * 评论人/点赞人 id
     */
    private Integer createId;
    /**
     * 评论人/点赞人 姓名
     */
    private String createName;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 主题照片资源集合
     */
    private List<VoResourcesImg> imgUrls;
    /**
     * 评论人/点赞人 头像集合
     */
    private List<VoResourcesImg> headSculpture;

    @Override
    public String toString() {
        return "AppCommentMessageVo{" +
                "id=" + id +
                ", gambitThemeId=" + gambitThemeId +
                ", respondentName='" + respondentName + '\'' +
                ", type=" + type +
                ", content='" + content + '\'' +
                ", sendStatus=" + sendStatus +
                ", createId=" + createId +
                ", createName='" + createName + '\'' +
                ", createDate=" + createDate +
                ", imgUrls=" + imgUrls +
                ", headSculpture=" + headSculpture +
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

    public List<VoResourcesImg> getHeadSculpture() {
        return headSculpture;
    }

    public void setHeadSculpture(List<VoResourcesImg> headSculpture) {
        this.headSculpture = headSculpture;
    }

    public AppCommentMessageVo() {
    }

    public AppCommentMessageVo(Integer id, Integer gambitThemeId, String respondentName, Integer type, String content, Integer sendStatus, Integer createId, String createName, Date createDate, List<VoResourcesImg> imgUrls, List<VoResourcesImg> headSculpture) {
        this.id = id;
        this.gambitThemeId = gambitThemeId;
        this.respondentName = respondentName;
        this.type = type;
        this.content = content;
        this.sendStatus = sendStatus;
        this.createId = createId;
        this.createName = createName;
        this.createDate = createDate;
        this.imgUrls = imgUrls;
        this.headSculpture = headSculpture;
    }
}
