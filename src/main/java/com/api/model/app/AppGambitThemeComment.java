package com.api.model.app;

import java.util.Date;

/**
 * app 话题主题评论信息
 */
public class AppGambitThemeComment {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 回复id 顶级评论为0
     */
    private Integer parentId;
    /**
     * 话题id(社区为-1)
     */
    private Integer gambitId;
    /**
     * 主题id
     */
    private Integer gambitThemeId;
    /**
     * 评论内容
     */
    private String content;
    /**
     * 评论人
     */
    private Integer createId;
    /**
     * 评论时间
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
     * 是否删除（1.非删,0.删除）
     */
    private Integer isDelete;

    @Override
    public String toString() {
        return "AppGambitTheme{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", gambitId=" + gambitId +
                ", gambitThemeId=" + gambitThemeId +
                ", content='" + content + '\'' +
                ", createId=" + createId +
                ", createDate=" + createDate +
                ", modifyId=" + modifyId +
                ", modifyDate=" + modifyDate +
                ", isDelete=" + isDelete +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getGambitId() {
        return gambitId;
    }

    public void setGambitId(Integer gambitId) {
        this.gambitId = gambitId;
    }

    public Integer getGambitThemeId() {
        return gambitThemeId;
    }

    public void setGambitThemeId(Integer gambitThemeId) {
        this.gambitThemeId = gambitThemeId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public AppGambitThemeComment() {
    }

    public AppGambitThemeComment(Integer id, Integer parentId, Integer gambitId, Integer gambitThemeId, String content, Integer createId, Date createDate, Integer modifyId, Date modifyDate, Integer isDelete) {
        this.id = id;
        this.parentId = parentId;
        this.gambitId = gambitId;
        this.gambitThemeId = gambitThemeId;
        this.content = content;
        this.createId = createId;
        this.createDate = createDate;
        this.modifyId = modifyId;
        this.modifyDate = modifyDate;
        this.isDelete = isDelete;
    }
}
