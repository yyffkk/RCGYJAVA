package com.api.model.butlerService;

import java.util.Date;

/**
 * 工单回访信息
 */
public class RevisitWorkOrder {
    /**
     * 工单主键id
     */
    private Integer id;
    /**
     * 回访信息
     */
    private String content;
    /**
     * 回访时间
     */
    private Date revisitDate;

    @Override
    public String toString() {
        return "RevisitWorkOrder{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", revisitDate=" + revisitDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getRevisitDate() {
        return revisitDate;
    }

    public void setRevisitDate(Date revisitDate) {
        this.revisitDate = revisitDate;
    }

    public RevisitWorkOrder() {
    }

    public RevisitWorkOrder(Integer id, String content, Date revisitDate) {
        this.id = id;
        this.content = content;
        this.revisitDate = revisitDate;
    }
}
