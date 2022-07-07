package com.api.model.operationManagement;

import java.util.Date;

/**
 * 社区介绍搜索条件
 */
public class SearchCommunityIntroduction {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 模版名称
     */
    private String name;
    /***
     * 启用状态 1.启用中，2.未启用
     */
    private Integer status;
    /**
     * 创建人
     */
    private String createName;
    /**
     * 最近修改时间开始
     */
    private Date nearModifyDateStart;
    /**
     * 最近修改时间结束
     */
    private Date nearModifyDateEnd;
    /**
     * 创建时间开始
     */
    private Date createDateStart;
    /**
     * 创建时间结束
     */
    private Date createDateEnd;

    @Override
    public String toString() {
        return "SearchCommunityIntroduction{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", createName='" + createName + '\'' +
                ", nearModifyDateStart=" + nearModifyDateStart +
                ", nearModifyDateEnd=" + nearModifyDateEnd +
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Date getNearModifyDateStart() {
        return nearModifyDateStart;
    }

    public void setNearModifyDateStart(Date nearModifyDateStart) {
        this.nearModifyDateStart = nearModifyDateStart;
    }

    public Date getNearModifyDateEnd() {
        return nearModifyDateEnd;
    }

    public void setNearModifyDateEnd(Date nearModifyDateEnd) {
        this.nearModifyDateEnd = nearModifyDateEnd;
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

    public SearchCommunityIntroduction() {
    }

    public SearchCommunityIntroduction(int pageNum, int size, String name, Integer status, String createName, Date nearModifyDateStart, Date nearModifyDateEnd, Date createDateStart, Date createDateEnd) {
        this.pageNum = pageNum;
        this.size = size;
        this.name = name;
        this.status = status;
        this.createName = createName;
        this.nearModifyDateStart = nearModifyDateStart;
        this.nearModifyDateEnd = nearModifyDateEnd;
        this.createDateStart = createDateStart;
        this.createDateEnd = createDateEnd;
    }
}
