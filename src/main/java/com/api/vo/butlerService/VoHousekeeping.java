package com.api.vo.butlerService;

import java.util.Date;

/**
 * 家政服务 Vo list 回显
 */
public class VoHousekeeping {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 家政房产名称
     */
    private String roomName;
    /**
     * 家政人数
     */
    private Integer num;
    /**
     * 家政负责人名称
     */
    private String leaderName;
    /**
     * 家政负责人手机号
     */
    private String leaderTel;
    /**
     * 家政内容
     */
    private String content;
    /**
     * 创建人名称
     */
    private String createName;
    /**
     * 创建时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "VoHousekeeping{" +
                "id=" + id +
                ", roomName='" + roomName + '\'' +
                ", num=" + num +
                ", leaderName='" + leaderName + '\'' +
                ", leaderTel='" + leaderTel + '\'' +
                ", content='" + content + '\'' +
                ", createName='" + createName + '\'' +
                ", createDate=" + createDate +
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

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public String getLeaderTel() {
        return leaderTel;
    }

    public void setLeaderTel(String leaderTel) {
        this.leaderTel = leaderTel;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public VoHousekeeping() {
    }

    public VoHousekeeping(Integer id, String roomName, Integer num, String leaderName, String leaderTel, String content, String createName, Date createDate) {
        this.id = id;
        this.roomName = roomName;
        this.num = num;
        this.leaderName = leaderName;
        this.leaderTel = leaderTel;
        this.content = content;
        this.createName = createName;
        this.createDate = createDate;
    }
}
