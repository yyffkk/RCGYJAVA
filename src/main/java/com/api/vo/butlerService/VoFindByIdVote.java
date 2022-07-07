package com.api.vo.butlerService;

import com.api.model.butlerService.SysVoteCandidate;
import com.api.vo.resources.VoResourcesImg;

import java.util.Date;
import java.util.List;

/**
 * 投票信息 findById 回显
 */
public class VoFindByIdVote {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 标题
     */
    private String title;
    /**
     * 照片信息集合
     */
    private List<VoResourcesImg> imgUrls;
    /**
     * 内容
     */
    private String content;
    /**
     * 投票开始时间
     */
    private Date beginDate;
    /**
     * 投票结束时间
     */
    private Date endDate;
    /**
     * 投票人群（1.业主，2.租户，3.全部）
     */
    private Integer type;
    /**
     * 状态（1.未开始，2.进行中，3.已结束）[默认为1.未开始]
     */
    private Integer status;
    /**
     * 是否发布（默认未发布）【1.发布，0.未发布】
     */
    private Integer isRelease;
    /**
     * 候选人信息集合
     */
    List<VoFindByIdVoteCandidate> voFindByIdVoteCandidateList;

    @Override
    public String toString() {
        return "VoFindByIdVote{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", imgUrls=" + imgUrls +
                ", content='" + content + '\'' +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", type=" + type +
                ", status=" + status +
                ", isRelease=" + isRelease +
                ", voFindByIdVoteCandidateList=" + voFindByIdVoteCandidateList +
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

    public List<VoResourcesImg> getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(List<VoResourcesImg> imgUrls) {
        this.imgUrls = imgUrls;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsRelease() {
        return isRelease;
    }

    public void setIsRelease(Integer isRelease) {
        this.isRelease = isRelease;
    }

    public List<VoFindByIdVoteCandidate> getVoFindByIdVoteCandidateList() {
        return voFindByIdVoteCandidateList;
    }

    public void setVoFindByIdVoteCandidateList(List<VoFindByIdVoteCandidate> voFindByIdVoteCandidateList) {
        this.voFindByIdVoteCandidateList = voFindByIdVoteCandidateList;
    }

    public VoFindByIdVote() {
    }

    public VoFindByIdVote(Integer id, String title, List<VoResourcesImg> imgUrls, String content, Date beginDate, Date endDate, Integer type, Integer status, Integer isRelease, List<VoFindByIdVoteCandidate> voFindByIdVoteCandidateList) {
        this.id = id;
        this.title = title;
        this.imgUrls = imgUrls;
        this.content = content;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.type = type;
        this.status = status;
        this.isRelease = isRelease;
        this.voFindByIdVoteCandidateList = voFindByIdVoteCandidateList;
    }
}
