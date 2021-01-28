package com.api.vo.app;

import com.api.vo.resources.VoResourcesImg;

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
                ", createName='" + createName + '\'' +
                ", content='" + content + '\'' +
                ", gambitTitle='" + gambitTitle + '\'' +
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

    public AppGambitThemeVo(Integer id, Integer createId, String createName, String content, String gambitTitle, List<VoResourcesImg> imgUrls, List<VoResourcesImg> headSculptureImgUrl, List<AppGambitThemeCommentVo> gambitThemeCommentVoList) {
        this.id = id;
        this.createId = createId;
        this.createName = createName;
        this.content = content;
        this.gambitTitle = gambitTitle;
        this.imgUrls = imgUrls;
        this.headSculptureImgUrl = headSculptureImgUrl;
        this.gambitThemeCommentVoList = gambitThemeCommentVoList;
    }
}
