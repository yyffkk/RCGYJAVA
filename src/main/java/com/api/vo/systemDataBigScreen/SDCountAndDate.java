package com.api.vo.systemDataBigScreen;

/**
 * 系统数据 数量和年份和月份
 */
public class SDCountAndDate {
    /**
     * 数量
     */
    private int count;
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
        return "SDCountAndDate{" +
                "count=" + count +
                ", years=" + years +
                ", months=" + months +
                '}';
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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

    public SDCountAndDate() {
    }

    public SDCountAndDate(int count, int years, int months) {
        this.count = count;
        this.years = years;
        this.months = months;
    }
}
