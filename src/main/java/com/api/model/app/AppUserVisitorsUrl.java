package com.api.model.app;

import java.util.Date;

/**
 * app 分享连接信息
 */
public class AppUserVisitorsUrl {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 分享连接编号
     */
    private String code;
    /**
     * 有效截止时间(目前分享的有效时长为3小时)
     */
    private Date effectiveDate;
    /**
     * 新版的访客主键id
     */
    private Integer userVisitorsNewId;
    /**
     * 是否使用：1.使用，0.未使用
     */
    private Integer isUse;

    @Override
    public String toString() {
        return "AppUserVisitorsUrl{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", effectiveDate=" + effectiveDate +
                ", userVisitorsNewId=" + userVisitorsNewId +
                ", isUse=" + isUse +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Integer getUserVisitorsNewId() {
        return userVisitorsNewId;
    }

    public void setUserVisitorsNewId(Integer userVisitorsNewId) {
        this.userVisitorsNewId = userVisitorsNewId;
    }

    public Integer getIsUse() {
        return isUse;
    }

    public void setIsUse(Integer isUse) {
        this.isUse = isUse;
    }

    public AppUserVisitorsUrl() {
    }

    public AppUserVisitorsUrl(Integer id, String code, Date effectiveDate, Integer userVisitorsNewId, Integer isUse) {
        this.id = id;
        this.code = code;
        this.effectiveDate = effectiveDate;
        this.userVisitorsNewId = userVisitorsNewId;
        this.isUse = isUse;
    }
}
