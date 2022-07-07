package com.api.model.app;

/**
 * app 商品主键id 和 用户主键id
 */
public class AppGoodsIdAndUserId {
    /**
     * 商品主键id
     */
    private Integer goodsId;
    /**
     * 用户主键id
     */
    private Integer UserId;

    @Override
    public String toString() {
        return "AppGoodsIdAndUserId{" +
                "goodsId=" + goodsId +
                ", UserId=" + UserId +
                '}';
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer userId) {
        UserId = userId;
    }

    public AppGoodsIdAndUserId() {
    }

    public AppGoodsIdAndUserId(Integer goodsId, Integer userId) {
        this.goodsId = goodsId;
        UserId = userId;
    }
}
