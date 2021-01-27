package com.api.model.butlerService;

import java.util.Date;

/**
 * 主题明细管理 搜索条件
 */
public class SearchGambitTheme {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 开始时间
     */
    private Date beginDate;
    /**
     * 结束时间
     */
    private Date endDate;
    /**
     * 话题标题
     */
    private String title;
    /**
     * 话题发布人姓名
     */
    private String gambitName;
    /**
     * 话题发布人昵称
     */
    private String nickName;
    /**
     * 话题摘要
     */
    private String summary;
    /**
     * 发布内容
     */
    private String gambitContent;
    /**
     * 评论内容
     */
    private String content;
    /**
     * 评论人（主题发布人）
     */
    private String themeName;
    /**
     * 是否删除（1.非删，0.删除）
     */
    private Integer isDelete;

    @Override
    public String toString() {
        return "SearchGambitTheme{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", title='" + title + '\'' +
                ", gambitName='" + gambitName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", summary='" + summary + '\'' +
                ", gambitContent='" + gambitContent + '\'' +
                ", content='" + content + '\'' +
                ", themeName='" + themeName + '\'' +
                ", isDelete=" + isDelete +
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGambitName() {
        return gambitName;
    }

    public void setGambitName(String gambitName) {
        this.gambitName = gambitName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getGambitContent() {
        return gambitContent;
    }

    public void setGambitContent(String gambitContent) {
        this.gambitContent = gambitContent;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public SearchGambitTheme() {
    }

    public SearchGambitTheme(int pageNum, int size, Date beginDate, Date endDate, String title, String gambitName, String nickName, String summary, String gambitContent, String content, String themeName, Integer isDelete) {
        this.pageNum = pageNum;
        this.size = size;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.title = title;
        this.gambitName = gambitName;
        this.nickName = nickName;
        this.summary = summary;
        this.gambitContent = gambitContent;
        this.content = content;
        this.themeName = themeName;
        this.isDelete = isDelete;
    }
}
