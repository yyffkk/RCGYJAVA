package com.api.model.butlerService;

import java.util.Date;

/**
 * 话题搜索条件
 */
public class SearchGambit {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 发布人开始时间(发布时间)
     */
    private Date creatBeginDate;
    /**
     * 发布人结束时间（发布时间）
     */
    private Date creatEndDate;
    /**
     * 话题标题
     */
    private String title;
    /**
     * 发布人姓名
     */
    private String createName;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 摘要
     */
    private String summary;

    @Override
    public String toString() {
        return "SearchGambit{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", creatBeginDate=" + creatBeginDate +
                ", creatEndDate=" + creatEndDate +
                ", title='" + title + '\'' +
                ", createName='" + createName + '\'' +
                ", status=" + status +
                ", summary='" + summary + '\'' +
                '}';
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Date getCreatBeginDate() {
        return creatBeginDate;
    }

    public void setCreatBeginDate(Date creatBeginDate) {
        this.creatBeginDate = creatBeginDate;
    }

    public Date getCreatEndDate() {
        return creatEndDate;
    }

    public void setCreatEndDate(Date creatEndDate) {
        this.creatEndDate = creatEndDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public SearchGambit() {
    }

    public SearchGambit(int pageNum, int size, Date creatBeginDate, Date creatEndDate, String title, String createName, Integer status, String summary) {
        this.pageNum = pageNum;
        this.size = size;
        this.creatBeginDate = creatBeginDate;
        this.creatEndDate = creatEndDate;
        this.title = title;
        this.createName = createName;
        this.status = status;
        this.summary = summary;
    }
}
