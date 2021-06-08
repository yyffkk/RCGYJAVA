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
     * 打卡状态（1.已打卡，2.未打卡，3.已补卡）
     */
    private Integer clockStatus;

    @Override
    public String toString() {
        return "SearchAttendanceRecord{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", createDate=" + createDate +
                ", clockTel='" + clockTel + '\'' +
                ", clockStatus=" + clockStatus +
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

    public Integer getClockStatus() {
        return clockStatus;
    }

    public void setClockStatus(Integer clockStatus) {
        this.clockStatus = clockStatus;
    }

    public SearchAttendanceRecord() {
    }

    public SearchAttendanceRecord(int pageNum, int size, Date createDate, String clockTel, Integer clockStatus) {
        this.pageNum = pageNum;
        this.size = size;
        this.createDate = createDate;
        this.clockTel = clockTel;
        this.clockStatus = clockStatus;
    }
}
