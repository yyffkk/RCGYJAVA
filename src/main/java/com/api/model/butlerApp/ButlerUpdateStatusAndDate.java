package com.api.model.butlerApp;

import java.util.Date;

/**
 * 管家app 修改派工单状态和时间
 */
public class ButlerUpdateStatusAndDate {
    /**
     * 派工单主键id
     */
    private Integer dispatchListId;
    /**
     * 派工单状态
     */
    private Integer status;
    /**
     * 派工单时间（处理开始时间或处理结束时间）
     */
    private Date updateDate;

    @Override
    public String toString() {
        return "ButlerUpdateStatusAndDate{" +
                "dispatchListId=" + dispatchListId +
                ", status=" + status +
                ", updateDate=" + updateDate +
                '}';
    }

    public Integer getDispatchListId() {
        return dispatchListId;
    }

    public void setDispatchListId(Integer dispatchListId) {
        this.dispatchListId = dispatchListId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public ButlerUpdateStatusAndDate() {
    }

    public ButlerUpdateStatusAndDate(Integer dispatchListId, Integer status, Date updateDate) {
        this.dispatchListId = dispatchListId;
        this.status = status;
        this.updateDate = updateDate;
    }
}
