package com.api.vo.butlerApp;

/**
 * 管家app 联系业主 name 和 tel
 */
public class ButlerNameAndTel {
    /**
     * 业主姓名
     */
    private String name;
    /**
     * 业主手机号
     */
    private String tel;

    @Override
    public String toString() {
        return "ButlerNameAndTel{" +
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

    public ButlerNameAndTel() {
    }

    public ButlerNameAndTel(String name, String tel) {
        this.name = name;
        this.tel = tel;
    }
}
