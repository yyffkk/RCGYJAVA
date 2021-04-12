package com.api.vo.system;

/**
 * 派工用户信息
 */
public class VoDispatchSysUser {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 真实名称
     */
    private String actualName;
    /**
     * 联系方式
     */
    private String tel;

    @Override
    public String toString() {
        return "VoDispatchSysUser{" +
                "id=" + id +
                ", actualName='" + actualName + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActualName() {
        return actualName;
    }

    public void setActualName(String actualName) {
        this.actualName = actualName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public VoDispatchSysUser() {
    }

    public VoDispatchSysUser(Integer id, String actualName, String tel) {
        this.id = id;
        this.actualName = actualName;
        this.tel = tel;
    }
}
