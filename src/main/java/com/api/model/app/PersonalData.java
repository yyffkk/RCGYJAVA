package com.api.model.app;

import com.api.vo.resources.VoResourcesImg;

import java.util.Date;
import java.util.List;

/**
 * 个人资料信息
 */
public class PersonalData {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 头像资源
     */
    private List<VoResourcesImg> imgUrls;
    /**
     * 住户名称
     */
    private String name;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 联系号码
     */
    private String tel;
    /**
     * 性别 1.男 2.女
     */
    private Integer sex;
    /**
     * 出生日期
     */
    private Date birthday;

    @Override
    public String toString() {
        return "PersonalData{" +
                "id=" + id +
                ", imgUrls=" + imgUrls +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", tel='" + tel + '\'' +
                ", sex=" + sex +
                ", birthday=" + birthday +
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public PersonalData() {
    }

    public PersonalData(Integer id, List<VoResourcesImg> imgUrls, String name, String nickName, String tel, Integer sex, Date birthday) {
        this.id = id;
        this.imgUrls = imgUrls;
        this.name = name;
        this.nickName = nickName;
        this.tel = tel;
        this.sex = sex;
        this.birthday = birthday;
    }
}
