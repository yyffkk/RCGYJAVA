package com.api.model.app;

import java.util.Date;

/**
 * 投票人投票信息
 */
public class AppVotePersonnel {
    /**
     * 投票信息主键id
     */
    private Integer voteId;
    /**
     * 投票候选人id
     */
    private Integer candidateId;
    /**
     * 投票人(用户id)
     */
    private Integer voterId;
    /**
     * 投票时间
     */
    private Date voterDate;


    @Override
    public String toString() {
        return "AppVotePersonnel{" +
                "voteId=" + voteId +
                ", candidateId=" + candidateId +
                ", voterId=" + voterId +
                ", voterDate=" + voterDate +
                '}';
    }

    public Integer getVoteId() {
        return voteId;
    }

    public void setVoteId(Integer voteId) {
        this.voteId = voteId;
    }

    public Integer getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Integer candidateId) {
        this.candidateId = candidateId;
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

    public AppVotePersonnel() {
    }

    public AppVotePersonnel(Integer voteId, Integer candidateId, Integer voterId, Date voterDate) {
        this.voteId = voteId;
        this.candidateId = candidateId;
        this.voterId = voterId;
        this.voterDate = voterDate;
    }
}
