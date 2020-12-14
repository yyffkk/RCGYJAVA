package com.api.vo.butlerService;

import java.util.Date;

/**
 * 话题表 Vo list回显
 */
public class VoGambit {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 话题标题
     */
    private String title;
    /**
     * 话题摘要
     */
    private String summary;
    /**
     * 话题内容
     */
    private String content;
    /**
     * 开始时间
     */
    private Date beginDate;
    /**
     * 结束时间
     */
    private Date endDate;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 发布人姓名（根据用户类型判断使用对应表数据）
     */
    private String createName;
    /**
     * 发布时间
     */
    private Date createDate;
    /**
     * 是否可以评论
     */
    private Integer isRating;
    /**
     * 参与人数
     */
    private Integer peopleNum;

    @Override
    public String toString() {
        return "VoGambit{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", content='" + content + '\'' +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", status=" + status +
                ", createName='" + createName + '\'' +
                ", createDate=" + createDate +
                ", isRating=" + isRating +
                ", peopleNum=" + peopleNum +
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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Integer getIsRating() {
        return isRating;
    }

    public void setIsRating(Integer isRating) {
        this.isRating = isRating;
    }

    public Integer getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(Integer peopleNum) {
        this.peopleNum = peopleNum;
    }

    public VoGambit() {
    }

    public VoGambit(Integer id, String title, String summary, String content, Date beginDate, Date endDate, Integer status, String createName, Date createDate, Integer isRating, Integer peopleNum) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.content = content;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.status = status;
        this.createName = createName;
        this.createDate = createDate;
        this.isRating = isRating;
        this.peopleNum = peopleNum;
    }
}
