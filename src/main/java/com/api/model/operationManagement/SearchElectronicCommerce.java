package com.api.model.operationManagement;

import java.util.Date;

/**
 * 电子商务搜索条件
 */
public class SearchElectronicCommerce {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 电子商务编号
     */
    private String code;
    /**
     * 电子商务标题
     */
    private String title;
    /**
     * 电子商务类型
     */
    private Integer electronicCommerceCategoryId;
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
        return "SearchElectronicCommerce{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", code='" + code + '\'' +
                ", title='" + title + '\'' +
                ", electronicCommerceCategoryId=" + electronicCommerceCategoryId +
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

    public Integer getElectronicCommerceCategoryId() {
        return electronicCommerceCategoryId;
    }

    public void setElectronicCommerceCategoryId(Integer electronicCommerceCategoryId) {
        this.electronicCommerceCategoryId = electronicCommerceCategoryId;
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

    public SearchElectronicCommerce() {
    }

    public SearchElectronicCommerce(int pageNum, int size, String code, String title, Integer electronicCommerceCategoryId, String createName, Date createDateStart, Date createDateEnd) {
        this.pageNum = pageNum;
        this.size = size;
        this.code = code;
        this.title = title;
        this.electronicCommerceCategoryId = electronicCommerceCategoryId;
        this.createName = createName;
        this.createDateStart = createDateStart;
        this.createDateEnd = createDateEnd;
    }
}
