package com.api.vo.butlerService;

import com.api.vo.resources.VoResourcesImg;

import java.util.Date;
import java.util.List;

/**
 * 主题明细管理 Vo list 回显
 */
public class VoGambitTheme {
    /**
     * 主题明细主键id
     */
    private Integer id;
    /**
     * 话题标题
     */
    private String title;
    /**
     * 话题摘要
     */
    private String summary;
    /**
     * 发布人昵称
     */
    private String gambitNickName;
    /**
     * 发布人姓名
     */
    private String gambitName;
    /**
     * 发布内容
     */
    private String gambitContent;
    /**
     * 是否公开
     */
    private Integer isPublic;
    /**
     * 是否可评论
     */
    private Integer isRating;
    /**
     * 发布时间
     */
    private Date gambitCreateDate;
    /**
     * 评论人昵称
     */
    private String themeNickName;
    /**
     * 评论人姓名
     */
    private String themeName;
    /**
     * 评论时间
     */
    private Date themeCreateDate;
    /**
     * 评论内容
     */
    private String themeContent;
    /**
     * 评论照片集合
     */
    private List<VoResourcesImg> imgList;
    /**
     * 点赞人数
     */
    private Integer likeNum;
    /**
     * 评论人数
     */
    private Integer commentNum;
    /**
     * 状态（1.正常，0,删除）
     */
    private Integer isDelete;

    @Override
    public String toString() {
        return "VoGambitTheme{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", gambitNickName='" + gambitNickName + '\'' +
                ", gambitName='" + gambitName + '\'' +
                ", gambitContent='" + gambitContent + '\'' +
                ", isPublic=" + isPublic +
                ", isRating=" + isRating +
                ", gambitCreateDate=" + gambitCreateDate +
                ", themeNickName='" + themeNickName + '\'' +
                ", themeName='" + themeName + '\'' +
                ", themeCreateDate=" + themeCreateDate +
                ", themeContent='" + themeContent + '\'' +
                ", imgList=" + imgList +
                ", likeNum=" + likeNum +
                ", commentNum=" + commentNum +
                ", isDelete=" + isDelete +
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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getGambitNickName() {
        return gambitNickName;
    }

    public void setGambitNickName(String gambitNickName) {
        this.gambitNickName = gambitNickName;
    }

    public String getGambitName() {
        return gambitName;
    }

    public void setGambitName(String gambitName) {
        this.gambitName = gambitName;
    }

    public String getGambitContent() {
        return gambitContent;
    }

    public void setGambitContent(String gambitContent) {
        this.gambitContent = gambitContent;
    }

    public Integer getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Integer isPublic) {
        this.isPublic = isPublic;
    }

    public Integer getIsRating() {
        return isRating;
    }

    public void setIsRating(Integer isRating) {
        this.isRating = isRating;
    }

    public Date getGambitCreateDate() {
        return gambitCreateDate;
    }

    public void setGambitCreateDate(Date gambitCreateDate) {
        this.gambitCreateDate = gambitCreateDate;
    }

    public String getThemeNickName() {
        return themeNickName;
    }

    public void setThemeNickName(String themeNickName) {
        this.themeNickName = themeNickName;
    }

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

    public Date getThemeCreateDate() {
        return themeCreateDate;
    }

    public void setThemeCreateDate(Date themeCreateDate) {
        this.themeCreateDate = themeCreateDate;
    }

    public String getThemeContent() {
        return themeContent;
    }

    public void setThemeContent(String themeContent) {
        this.themeContent = themeContent;
    }

    public List<VoResourcesImg> getImgList() {
        return imgList;
    }

    public void setImgList(List<VoResourcesImg> imgList) {
        this.imgList = imgList;
    }

    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public VoGambitTheme() {
    }

    public VoGambitTheme(Integer id, String title, String summary, String gambitNickName, String gambitName, String gambitContent, Integer isPublic, Integer isRating, Date gambitCreateDate, String themeNickName, String themeName, Date themeCreateDate, String themeContent, List<VoResourcesImg> imgList, Integer likeNum, Integer commentNum, Integer isDelete) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.gambitNickName = gambitNickName;
        this.gambitName = gambitName;
        this.gambitContent = gambitContent;
        this.isPublic = isPublic;
        this.isRating = isRating;
        this.gambitCreateDate = gambitCreateDate;
        this.themeNickName = themeNickName;
        this.themeName = themeName;
        this.themeCreateDate = themeCreateDate;
        this.themeContent = themeContent;
        this.imgList = imgList;
        this.likeNum = likeNum;
        this.commentNum = commentNum;
        this.isDelete = isDelete;
    }
}
