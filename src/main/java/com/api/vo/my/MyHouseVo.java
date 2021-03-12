package com.api.vo.my;

import java.util.Date;

/**
 * 我的房屋Vo list 回显
 */
public class MyHouseVo {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 房产信息
     */
    private String roomName;
    /**
     * 审核状态（1.未审核，3.审核失败，4.审核成功）
     */
    private Integer status;
    /**
     * 有效时间开始（只限租客）
     */
    private Date effectiveTimeStart;
    /**
     * 有效时间结束（只限租客）
     */
    private Date effectiveTimeEnd;

    @Override
    public String toString() {
        return "MyHouseVo{" +
                "id=" + id +
                ", roomName='" + roomName + '\'' +
                ", status=" + status +
                ", effectiveTimeStart=" + effectiveTimeStart +
                ", effectiveTimeEnd=" + effectiveTimeEnd +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getEffectiveTimeStart() {
        return effectiveTimeStart;
    }

    public void setEffectiveTimeStart(Date effectiveTimeStart) {
        this.effectiveTimeStart = effectiveTimeStart;
    }

    public Date getEffectiveTimeEnd() {
        return effectiveTimeEnd;
    }

    public void setEffectiveTimeEnd(Date effectiveTimeEnd) {
        this.effectiveTimeEnd = effectiveTimeEnd;
    }

    public MyHouseVo() {
    }

    public MyHouseVo(Integer id, String roomName, Integer status, Date effectiveTimeStart, Date effectiveTimeEnd) {
        this.id = id;
        this.roomName = roomName;
        this.status = status;
        this.effectiveTimeStart = effectiveTimeStart;
        this.effectiveTimeEnd = effectiveTimeEnd;
    }
}