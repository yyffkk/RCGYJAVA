package com.api.model.app;

import java.util.Date;

/**
 * 修改手机号信息
 */
public class UpdateTel {
    /**
     * 用户主键id
     */
    private Integer id;
    /**
     * 旧号码
     */
    private String oldTel;
    /**
     * 新号码
     */
    private String newTel;
    /**
     * 手机号修改验证码
     */
    private String code;
    /**
     * 手机号修改验证码发送日期
     */
    private Date codeSendDate;

    @Override
    public String toString() {
        return "UpdateTel{" +
                "id=" + id +
                ", oldTel='" + oldTel + '\'' +
                ", newTel='" + newTel + '\'' +
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

    public String getOldTel() {
        return oldTel;
    }

    public void setOldTel(String oldTel) {
        this.oldTel = oldTel;
    }

    public String getNewTel() {
        return newTel;
    }

    public void setNewTel(String newTel) {
        this.newTel = newTel;
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

    public UpdateTel() {
    }

    public UpdateTel(Integer id, String oldTel, String newTel, String code, Date codeSendDate) {
        this.id = id;
        this.oldTel = oldTel;
        this.newTel = newTel;
        this.code = code;
        this.codeSendDate = codeSendDate;
    }
}
