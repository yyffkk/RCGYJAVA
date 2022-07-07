package com.api.model.app;

import java.util.Date;

/**
 * app用户登录login_token
 */
public class UserLoginToken {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 登录token值
     */
    private Long userLoginSession;
    /**
     * 住户id
     */
    private Integer residentId;
    /**
     * 用户登录时间
     */
    private Date userLoginDate;

    @Override
    public String toString() {
        return "UserLoginToken{" +
                "id=" + id +
                ", userLoginSession=" + userLoginSession +
                ", residentId=" + residentId +
                ", userLoginDate=" + userLoginDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getUserLoginSession() {
        return userLoginSession;
    }

    public void setUserLoginSession(Long userLoginSession) {
        this.userLoginSession = userLoginSession;
    }

    public Integer getResidentId() {
        return residentId;
    }

    public void setResidentId(Integer residentId) {
        this.residentId = residentId;
    }

    public Date getUserLoginDate() {
        return userLoginDate;
    }

    public void setUserLoginDate(Date userLoginDate) {
        this.userLoginDate = userLoginDate;
    }

    public UserLoginToken() {
    }

    public UserLoginToken(Integer id, Long userLoginSession, Integer residentId, Date userLoginDate) {
        this.id = id;
        this.userLoginSession = userLoginSession;
        this.residentId = residentId;
        this.userLoginDate = userLoginDate;
    }
}
