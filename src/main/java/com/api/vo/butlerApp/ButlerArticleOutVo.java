package com.api.vo.butlerApp;

import java.util.Date;

/**
 * 管家app 物品出户Vo list 回显
 */
public class ButlerArticleOutVo {
    /**
     * 物品出户主键id
     */
    private Integer id;
    /**
     * 状态(1.待出门，2.已出门，3.驳回申请)
     */
    private Integer status;
    /**
     * 详细地址（房产名称）
     */
    private String roomName;
    /**
     * 出户人（申请人）
     */
    private String applicantName;
    /**
     * 身份（1业主，2亲属，3租客）
     */
    private Integer identity;
    /**
     * 出户物品
     */
    private String articleOutName;
    /**
     * 预计出户时间
     */
    private Date expectedTime;

    @Override
    public String toString() {
        return "ButlerArticleOutVo{" +
                "id=" + id +
                ", status=" + status +
                ", roomName='" + roomName + '\'' +
                ", applicantName='" + applicantName + '\'' +
                ", identity=" + identity +
                ", articleOutName='" + articleOutName + '\'' +
                ", expectedTime=" + expectedTime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public Integer getIdentity() {
        return identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }

    public String getArticleOutName() {
        return articleOutName;
    }

    public void setArticleOutName(String articleOutName) {
        this.articleOutName = articleOutName;
    }

    public Date getExpectedTime() {
        return expectedTime;
    }

    public void setExpectedTime(Date expectedTime) {
        this.expectedTime = expectedTime;
    }

    public ButlerArticleOutVo() {
    }

    public ButlerArticleOutVo(Integer id, Integer status, String roomName, String applicantName, Integer identity, String articleOutName, Date expectedTime) {
        this.id = id;
        this.status = status;
        this.roomName = roomName;
        this.applicantName = applicantName;
        this.identity = identity;
        this.articleOutName = articleOutName;
        this.expectedTime = expectedTime;
    }
}
