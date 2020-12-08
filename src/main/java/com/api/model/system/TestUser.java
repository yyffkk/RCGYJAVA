package com.api.model.system;

public class TestUser {
    private Integer id;
    private String userName;
    private String pwd;
    private String tel;

    @Override
    public String toString() {
        return "TestUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", pwd='" + pwd + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public TestUser() {
    }

    public TestUser(Integer id, String userName, String pwd, String tel) {
        this.id = id;
        this.userName = userName;
        this.pwd = pwd;
        this.tel = tel;
    }
}
