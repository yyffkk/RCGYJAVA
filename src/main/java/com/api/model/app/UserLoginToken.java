package com.api.model.app;

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

    @Override
    public String toString() {
        return "UserLoginToken{" +
                "id=" + id +
                ", userLoginSession=" + userLoginSession +
                ", residentId=" + residentId +
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

    public UserLoginToken() {
    }

    public UserLoginToken(Integer id, Long userLoginSession, Integer residentId) {
        this.id = id;
        this.userLoginSession = userLoginSession;
        this.residentId = residentId;
    }
}
