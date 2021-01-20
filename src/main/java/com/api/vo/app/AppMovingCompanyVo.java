package com.api.vo.app;

/**
 * app搬家公司回显信息
 */
public class AppMovingCompanyVo {
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
        return "AppMovingCompanyVo{" +
                "name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                '}';
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

    public AppMovingCompanyVo() {
    }

    public AppMovingCompanyVo(String name, String tel) {
        this.name = name;
        this.tel = tel;
    }
}
