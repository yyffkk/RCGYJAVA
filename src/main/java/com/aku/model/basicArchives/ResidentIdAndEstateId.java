package com.aku.model.basicArchives;

/**
 * 房产id 和 业主id
 */
public class ResidentIdAndEstateId {
    /**
     * 房产id
     */
    private Integer residentId;
    /**
     * 业主id
     */
    private Integer estateId;

    @Override
    public String toString() {
        return "ResidentIdAndEstateId{" +
                "residentId=" + residentId +
                ", estateId=" + estateId +
                '}';
    }

    public Integer getResidentId() {
        return residentId;
    }

    public void setResidentId(Integer residentId) {
        this.residentId = residentId;
    }

    public Integer getEstateId() {
        return estateId;
    }

    public void setEstateId(Integer estateId) {
        this.estateId = estateId;
    }

    public ResidentIdAndEstateId() {
    }

    public ResidentIdAndEstateId(Integer residentId, Integer estateId) {
        this.residentId = residentId;
        this.estateId = estateId;
    }
}
