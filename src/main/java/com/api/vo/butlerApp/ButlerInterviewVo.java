package com.api.vo.butlerApp;

import java.util.Date;

/**
 * 管家app 客户访谈Vo list 回显
 */
public class ButlerInterviewVo {
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
     * 访谈状态：1.待访谈，2.已访谈
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
     * 创建人姓名
     */
    private String createName;
    /**
     * 创建时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "ButlerInterviewVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", content='" + content + '\'' +
                ", status=" + status +
                ", interviewDate=" + interviewDate +
                ", feedbackContent='" + feedbackContent + '\'' +
                ", feedbackDate=" + feedbackDate +
                ", createName='" + createName + '\'' +
                ", createDate=" + createDate +
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

    public ButlerInterviewVo() {
    }

    public ButlerInterviewVo(Integer id, String name, String tel, String content, Integer status, Date interviewDate, String feedbackContent, Date feedbackDate, String createName, Date createDate) {
        this.id = id;
        this.name = name;
        this.tel = tel;
        this.content = content;
        this.status = status;
        this.interviewDate = interviewDate;
        this.feedbackContent = feedbackContent;
        this.feedbackDate = feedbackDate;
        this.createName = createName;
        this.createDate = createDate;
    }
}
