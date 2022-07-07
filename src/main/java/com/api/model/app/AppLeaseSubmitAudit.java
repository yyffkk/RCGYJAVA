package com.api.model.app;

import java.util.Arrays;

/**
 * app 提交审核model
 */
public class AppLeaseSubmitAudit {
    /**
     * 租赁主键id
     */
    private Integer id;
    /**
     * 租赁有效（正式）合同路径
     */
    private String[] leaseContractValidPdfUrl;

    @Override
    public String toString() {
        return "AppLeaseSubmitAudit{" +
                "id=" + id +
                ", leaseContractValidPdfUrl=" + Arrays.toString(leaseContractValidPdfUrl) +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String[] getLeaseContractValidPdfUrl() {
        return leaseContractValidPdfUrl;
    }

    public void setLeaseContractValidPdfUrl(String[] leaseContractValidPdfUrl) {
        this.leaseContractValidPdfUrl = leaseContractValidPdfUrl;
    }

    public AppLeaseSubmitAudit() {
    }

    public AppLeaseSubmitAudit(Integer id, String[] leaseContractValidPdfUrl) {
        this.id = id;
        this.leaseContractValidPdfUrl = leaseContractValidPdfUrl;
    }
}
