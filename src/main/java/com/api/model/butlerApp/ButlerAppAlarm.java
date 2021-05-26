package com.api.model.butlerApp;

import java.util.Date;

/**
 * 管家app 报警model 信息
 */
public class ButlerAppAlarm {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 创建人id（物业）
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "ButlerAppAlarm{" +
                "id=" + id +
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

    public ButlerAppAlarm() {
    }

    public ButlerAppAlarm(Integer id, Integer createId, Date createDate) {
        this.id = id;
        this.createId = createId;
        this.createDate = createDate;
    }
}
