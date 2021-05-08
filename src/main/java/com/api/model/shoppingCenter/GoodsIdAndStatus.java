package com.api.model.shoppingCenter;

/**
 * 商品主键id和上下架状态
 */
public class GoodsIdAndStatus {
    /**
     * 商品主键id
     */
    private Integer goodsId;
    /**
     * 上下架状态
     */
    private Integer status;

    @Override
    public String toString() {
        return "GoodsIdAndStatus{" +
                "goodsId=" + goodsId +
                ", status=" + status +
                '}';
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public GoodsIdAndStatus() {
    }

    public GoodsIdAndStatus(Integer goodsId, Integer status) {
        this.goodsId = goodsId;
        this.status = status;
    }
}
