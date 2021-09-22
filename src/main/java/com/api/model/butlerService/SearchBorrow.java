package com.api.model.butlerService;

import java.util.Date;

/**
 * 借还搜索条件
 */
public class SearchBorrow {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 物品名称
     */
    private String name;
    /**
     * 物品状态
     */
    private Integer borrowStatus;
    /**
     * 借用人
     */
    private String borrowName;
    /**
     * 联系方式
     */
    private String tel;
    /**
     * 借用开始时间
     */
    private Date beginDate;
    /**
     * 借用结束时间
     */
    private Date endDate;


    @Override
    public String toString() {
        return "SearchBorrow{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", name='" + name + '\'' +
                ", borrowStatus=" + borrowStatus +
                ", borrowName='" + borrowName + '\'' +
                ", tel='" + tel + '\'' +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
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

    public Integer getBorrowStatus() {
        return borrowStatus;
    }

    public void setBorrowStatus(Integer borrowStatus) {
        this.borrowStatus = borrowStatus;
    }

    public String getBorrowName() {
        return borrowName;
    }

    public void setBorrowName(String borrowName) {
        this.borrowName = borrowName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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

    public SearchBorrow() {
    }

    public SearchBorrow(int pageNum, int size, String name, Integer borrowStatus, String borrowName, String tel, Date beginDate, Date endDate) {
        this.pageNum = pageNum;
        this.size = size;
        this.name = name;
        this.borrowStatus = borrowStatus;
        this.borrowName = borrowName;
        this.tel = tel;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }
}
