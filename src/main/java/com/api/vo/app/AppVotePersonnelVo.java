package com.api.vo.app;

import java.util.Date;

/**
 * 投票人投票信息
 */
public class AppVotePersonnelVo {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 投票信息id
     */
    private Integer voteId;
    /**
     * 候选人id
     */
    private Integer voteCandidateId;
    /**
     * 投票人
     */
    private Integer voterId;
    /**
     * 投票时间
     */
    private Date voterDate;

    @Override
    public String toString() {
        return "AppVotePersonnelVo{" +
                "id=" + id +
                ", voteId=" + voteId +
                ", voteCandidateId=" + voteCandidateId +
                ", voterId=" + voterId +
                ", voterDate=" + voterDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVoteId() {
        return voteId;
    }

    public void setVoteId(Integer voteId) {
        this.voteId = voteId;
    }

    public Integer getVoteCandidateId() {
        return voteCandidateId;
    }

    public void setVoteCandidateId(Integer voteCandidateId) {
        this.voteCandidateId = voteCandidateId;
    }

    public Integer getVoterId() {
        return voterId;
    }

    public void setVoterId(Integer voterId) {
        this.voterId = voterId;
    }

    public Date getVoterDate() {
        return voterDate;
    }

    public void setVoterDate(Date voterDate) {
        this.voterDate = voterDate;
    }

    public AppVotePersonnelVo() {
    }

    public AppVotePersonnelVo(Integer id, Integer voteId, Integer voteCandidateId, Integer voterId, Date voterDate) {
        this.id = id;
        this.voteId = voteId;
        this.voteCandidateId = voteCandidateId;
        this.voterId = voterId;
        this.voterDate = voterDate;
    }
}
