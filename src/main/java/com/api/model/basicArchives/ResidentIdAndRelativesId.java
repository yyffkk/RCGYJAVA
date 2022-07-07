package com.api.model.basicArchives;
/**
 * 业主id 和 亲属id
 */
public class ResidentIdAndRelativesId {
    private Integer ResidentId;
    private Integer RelativesId;

    @Override
    public String toString() {
        return "ResidentIdAndRelativesId{" +
                "ResidentId=" + ResidentId +
                ", RelativesId=" + RelativesId +
                '}';
    }

    public Integer getResidentId() {
        return ResidentId;
    }

    public void setResidentId(Integer residentId) {
        ResidentId = residentId;
    }

    public Integer getRelativesId() {
        return RelativesId;
    }

    public void setRelativesId(Integer relativesId) {
        RelativesId = relativesId;
    }

    public ResidentIdAndRelativesId() {
    }

    public ResidentIdAndRelativesId(Integer residentId, Integer relativesId) {
        ResidentId = residentId;
        RelativesId = relativesId;
    }
}
