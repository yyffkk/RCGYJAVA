package com.api.model.butlerApp;

import java.util.Date;

/**
 * 管家app 新版装修检查信息model
 */
public class ButlerUserDecorationNewCheck {
    /**
     * 新版装修检查记录主键id
     */
    private Integer id;
    /**
     * 新版装修主键id
     */
    private Integer decorationNewId;
    /**
     * 检查完工详情
     */
    private String detail;
    /**
     * 检查完工是否合格，1.合格，0.不合格
     */
    private Integer isQualified;
    /**
     * 检查完工人（物业表）
     */
    private Integer createId;
    /**
     * 检查完工时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "ButlerUserDecorationNewCheck{" +
                "id=" + id +
                ", decorationNewId=" + decorationNewId +
                ", detail='" + detail + '\'' +
                ", isQualified=" + isQualified +
                ", createId=" + createId +
                ", createDate=" + createDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDecorationNewId() {
        return decorationNewId;
    }

    public void setDecorationNewId(Integer decorationNewId) {
        this.decorationNewId = decorationNewId;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getIsQualified() {
        return isQualified;
    }

    public void setIsQualified(Integer isQualified) {
        this.isQualified = isQualified;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public ButlerUserDecorationNewCheck() {
    }

    public ButlerUserDecorationNewCheck(Integer id, Integer decorationNewId, String detail, Integer isQualified, Integer createId, Date createDate) {
        this.id = id;
        this.decorationNewId = decorationNewId;
        this.detail = detail;
        this.isQualified = isQualified;
        this.createId = createId;
        this.createDate = createDate;
    }
}
