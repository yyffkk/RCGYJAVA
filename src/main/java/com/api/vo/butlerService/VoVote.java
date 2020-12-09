package com.api.vo.butlerService;

import java.util.Date;

/**
 * 投票管理 list回显
 */
public class VoVote {
    /**
     * 投票管理主键id
     */
    private Integer id;
    /**
     * 投票标题
     */
    private String title;
    /**
     * 投票开始时间
     */
    private Date beginDate;
    /**
     * 投票结束时间
     */
    private Date endDate;
    /**
     * 状态（1.未开始，2.进行中，3.已结束）
     */
    private Integer status;
    /**
     * 投票候选人人数
     */
    private Integer votePersonnelNum;
    /**
     * 投票结果（还没结果则为null）
     */
    private String voteResult;

    @Override
    public String toString() {
        return "VoVote{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", status=" + status +
                ", votePersonnelNum=" + votePersonnelNum +
                ", voteResult='" + voteResult + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getVotePersonnelNum() {
        return votePersonnelNum;
    }

    public void setVotePersonnelNum(Integer votePersonnelNum) {
        this.votePersonnelNum = votePersonnelNum;
    }

    public String getVoteResult() {
        return voteResult;
    }

    public void setVoteResult(String voteResult) {
        this.voteResult = voteResult;
    }

    public VoVote() {
    }

    public VoVote(Integer id, String title, Date beginDate, Date endDate, Integer status, Integer votePersonnelNum, String voteResult) {
        this.id = id;
        this.title = title;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.status = status;
        this.votePersonnelNum = votePersonnelNum;
        this.voteResult = voteResult;
    }
}
