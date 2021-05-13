package com.api.vo.systemDataBigScreen;

/**
 * 系统数据 访客管理信息 Vo 回显  (按月查询)
 */
public class SDVisitorInfoMonthVo {
    /**
     * 访客数量
     */
    private int visitorNum;
    /**
     * 年份
     */
    private int years;
    /**
     * 月份
     */
    private int months;

    @Override
    public String toString() {
        return "SDVisitorInfoMonthVo{" +
                "visitorNum=" + visitorNum +
                ", years=" + years +
                ", months=" + months +
                '}';
    }

    public int getVisitorNum() {
        return visitorNum;
    }

    public void setVisitorNum(int visitorNum) {
        this.visitorNum = visitorNum;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public SDVisitorInfoMonthVo() {
    }

    public SDVisitorInfoMonthVo(int visitorNum, int years, int months) {
        this.visitorNum = visitorNum;
        this.years = years;
        this.months = months;
    }
}
