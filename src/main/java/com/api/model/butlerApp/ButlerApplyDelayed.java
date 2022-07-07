package com.api.model.butlerApp;

import java.util.Date;

/**
 * 管家app 申请延时信息 model
 */
public class ButlerApplyDelayed {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 派工单id
     */
    private Integer dispatchListId;
    /**
     * 处理进程记录id
     */
    private Integer processRecordId;
    /**
     * 延时时间(1:24h,2:48h,3:72h,4:未知)
     */
    private Integer delayedTime;
    /**
     * 备注
     */
    private String remake;
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
        return "ButlerApplyDelayed{" +
                "id=" + id +
                ", dispatchListId=" + dispatchListId +
                ", processRecordId=" + processRecordId +
                ", delayedTime=" + delayedTime +
                ", remake='" + remake + '\'' +
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

    public Integer getDispatchListId() {
        return dispatchListId;
    }

    public void setDispatchListId(Integer dispatchListId) {
        this.dispatchListId = dispatchListId;
    }

    public Integer getProcessRecordId() {
        return processRecordId;
    }

    public void setProcessRecordId(Integer processRecordId) {
        this.processRecordId = processRecordId;
    }

    public Integer getDelayedTime() {
        return delayedTime;
    }

    public void setDelayedTime(Integer delayedTime) {
        this.delayedTime = delayedTime;
    }

    public String getRemake() {
        return remake;
    }

    public void setRemake(String remake) {
        this.remake = remake;
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

    public ButlerApplyDelayed() {
    }

    public ButlerApplyDelayed(Integer id, Integer dispatchListId, Integer processRecordId, Integer delayedTime, String remake, Integer createId, Date createDate) {
        this.id = id;
        this.dispatchListId = dispatchListId;
        this.processRecordId = processRecordId;
        this.delayedTime = delayedTime;
        this.remake = remake;
        this.createId = createId;
        this.createDate = createDate;
    }
}
