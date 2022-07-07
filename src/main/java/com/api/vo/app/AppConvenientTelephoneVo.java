package com.api.vo.app;

/**
 * app便民电话显示
 */
public class AppConvenientTelephoneVo {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 联系电话
     */
    private String tel;

    @Override
    public String toString() {
        return "AppConvenientTelephoneVo{" +
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

    public AppConvenientTelephoneVo() {
    }

    public AppConvenientTelephoneVo(Integer id, String name, String tel) {
        this.id = id;
        this.name = name;
        this.tel = tel;
    }
}
