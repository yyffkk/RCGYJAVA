package com.api.vo.butlerApp;

import com.api.vo.resources.VoResourcesImg;

import java.util.List;

/**
 * 管家app个人信息
 */
public class ButlerPersonalDataVo {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 头像资源
     */
    private List<VoResourcesImg> imgUrls;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 联系号码
     */
    private String tel;

    @Override
    public String toString() {
        return "ButlerPersonalDataVo{" +
                "id=" + id +
                ", imgUrls=" + imgUrls +
                ", nickName='" + nickName + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<VoResourcesImg> getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(List<VoResourcesImg> imgUrls) {
        this.imgUrls = imgUrls;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public ButlerPersonalDataVo() {
    }

    public ButlerPersonalDataVo(Integer id, List<VoResourcesImg> imgUrls, String nickName, String tel) {
        this.id = id;
        this.imgUrls = imgUrls;
        this.nickName = nickName;
        this.tel = tel;
    }
}
