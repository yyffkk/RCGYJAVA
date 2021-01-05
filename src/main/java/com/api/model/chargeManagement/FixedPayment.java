package com.api.model.chargeManagement;

import org.springframework.web.multipart.MultipartFile;

/**
 * 固定金额 缴纳model
 */
public class FixedPayment {
    /**
     * 固定金额分摊结果主键id
     */
    private Integer id;
    /**
     * 缴纳凭证
     */
    private MultipartFile file;
    /**
     * 缴纳状态
     */
    private Integer status;

    @Override
    public String toString() {
        return "FixedPayment{" +
                "id=" + id +
                ", file=" + file +
                ", status=" + status +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public FixedPayment() {
    }

    public FixedPayment(Integer id, MultipartFile file, Integer status) {
        this.id = id;
        this.file = file;
        this.status = status;
    }
}
