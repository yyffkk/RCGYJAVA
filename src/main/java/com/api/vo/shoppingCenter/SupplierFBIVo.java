package com.api.vo.shoppingCenter;

import com.api.vo.resources.VoResourcesImg;

import java.util.List;

/**
 * 供应商信息 Vo findById 回显
 */
public class SupplierFBIVo {
    /**
     * 供应商名称
     */
    private Integer id;
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
    /**
     * 商家照片信息
     */
    private List<VoResourcesImg> imgList;

    @Override
    public String toString() {
        return "SupplierFBIVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", director='" + director + '\'' +
                ", tel='" + tel + '\'' +
                ", address='" + address + '\'' +
                ", imgList=" + imgList +
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

    public List<VoResourcesImg> getImgList() {
        return imgList;
    }

    public void setImgList(List<VoResourcesImg> imgList) {
        this.imgList = imgList;
    }

    public SupplierFBIVo() {
    }

    public SupplierFBIVo(Integer id, String name, String director, String tel, String address, List<VoResourcesImg> imgList) {
        this.id = id;
        this.name = name;
        this.director = director;
        this.tel = tel;
        this.address = address;
        this.imgList = imgList;
    }
}
