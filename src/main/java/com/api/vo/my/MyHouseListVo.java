package com.api.vo.my;

import java.util.Date;

/**
 * 我的房屋住房Vo list 回显
 */
public class MyHouseListVo {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 房产id
     */
    private Integer estateId;
    /**
     * 房产信息
     */
    private String roomName;
    /**
     * 住户类型（1 业主，2亲属，3租客，4.游客）
     */
    private Integer type;
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
        return "MyHouseListVo{" +
                "id=" + id +
                ", estateId=" + estateId +
                ", roomName='" + roomName + '\'' +
                ", type=" + type +
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

    public Integer getEstateId() {
        return estateId;
    }

    public void setEstateId(Integer estateId) {
        this.estateId = estateId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public MyHouseListVo() {
    }

    public MyHouseListVo(Integer id, Integer estateId, String roomName, Integer type, Date effectiveTimeStart, Date effectiveTimeEnd) {
        this.id = id;
        this.estateId = estateId;
        this.roomName = roomName;
        this.type = type;
        this.effectiveTimeStart = effectiveTimeStart;
        this.effectiveTimeEnd = effectiveTimeEnd;
    }
}
