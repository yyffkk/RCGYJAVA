package com.api.model.operationManagement;

import java.util.Date;

/**
 * 资讯管理搜索条件
 */
public class SearchNewsManagement {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 资讯编号
     */
    private String code;
    /**
     * 资讯标题
     */
    private String title;
    /**
     * 资讯类型
     */
    private Integer newsCategoryId;
    /**
     * 发布人
     */
    private String createName;
    /**
     * 发布开始时间
     */
    private Date createDateStart;
    /**
     * 发布结束时间
     */
    private Date createDateEnd;

    @Override
    public String toString() {
        return "SearchNewsManagement{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", code='" + code + '\'' +
                ", title='" + title + '\'' +
                ", newsCategoryId=" + newsCategoryId +
                ", createName='" + createName + '\'' +
                ", createDateStart=" + createDateStart +
                ", createDateEnd=" + createDateEnd +
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getNewsCategoryId() {
        return newsCategoryId;
    }

    public void setNewsCategoryId(Integer newsCategoryId) {
        this.newsCategoryId = newsCategoryId;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Date getCreateDateStart() {
        return createDateStart;
    }

    public void setCreateDateStart(Date createDateStart) {
        this.createDateStart = createDateStart;
    }

    public Date getCreateDateEnd() {
        return createDateEnd;
    }

    public void setCreateDateEnd(Date createDateEnd) {
        this.createDateEnd = createDateEnd;
    }

    public SearchNewsManagement() {
    }

    public SearchNewsManagement(int pageNum, int size, String code, String title, Integer newsCategoryId, String createName, Date createDateStart, Date createDateEnd) {
        this.pageNum = pageNum;
        this.size = size;
        this.code = code;
        this.title = title;
        this.newsCategoryId = newsCategoryId;
        this.createName = createName;
        this.createDateStart = createDateStart;
        this.createDateEnd = createDateEnd;
    }
}
