package com.api.vo.butlerService;

import java.util.Date;

/**
 * 候选人投票详情信息
 */
public class VoVotePersonnel {
    /**
     * 投票人主键
     */
    private Integer id;
    /**
     * 住户房号 楼栋-单元-房间号
     */
    private String roomName;
    /**
     * 投票人id(住户)
     */
    private Integer voterId;
    /**
     * 住户姓名
     */
    private String name;
    /**
     * 住户手机号
     */
    private String tel;
    /**
     * 投票时间
     */
    private Date voterDate;

    @Override
    public String toString() {
        return "VoVotePersonnel{" +
                "id=" + id +
                ", roomName='" + roomName + '\'' +
                ", voterId=" + voterId +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", voterDate=" + voterDate +
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

    public Integer getVoterId() {
        return voterId;
    }

    public void setVoterId(Integer voterId) {
        this.voterId = voterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getVoterDate() {
        return voterDate;
    }

    public void setVoterDate(Date voterDate) {
        this.voterDate = voterDate;
    }

    public VoVotePersonnel() {
    }

    public VoVotePersonnel(Integer id, String roomName, Integer voterId, String name, String tel, Date voterDate) {
        this.id = id;
        this.roomName = roomName;
        this.voterId = voterId;
        this.name = name;
        this.tel = tel;
        this.voterDate = voterDate;
    }
}
