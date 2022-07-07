package com.api.vo.app;

import java.util.Date;

/**
 * app用户登录login_token Vo
 */
public class UserLoginTokenVo {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 登录token值
     */
    private String userLoginSession;
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
        return "UserLoginTokenVo{" +
                "id=" + id +
                ", userLoginSession='" + userLoginSession + '\'' +
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

    public String getUserLoginSession() {
        return userLoginSession;
    }

    public void setUserLoginSession(String userLoginSession) {
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

    public UserLoginTokenVo() {
    }

    public UserLoginTokenVo(Integer id, String userLoginSession, Integer residentId, Date userLoginDate) {
        this.id = id;
        this.userLoginSession = userLoginSession;
        this.residentId = residentId;
        this.userLoginDate = userLoginDate;
    }
}
