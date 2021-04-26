package com.api.vo.butlerService;

/**
 * 设施信息Vo findById 回显
 */
public class VoFacilitiesManageFBI {
    /**
     * 设施基本信息
     */
    private VoFacilitiesManageDetail detail;
    /**
     * 设施情况
     */
    private VoFacilitiesManageSituation situation;

    @Override
    public String toString() {
        return "VoFacilitiesManageFBI{" +
                "detail=" + detail +
                ", situation=" + situation +
                '}';
    }

    public VoFacilitiesManageDetail getDetail() {
        return detail;
    }

    public void setDetail(VoFacilitiesManageDetail detail) {
        this.detail = detail;
    }

    public VoFacilitiesManageSituation getSituation() {
        return situation;
    }

    public void setSituation(VoFacilitiesManageSituation situation) {
        this.situation = situation;
    }

    public VoFacilitiesManageFBI() {
    }

    public VoFacilitiesManageFBI(VoFacilitiesManageDetail detail, VoFacilitiesManageSituation situation) {
        this.detail = detail;
        this.situation = situation;
    }
}
