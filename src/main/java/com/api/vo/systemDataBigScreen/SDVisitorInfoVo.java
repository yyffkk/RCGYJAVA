package com.api.vo.systemDataBigScreen;

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
    private int dateTime;

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

    public int getDateTime() {
        return dateTime;
    }

    public void setDateTime(int dateTime) {
        this.dateTime = dateTime;
    }

    public SDVisitorInfoVo() {
    }

    public SDVisitorInfoVo(int visitorNum, int dateTime) {
        this.visitorNum = visitorNum;
        this.dateTime = dateTime;
    }
}
