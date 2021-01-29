package com.api.model.app;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * app主题信息
 */
public class AppGambitTheme {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 话题id(社区为-1)
     */
    private Integer gambitId;
    /**
     * 内容（内容和图片两者必须有一个）
     */
    private String content;
    /**
     * 点赞数量（默认为0）
     */
    private Integer likes;
    /**
     * 是否可以评论（默认1.可以）（1.可以，0.不可以）
     */
    private Integer isComment;
    /**
     * 是否公开（1.是，0否）
     */
    private Integer isPublic;
    /**
     * 发布人（取自业主表）
     */
    private Integer createId;
    /**
     * 发布时间
     */
    private Date createDate;
    /**
     * 修改人
     */
    private Integer modifyId;
    /**
     * 修改时间
     */
    private Date modifyDate;
    /**
     * 是否删除（1.非删，0.删除）
     */
    private Integer isDelete;
    /**
     * 照片路径数组
     */
    private String[] imgUrls;

    @Override
    public String toString() {
        return "AppGambitTheme{" +
                "id=" + id +
                ", gambitId=" + gambitId +
                ", content='" + content + '\'' +
                ", likes=" + likes +
                ", isComment=" + isComment +
                ", isPublic=" + isPublic +
                ", createId=" + createId +
                ", createDate=" + createDate +
                ", modifyId=" + modifyId +
                ", modifyDate=" + modifyDate +
                ", isDelete=" + isDelete +
                ", imgUrls=" + Arrays.toString(imgUrls) +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGambitId() {
        return gambitId;
    }

    public void setGambitId(Integer gambitId) {
        this.gambitId = gambitId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getIsComment() {
        return isComment;
    }

    public void setIsComment(Integer isComment) {
        this.isComment = isComment;
    }

    public Integer getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Integer isPublic) {
        this.isPublic = isPublic;
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

    public Integer getModifyId() {
        return modifyId;
    }

    public void setModifyId(Integer modifyId) {
        this.modifyId = modifyId;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String[] getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(String[] imgUrls) {
        this.imgUrls = imgUrls;
    }

    public AppGambitTheme() {
    }

    public AppGambitTheme(Integer id, Integer gambitId, String content, Integer likes, Integer isComment, Integer isPublic, Integer createId, Date createDate, Integer modifyId, Date modifyDate, Integer isDelete, String[] imgUrls) {
        this.id = id;
        this.gambitId = gambitId;
        this.content = content;
        this.likes = likes;
        this.isComment = isComment;
        this.isPublic = isPublic;
        this.createId = createId;
        this.createDate = createDate;
        this.modifyId = modifyId;
        this.modifyDate = modifyDate;
        this.isDelete = isDelete;
        this.imgUrls = imgUrls;
    }
}
