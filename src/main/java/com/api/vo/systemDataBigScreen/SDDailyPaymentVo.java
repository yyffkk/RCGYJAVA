package com.api.vo.systemDataBigScreen;

import java.util.List;

public class SDDailyPaymentVo {
    /**
     * 未缴费用
     */
    private int unpaidFees;
    /**
     * 已缴纳住户数量
     */
    private int paidNum;
    /**
     * 未缴纳住户数量
     */
    private int noPaidNum;
    /**
     * 系统数据 数量和年份和月份 【未缴费住户数量（最近6个月，每月信息）】
     */
    private List<SDCountAndDate> sixMonthInfo;

    @Override
    public String toString() {
        return "SDDailyPaymentVo{" +
                "unpaidFees=" + unpaidFees +
                ", paidNum=" + paidNum +
                ", noPaidNum=" + noPaidNum +
                ", sixMonthInfo=" + sixMonthInfo +
                '}';
    }

    public int getUnpaidFees() {
        return unpaidFees;
    }

    public void setUnpaidFees(int unpaidFees) {
        this.unpaidFees = unpaidFees;
    }

    public int getPaidNum() {
        return paidNum;
    }

    public void setPaidNum(int paidNum) {
        this.paidNum = paidNum;
    }

    public int getNoPaidNum() {
        return noPaidNum;
    }

    public void setNoPaidNum(int noPaidNum) {
        this.noPaidNum = noPaidNum;
    }

    public List<SDCountAndDate> getSixMonthInfo() {
        return sixMonthInfo;
    }

    public void setSixMonthInfo(List<SDCountAndDate> sixMonthInfo) {
        this.sixMonthInfo = sixMonthInfo;
    }

    public SDDailyPaymentVo() {
    }

    public SDDailyPaymentVo(int unpaidFees, int paidNum, int noPaidNum, List<SDCountAndDate> sixMonthInfo) {
        this.unpaidFees = unpaidFees;
        this.paidNum = paidNum;
        this.noPaidNum = noPaidNum;
        this.sixMonthInfo = sixMonthInfo;
    }
}
