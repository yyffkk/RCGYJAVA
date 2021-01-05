package com.api.model.butlerService;


import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 投票管理信息model
 */
public class SysVote {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 标题
     */
    private String title;
    /**
     * 上传文件（照片路径）
     */
    private String[] fileUrls;
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
     * 创建人
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 修改人（物业）
     */
    private Integer modifyId;
    /**
     * 修改时间
     */
    private Date modifyDate;
    /**
     * 是否删除（默认为非删 1.非删，2.删除）
     */
    private Integer isDelete;
    /**
     * 是否发布（默认未发布）【1.发布，0.未发布】
     */
    private Integer isRelease;
    /**
     * 候选人信息集合
     */
    List<SysVoteCandidate> sysVoteCandidateList;

    @Override
    public String toString() {
        return "SysVote{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", fileUrls=" + Arrays.toString(fileUrls) +
                ", content='" + content + '\'' +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", type=" + type +
                ", status=" + status +
                ", createId=" + createId +
                ", createDate=" + createDate +
                ", modifyId=" + modifyId +
                ", modifyDate=" + modifyDate +
                ", isDelete=" + isDelete +
                ", isRelease=" + isRelease +
                ", sysVoteCandidateList=" + sysVoteCandidateList +
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

    public String[] getFileUrls() {
        return fileUrls;
    }

    public void setFileUrls(String[] fileUrls) {
        this.fileUrls = fileUrls;
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

    public Integer getModifyId() {
        return modifyId;
    }

    public void setModifyId(Integer modifyId) {
        this.modifyId = modifyId;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getIsRelease() {
        return isRelease;
    }

    public void setIsRelease(Integer isRelease) {
        this.isRelease = isRelease;
    }

    public List<SysVoteCandidate> getSysVoteCandidateList() {
        return sysVoteCandidateList;
    }

    public void setSysVoteCandidateList(List<SysVoteCandidate> sysVoteCandidateList) {
        this.sysVoteCandidateList = sysVoteCandidateList;
    }

    public SysVote() {
    }

    public SysVote(Integer id, String title, String[] fileUrls, String content, Date beginDate, Date endDate, Integer type, Integer status, Integer createId, Date createDate, Integer modifyId, Date modifyDate, Integer isDelete, Integer isRelease, List<SysVoteCandidate> sysVoteCandidateList) {
        this.id = id;
        this.title = title;
        this.fileUrls = fileUrls;
        this.content = content;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.type = type;
        this.status = status;
        this.createId = createId;
        this.createDate = createDate;
        this.modifyId = modifyId;
        this.modifyDate = modifyDate;
        this.isDelete = isDelete;
        this.isRelease = isRelease;
        this.sysVoteCandidateList = sysVoteCandidateList;
    }
}
