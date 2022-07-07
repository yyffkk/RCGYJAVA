package com.api.model.butlerApp;

import java.util.Date;

/**
 * app管家用户登录login_token
 */
public class ButlerLoginToken {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 登录token值
     */
    private Long butlerLoginSession;
    /**
     * 管家用户id
     */
    private Integer sysUserId;
    /**
     * 管家用户登录时间
     */
    private Date butlerLoginDate;

    @Override
    public String toString() {
        return "ButlerLoginToken{" +
                "id=" + id +
                ", butlerLoginSession=" + butlerLoginSession +
                ", sysUserId=" + sysUserId +
                ", butlerLoginDate=" + butlerLoginDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getButlerLoginSession() {
        return butlerLoginSession;
    }

    public void setButlerLoginSession(Long butlerLoginSession) {
        this.butlerLoginSession = butlerLoginSession;
    }

    public Integer getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(Integer sysUserId) {
        this.sysUserId = sysUserId;
    }

    public Date getButlerLoginDate() {
        return butlerLoginDate;
    }

    public void setButlerLoginDate(Date butlerLoginDate) {
        this.butlerLoginDate = butlerLoginDate;
    }

    public ButlerLoginToken() {
    }

    public ButlerLoginToken(Integer id, Long butlerLoginSession, Integer sysUserId, Date butlerLoginDate) {
        this.id = id;
        this.butlerLoginSession = butlerLoginSession;
        this.sysUserId = sysUserId;
        this.butlerLoginDate = butlerLoginDate;
    }
}
