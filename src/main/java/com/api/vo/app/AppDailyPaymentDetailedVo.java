package com.api.vo.app;

import java.math.BigDecimal;
import java.util.List;

/**
 * app 生活缴费明细Vo list 回显
 */
public class AppDailyPaymentDetailedVo {
    /**
     * 1.上半年，2.下半年
     */
    private Integer groupId;
    /**
     * 待缴纳金额
     */
    private BigDecimal paymentPrice;
    /**
     * 滞纳金
     */
    private BigDecimal overdueFine;
    /**
     * app 生活缴费详情Vo list 回显
     */
    private List<AppDailyPaymentDetailsVo> detailsVoList;

    @Override
    public String toString() {
        return "AppDailyPaymentDetailedVo{" +
                "groupId=" + groupId +
                ", paymentPrice=" + paymentPrice +
                ", overdueFine=" + overdueFine +
                ", detailsVoList=" + detailsVoList +
                '}';
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public BigDecimal getPaymentPrice() {
        return paymentPrice;
    }

    public void setPaymentPrice(BigDecimal paymentPrice) {
        this.paymentPrice = paymentPrice;
    }

    public BigDecimal getOverdueFine() {
        return overdueFine;
    }

    public void setOverdueFine(BigDecimal overdueFine) {
        this.overdueFine = overdueFine;
    }

    public List<AppDailyPaymentDetailsVo> getDetailsVoList() {
        return detailsVoList;
    }

    public void setDetailsVoList(List<AppDailyPaymentDetailsVo> detailsVoList) {
        this.detailsVoList = detailsVoList;
    }

    public AppDailyPaymentDetailedVo() {
    }

    public AppDailyPaymentDetailedVo(Integer groupId, BigDecimal paymentPrice, BigDecimal overdueFine, List<AppDailyPaymentDetailsVo> detailsVoList) {
        this.groupId = groupId;
        this.paymentPrice = paymentPrice;
        this.overdueFine = overdueFine;
        this.detailsVoList = detailsVoList;
    }
}
