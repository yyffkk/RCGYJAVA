package com.api.model.operationManagement;

import java.util.Date;

/**
 * 客户访谈model
 */
public class Interview {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 客户姓名
     */
    private String name;
    /**
     * 客户手机号
     */
    private String tel;
    /**
     * 访谈内容
     */
    private String content;
    /**
     * 访谈状态：1.未访谈，2.已访谈
     */
    private Integer status;
    /**
     * 访谈时间
     */
    private Date interviewDate;
    /**
     * 访谈回复内容
     */
    private String feedbackContent;
    /**
     * 访谈回复时间
     */
    private Date feedbackDate;
    /**
     * 创建人id
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 是否删除：1.非删，0.删除
     */
    private Integer isDelete;

    @Override
    public String toString() {
        return "Interview{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", content='" + content + '\'' +
                ", status=" + status +
                ", interviewDate=" + interviewDate +
                ", feedbackContent='" + feedbackContent + '\'' +
                ", feedbackDate=" + feedbackDate +
                ", createId=" + createId +
                ", createDate=" + createDate +
                ", isDelete=" + isDelete +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(Date interviewDate) {
        this.interviewDate = interviewDate;
    }

    public String getFeedbackContent() {
        return feedbackContent;
    }

    public void setFeedbackContent(String feedbackContent) {
        this.feedbackContent = feedbackContent;
    }

    public Date getFeedbackDate() {
        return feedbackDate;
    }

    public void setFeedbackDate(Date feedbackDate) {
        this.feedbackDate = feedbackDate;
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

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Interview() {
    }

    public Interview(Integer id, String name, String tel, String content, Integer status, Date interviewDate, String feedbackContent, Date feedbackDate, Integer createId, Date createDate, Integer isDelete) {
        this.id = id;
        this.name = name;
        this.tel = tel;
        this.content = content;
        this.status = status;
        this.interviewDate = interviewDate;
        this.feedbackContent = feedbackContent;
        this.feedbackDate = feedbackDate;
        this.createId = createId;
        this.createDate = createDate;
        this.isDelete = isDelete;
    }
}
