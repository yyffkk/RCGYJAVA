package com.api.model.operationManagement;

import java.util.Date;

/**
 * 绿化区域搜索条件
 */
public class SearchGreenArea {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 区域名称
     */
    private String name;
    /**
     * 创建人名称
     */
    private String createName;
    /**
     * 发布时间开始
     */
    private Date createDateStart;
    /**
     * 发布时间结束
     */
    private Date createDateEnd;

    @Override
    public String toString() {
        return "SearchGreenArea{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", name='" + name + '\'' +
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public SearchGreenArea() {
    }

    public SearchGreenArea(int pageNum, int size, String name, String createName, Date createDateStart, Date createDateEnd) {
        this.pageNum = pageNum;
        this.size = size;
        this.name = name;
        this.createName = createName;
        this.createDateStart = createDateStart;
        this.createDateEnd = createDateEnd;
    }
}
