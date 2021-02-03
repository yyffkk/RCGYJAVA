package com.api.vo.butlerApp;

/**
 * 管家app 维修人员信息
 */
public class ButlerRepairmanVo {
    /**
     * 维修人主键id
     */
    private Integer id;
    /**
     * 维修人姓名
     */
    private String name;
    /**
     * 维修人手机号
     */
    private String tel;

    @Override
    public String toString() {
        return "ButlerRepairmanVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public ButlerRepairmanVo() {
    }

    public ButlerRepairmanVo(Integer id, String name, String tel) {
        this.id = id;
        this.name = name;
        this.tel = tel;
    }
}
