package com.api.vo.app;

import java.util.List;

/**
 * app 生活缴费Vo list 回显
 */
public class AppDailyPaymentVo {
    /**
     * 年份
     */
    private Integer years;
    /**
     * 待缴项数量
     */
    private Integer paymentNum;
    /**
     * app 生活缴费明细类别Vo list 回显
     */
    private List<AppDailyPaymentTypeVo> dailyPaymentTypeVos;

    @Override
    public String toString() {
        return "AppDailyPaymentVo{" +
                "years=" + years +
                ", paymentNum=" + paymentNum +
                ", dailyPaymentTypeVos=" + dailyPaymentTypeVos +
                '}';
    }

    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }

    public Integer getPaymentNum() {
        return paymentNum;
    }

    public void setPaymentNum(Integer paymentNum) {
        this.paymentNum = paymentNum;
    }

    public List<AppDailyPaymentTypeVo> getDailyPaymentTypeVos() {
        return dailyPaymentTypeVos;
    }

    public void setDailyPaymentTypeVos(List<AppDailyPaymentTypeVo> dailyPaymentTypeVos) {
        this.dailyPaymentTypeVos = dailyPaymentTypeVos;
    }

    public AppDailyPaymentVo() {
    }

    public AppDailyPaymentVo(Integer years, Integer paymentNum, List<AppDailyPaymentTypeVo> dailyPaymentTypeVos) {
        this.years = years;
        this.paymentNum = paymentNum;
        this.dailyPaymentTypeVos = dailyPaymentTypeVos;
    }
}
