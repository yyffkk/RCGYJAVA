package com.api.model.shoppingCenter;

import java.util.Date;

/**
 * 商品客服回复
 */
public class GoodsReply {
    /**
     * 商品预约主键id
     */
    private Integer goodsAppointmentId;
    /**
     * 客服回复内容
     */
    private String replyContent;
    /**
     * 客服回复时间
     */
    private Date replyDate;

    @Override
    public String toString() {
        return "GoodsReply{" +
                "goodsAppointmentId=" + goodsAppointmentId +
                ", replyContent='" + replyContent + '\'' +
                ", replyDate=" + replyDate +
                '}';
    }

    public Integer getGoodsAppointmentId() {
        return goodsAppointmentId;
    }

    public void setGoodsAppointmentId(Integer goodsAppointmentId) {
        this.goodsAppointmentId = goodsAppointmentId;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public Date getReplyDate() {
        return replyDate;
    }

    public void setReplyDate(Date replyDate) {
        this.replyDate = replyDate;
    }

    public GoodsReply() {
    }

    public GoodsReply(Integer goodsAppointmentId, String replyContent, Date replyDate) {
        this.goodsAppointmentId = goodsAppointmentId;
        this.replyContent = replyContent;
        this.replyDate = replyDate;
    }
}
