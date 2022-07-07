package com.api.vo.app;

import com.api.vo.resources.VoResourcesImg;

import java.util.List;

/**
 * 参与人数信息回显list
 */
public class AppActivityRegistrationVo {
    /**
     * 用户主键id
     */
    private Integer id;
    /**
     * 用户姓名
     */
    private String name;
    /**
     * 用户联系方式
     */
    private String tel;
    /**
     * 用户头像资源信息
     */
    private List<VoResourcesImg> imgUrl;

    @Override
    public String toString() {
        return "AppActivityRegistrationVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", imgUrl=" + imgUrl +
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

    public List<VoResourcesImg> getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(List<VoResourcesImg> imgUrl) {
        this.imgUrl = imgUrl;
    }

    public AppActivityRegistrationVo() {
    }

    public AppActivityRegistrationVo(Integer id, String name, String tel, List<VoResourcesImg> imgUrl) {
        this.id = id;
        this.name = name;
        this.tel = tel;
        this.imgUrl = imgUrl;
    }
}
