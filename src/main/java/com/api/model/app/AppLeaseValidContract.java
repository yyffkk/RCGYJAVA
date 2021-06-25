package com.api.model.app;

/**
 * app租赁有效合同model
 */
public class AppLeaseValidContract {
    /**
     * 租赁信息主键Id
     */
    private Integer id;
    /**
     * 合同预览照片路径
     */
    private String contractPreviewImgUrl;
    /**
     * 合同签名照片路径
     */
    private String contractSignatureImgUrl;

    @Override
    public String toString() {
        return "AppLeaseValidContract{" +
                "id=" + id +
                ", contractPreviewImgUrl='" + contractPreviewImgUrl + '\'' +
                ", contractSignatureImgUrl='" + contractSignatureImgUrl + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContractPreviewImgUrl() {
        return contractPreviewImgUrl;
    }

    public void setContractPreviewImgUrl(String contractPreviewImgUrl) {
        this.contractPreviewImgUrl = contractPreviewImgUrl;
    }

    public String getContractSignatureImgUrl() {
        return contractSignatureImgUrl;
    }

    public void setContractSignatureImgUrl(String contractSignatureImgUrl) {
        this.contractSignatureImgUrl = contractSignatureImgUrl;
    }

    public AppLeaseValidContract() {
    }

    public AppLeaseValidContract(Integer id, String contractPreviewImgUrl, String contractSignatureImgUrl) {
        this.id = id;
        this.contractPreviewImgUrl = contractPreviewImgUrl;
        this.contractSignatureImgUrl = contractSignatureImgUrl;
    }
}
