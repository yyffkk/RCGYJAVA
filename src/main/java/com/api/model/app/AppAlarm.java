package com.api.model.app;

import java.util.Date;

/**
 * app 报警model 信息
 */
public class AppAlarm {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 房产id
     */
    private Integer estateId;
    /**
     * 创建人
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "AppAlarm{" +
                "id=" + id +
                ", estateId=" + estateId +
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

    public Integer getEstateId() {
        return estateId;
    }

    public void setEstateId(Integer estateId) {
        this.estateId = estateId;
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

    public AppAlarm() {
    }

    public AppAlarm(Integer id, Integer estateId, Integer createId, Date createDate) {
        this.id = id;
        this.estateId = estateId;
        this.createId = createId;
        this.createDate = createDate;
    }
}
