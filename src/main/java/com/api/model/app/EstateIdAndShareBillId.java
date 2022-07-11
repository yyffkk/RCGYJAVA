package com.api.model.app;

/**
 * 房产主键id和抄表公摊账单主键id
 */
public class EstateIdAndShareBillId {
    /**
     * 房产主键id
     */
    private Integer estateId;
    /**
     * 抄表公摊账单主键id
     */
    private Integer shareBillId;

    @Override
    public String toString() {
        return "EstateIdAndShareBillId{" +
                "estateId=" + estateId +
                ", shareBillId=" + shareBillId +
                '}';
    }

    public Integer getEstateId() {
        return estateId;
    }

    public void setEstateId(Integer estateId) {
        this.estateId = estateId;
    }

    public Integer getShareBillId() {
        return shareBillId;
    }

    public void setShareBillId(Integer shareBillId) {
        this.shareBillId = shareBillId;
    }

    public EstateIdAndShareBillId() {
    }

    public EstateIdAndShareBillId(Integer estateId, Integer shareBillId) {
        this.estateId = estateId;
        this.shareBillId = shareBillId;
    }
}
