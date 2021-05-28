package com.api.vo.butlerApp;

import java.util.Date;

/**
 * 管家app 新版装修管理-完工检查记录Vo list 回显
 */
public class ButlerUserDecorationNewCheckVo {
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
     * 检查完工是否合格，1.合格，2.不合格
     */
    private Integer isQualified;
    /**
     * 检查完工人名称
     */
    private String createName;
    /**
     * 检查完工时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "ButlerUserDecorationNewCheckVo{" +
                "id=" + id +
                ", decorationNewId=" + decorationNewId +
                ", detail='" + detail + '\'' +
                ", isQualified=" + isQualified +
                ", createName='" + createName + '\'' +
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

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public ButlerUserDecorationNewCheckVo() {
    }

    public ButlerUserDecorationNewCheckVo(Integer id, Integer decorationNewId, String detail, Integer isQualified, String createName, Date createDate) {
        this.id = id;
        this.decorationNewId = decorationNewId;
        this.detail = detail;
        this.isQualified = isQualified;
        this.createName = createName;
        this.createDate = createDate;
    }
}
