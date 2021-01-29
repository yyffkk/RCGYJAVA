package com.api.vo.app;

import com.api.vo.resources.VoResourcesImg;

import java.util.Date;
import java.util.List;

/**
 * app最新主题信息Vo list 回显
 */
public class AppGambitThemeVo {
    /**
     * 主题id
     */
    private Integer id;
    /**
     * 发布人id
     */
    private Integer createId;
    /**
     * 是否可以评论（默认1.可以）（1.可以，0.不可以）
     */
    private Integer isComment;
    /**
     * 该用户是否点赞（1.已点赞，0.未点赞）
     */
    private Integer isLike;
    /**
     * 发布人
     */
    private String createName;
    /**
     * 主题内容
     */
    private String content;
    /**
     * 话题摘要
     */
    private String gambitTitle;
    /**
     * 发布时间
     */
    private Date createDate;
    /**
     * 点赞人信息
     */
    private List<IdAndName> likeNames;
    /**
     * 主题照片内容
     */
    private List<VoResourcesImg> imgUrls;
    /**
     * 发布人头像信息
     */
    private List<VoResourcesImg> headSculptureImgUrl;
    /**
     * 主题评论信息集合
     */
    private List<AppGambitThemeCommentVo> gambitThemeCommentVoList;

    @Override
    public String toString() {
        return "AppGambitThemeVo{" +
                "id=" + id +
                ", createId=" + createId +
                ", isComment=" + isComment +
                ", isLike=" + isLike +
                ", createName='" + createName + '\'' +
                ", content='" + content + '\'' +
                ", gambitTitle='" + gambitTitle + '\'' +
                ", createDate=" + createDate +
                ", likeNames=" + likeNames +
                ", imgUrls=" + imgUrls +
                ", headSculptureImgUrl=" + headSculptureImgUrl +
                ", gambitThemeCommentVoList=" + gambitThemeCommentVoList +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public Integer getIsComment() {
        return isComment;
    }

    public void setIsComment(Integer isComment) {
        this.isComment = isComment;
    }

    public Integer getIsLike() {
        return isLike;
    }

    public void setIsLike(Integer isLike) {
        this.isLike = isLike;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getGambitTitle() {
        return gambitTitle;
    }

    public void setGambitTitle(String gambitTitle) {
        this.gambitTitle = gambitTitle;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<IdAndName> getLikeNames() {
        return likeNames;
    }

    public void setLikeNames(List<IdAndName> likeNames) {
        this.likeNames = likeNames;
    }

    public List<VoResourcesImg> getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(List<VoResourcesImg> imgUrls) {
        this.imgUrls = imgUrls;
    }

    public List<VoResourcesImg> getHeadSculptureImgUrl() {
        return headSculptureImgUrl;
    }

    public void setHeadSculptureImgUrl(List<VoResourcesImg> headSculptureImgUrl) {
        this.headSculptureImgUrl = headSculptureImgUrl;
    }

    public List<AppGambitThemeCommentVo> getGambitThemeCommentVoList() {
        return gambitThemeCommentVoList;
    }

    public void setGambitThemeCommentVoList(List<AppGambitThemeCommentVo> gambitThemeCommentVoList) {
        this.gambitThemeCommentVoList = gambitThemeCommentVoList;
    }

    public AppGambitThemeVo() {
    }

    public AppGambitThemeVo(Integer id, Integer createId, Integer isComment, Integer isLike, String createName, String content, String gambitTitle, Date createDate, List<IdAndName> likeNames, List<VoResourcesImg> imgUrls, List<VoResourcesImg> headSculptureImgUrl, List<AppGambitThemeCommentVo> gambitThemeCommentVoList) {
        this.id = id;
        this.createId = createId;
        this.isComment = isComment;
        this.isLike = isLike;
        this.createName = createName;
        this.content = content;
        this.gambitTitle = gambitTitle;
        this.createDate = createDate;
        this.likeNames = likeNames;
        this.imgUrls = imgUrls;
        this.headSculptureImgUrl = headSculptureImgUrl;
        this.gambitThemeCommentVoList = gambitThemeCommentVoList;
    }
}
