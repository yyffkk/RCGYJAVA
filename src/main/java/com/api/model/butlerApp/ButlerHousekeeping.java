package com.api.model.butlerApp;

import java.util.Date;

/**
 * 管家app 家政服务model
 */
public class ButlerHousekeeping {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 家政房产id
     */
    private Integer estateId;
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
     * 创建人id
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "ButlerHousekeeping{" +
                "id=" + id +
                ", estateId=" + estateId +
                ", num=" + num +
                ", leaderName='" + leaderName + '\'' +
                ", leaderTel='" + leaderTel + '\'' +
                ", content='" + content + '\'' +
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

    public ButlerHousekeeping() {
    }

    public ButlerHousekeeping(Integer id, Integer estateId, Integer num, String leaderName, String leaderTel, String content, Integer createId, Date createDate) {
        this.id = id;
        this.estateId = estateId;
        this.num = num;
        this.leaderName = leaderName;
        this.leaderTel = leaderTel;
        this.content = content;
        this.createId = createId;
        this.createDate = createDate;
    }
}
