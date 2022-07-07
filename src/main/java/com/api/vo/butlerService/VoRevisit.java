package com.api.vo.butlerService;

import java.util.Date;

/**
 * 客户回访Vo
 */
public class VoRevisit {
    /**
     * 工单主键id
     */
    private Integer id;
    /**
     * 回访时间
     */
    private Date revisitDate;
    /**
     * 回访情况说明
     */
    private String revisitDetail;

    @Override
    public String toString() {
        return "VoRevisit{" +
                "id=" + id +
                ", revisitDate=" + revisitDate +
                ", revisitDetail='" + revisitDetail + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getRevisitDate() {
        return revisitDate;
    }

    public void setRevisitDate(Date revisitDate) {
        this.revisitDate = revisitDate;
    }

    public String getRevisitDetail() {
        return revisitDetail;
    }

    public void setRevisitDetail(String revisitDetail) {
        this.revisitDetail = revisitDetail;
    }

    public VoRevisit() {
    }

    public VoRevisit(Integer id, Date revisitDate, String revisitDetail) {
        this.id = id;
        this.revisitDate = revisitDate;
        this.revisitDetail = revisitDetail;
    }
}
