package com.api.vo.app;

/**
 * app 认证信息 Vo 回显
 */
public class AppLeaseInfoVo {
    /**
     * 承租人姓名
     */
    private String name;
    /**
     * 性别，1.男,2.女
     */
    private Integer sex;
    /**
     * 手机号
     */
    private String tel;
    /**
     * 身份证号
     */
    private String idNumber;

    @Override
    public String toString() {
        return "AppLeaseInfoVo{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", tel='" + tel + '\'' +
                ", idNumber='" + idNumber + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public AppLeaseInfoVo() {
    }

    public AppLeaseInfoVo(String name, Integer sex, String tel, String idNumber) {
        this.name = name;
        this.sex = sex;
        this.tel = tel;
        this.idNumber = idNumber;
    }
}
