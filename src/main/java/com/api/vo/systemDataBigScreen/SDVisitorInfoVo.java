package com.api.vo.systemDataBigScreen;


import java.sql.Date;

/**
 * 访客管理信息 Vo 回显
 */
public class SDVisitorInfoVo {
    /**
     * 访客数量
     */
    private int visitorNum;
    /**
     * 日期(天)
     */
    private Date dateTime;

    @Override
    public String toString() {
        return "SDVisitorInfoVo{" +
                "visitorNum=" + visitorNum +
                ", dateTime=" + dateTime +
                '}';
    }

    public int getVisitorNum() {
        return visitorNum;
    }

    public void setVisitorNum(int visitorNum) {
        this.visitorNum = visitorNum;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public SDVisitorInfoVo() {
    }

    public SDVisitorInfoVo(int visitorNum, Date dateTime) {
        this.visitorNum = visitorNum;
        this.dateTime = dateTime;
    }
}
