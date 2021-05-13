package com.api.vo.systemDataBigScreen;

import java.util.Date;

/**
 * 系统数据 投票信息 Vo 回显
 */
public class SDVoteInfoVo {
    /**
     * 投票主键id
     */
    private Integer id;
    /**
     * 投票标题
     */
    private String title;
    /**
     * 状态（1.未开始，2.进行中，3.已结束）
     */
    private Integer status;
    /**
     * 投票开始时间
     */
    private Date beginDate;
    /**
     * 投票结束时间
     */
    private Date endDate;

    @Override
    public String toString() {
        return "SDVoteInfoVo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", status=" + status +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public SDVoteInfoVo() {
    }

    public SDVoteInfoVo(Integer id, String title, Integer status, Date beginDate, Date endDate) {
        this.id = id;
        this.title = title;
        this.status = status;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }
}
