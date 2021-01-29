package com.api.model.app;

import java.util.Date;

/**
 * app点赞信息model
 */
public class AppGambitThemeLike {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 话题id（社区为-1）
     */
    private Integer gambitId;
    /**
     * 主题id
     */
    private Integer gambitThemeId;
    /**
     * 点赞人
     */
    private Integer createId;
    /**
     * 点赞时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "AppGambitThemeLike{" +
                "id=" + id +
                ", gambitId=" + gambitId +
                ", gambitThemeId=" + gambitThemeId +
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

    public AppGambitThemeLike() {
    }

    public AppGambitThemeLike(Integer id, Integer gambitId, Integer gambitThemeId, Integer createId, Date createDate) {
        this.id = id;
        this.gambitId = gambitId;
        this.gambitThemeId = gambitThemeId;
        this.createId = createId;
        this.createDate = createDate;
    }
}
