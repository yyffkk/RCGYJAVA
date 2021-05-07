package com.api.vo.shoppingCenter;

/**
 * 供应商信息 Vo findById 回显
 */
public class SupplierFBIVo {
    /**
     * 供应商名称
     */
    private String name;
    /**
     * 负责人
     */
    private String director;
    /**
     * 联系方式
     */
    private String tel;
    /**
     * 商家地址
     */
    private String address;

    @Override
    public String toString() {
        return "SupplierFBIVo{" +
                "name='" + name + '\'' +
                ", director='" + director + '\'' +
                ", tel='" + tel + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public SupplierFBIVo() {
    }

    public SupplierFBIVo(String name, String director, String tel, String address) {
        this.name = name;
        this.director = director;
        this.tel = tel;
        this.address = address;
    }
}
