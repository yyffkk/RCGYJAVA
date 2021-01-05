package com.api.model.chargeManagement;

import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;

/**
 * 固定金额 缴纳model
 */
public class FixedPayment {
    /**
     * 固定金额分摊结果主键id
     */
    private Integer id;
    /**
     * 缴纳凭证路径数组
     */
    private String[] fileUrls;
    /**
     * 缴纳状态
     */
    private Integer status;

    @Override
    public String toString() {
        return "FixedPayment{" +
                "id=" + id +
                ", fileUrls=" + Arrays.toString(fileUrls) +
                ", status=" + status +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String[] getFileUrls() {
        return fileUrls;
    }

    public void setFileUrls(String[] fileUrls) {
        this.fileUrls = fileUrls;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public FixedPayment() {
    }

    public FixedPayment(Integer id, String[] fileUrls, Integer status) {
        this.id = id;
        this.fileUrls = fileUrls;
        this.status = status;
    }
}
