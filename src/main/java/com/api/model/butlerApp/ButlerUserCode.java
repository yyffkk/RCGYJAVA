package com.api.model.butlerApp;

import java.util.Date;

/**
 * 管家app用户验证码
 */
public class ButlerUserCode {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 手机号
     */
    private String tel;
    /**
     * 验证码（用于用户验证码登录）
     */
    private String code;
    /**
     * 验证码发送时间
     */
    private Date codeSendDate;

    @Override
    public String toString() {
        return "ButlerUserCode{" +
                "id=" + id +
                ", tel='" + tel + '\'' +
                ", code='" + code + '\'' +
                ", codeSendDate=" + codeSendDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getCodeSendDate() {
        return codeSendDate;
    }

    public void setCodeSendDate(Date codeSendDate) {
        this.codeSendDate = codeSendDate;
    }

    public ButlerUserCode() {
    }

    public ButlerUserCode(Integer id, String tel, String code, Date codeSendDate) {
        this.id = id;
        this.tel = tel;
        this.code = code;
        this.codeSendDate = codeSendDate;
    }
}
