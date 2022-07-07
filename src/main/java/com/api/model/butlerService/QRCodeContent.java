package com.api.model.butlerService;

/**
 * 二维码传输内容
 */
public class QRCodeContent {
    /**
     * 房产id
     */
    private Integer estateId;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 备注
     */
    private String remarks2;

    @Override
    public String toString() {
        return "QRCodeContent{" +
                "estateId=" + estateId +
                ", status=" + status +
                ", remarks2='" + remarks2 + '\'' +
                '}';
    }

    public Integer getEstateId() {
        return estateId;
    }

    public void setEstateId(Integer estateId) {
        this.estateId = estateId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemarks2() {
        return remarks2;
    }

    public void setRemarks2(String remarks2) {
        this.remarks2 = remarks2;
    }

    public QRCodeContent() {
    }

    public QRCodeContent(Integer estateId, Integer status, String remarks2) {
        this.estateId = estateId;
        this.status = status;
        this.remarks2 = remarks2;
    }
}
