package com.api.model.operationManagement;

import java.util.Date;

/**
 * 考勤打卡记录搜索条件
 */
public class SearchAttendanceRecord {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 考勤时间（该考勤记录的创建时间）
     */
    private Date createDate;
    /**
     * 打卡人手机号
     */
    private String clockTel;
    /**
     * 状态（1.未上班，2.未下班）
     */
    private Integer status;

    @Override
    public String toString() {
        return "SearchAttendanceRecord{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", createDate=" + createDate +
                ", clockTel='" + clockTel + '\'' +
                ", status=" + status +
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getClockTel() {
        return clockTel;
    }

    public void setClockTel(String clockTel) {
        this.clockTel = clockTel;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public SearchAttendanceRecord() {
    }

    public SearchAttendanceRecord(int pageNum, int size, Date createDate, String clockTel, Integer status) {
        this.pageNum = pageNum;
        this.size = size;
        this.createDate = createDate;
        this.clockTel = clockTel;
        this.status = status;
    }
}
