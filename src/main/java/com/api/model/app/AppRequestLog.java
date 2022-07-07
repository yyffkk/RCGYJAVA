package com.api.model.app;

import java.util.Date;

/**
 * app用户请求日志
 */
public class AppRequestLog {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 住户id
     */
    private Integer residentId;
    /**
     * 请求次数（按天记录）
     */
    private Integer requestNum;
    /**
     * 当天最后一次请求时间
     */
    private Date lastDate;
    /**
     * 用户登录ip
     */
    private String loginIp;

    @Override
    public String toString() {
        return "AppRequestLog{" +
                "id=" + id +
                ", residentId=" + residentId +
                ", requestNum=" + requestNum +
                ", lastDate=" + lastDate +
                ", loginIp='" + loginIp + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getResidentId() {
        return residentId;
    }

    public void setResidentId(Integer residentId) {
        this.residentId = residentId;
    }

    public Integer getRequestNum() {
        return requestNum;
    }

    public void setRequestNum(Integer requestNum) {
        this.requestNum = requestNum;
    }

    public Date getLastDate() {
        return lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public AppRequestLog() {
    }

    public AppRequestLog(Integer id, Integer residentId, Integer requestNum, Date lastDate, String loginIp) {
        this.id = id;
        this.residentId = residentId;
        this.requestNum = requestNum;
        this.lastDate = lastDate;
        this.loginIp = loginIp;
    }
}
