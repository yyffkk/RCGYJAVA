package com.api.vo.operationManagement;

import com.api.vo.resources.VoResourcesImg;

import java.util.List;

/**
 * 主办方管理Vo list 回显
 */
public class VoSponsorManagement {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 主办方单位
     */
    private String sponsorUnit;
    /**
     * 照片资源集合
     */
    private List<VoResourcesImg> imgUrls;
    /**
     * 负责人
     */
    private String director;
    /**
     * 联系方式
     */
    private String tel;
    /**
     * 证件类型
     */
    private Integer idType;
    /**
     * 证件号码
     */
    private String idNumber;
    /**
     * 主办次数（活动管理中去统计）
     */
    private Integer num;

    @Override
    public String toString() {
        return "VoSponsorManagement{" +
                "id=" + id +
                ", sponsorUnit='" + sponsorUnit + '\'' +
                ", imgUrls=" + imgUrls +
                ", director='" + director + '\'' +
                ", tel='" + tel + '\'' +
                ", idType=" + idType +
                ", idNumber='" + idNumber + '\'' +
                ", num=" + num +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSponsorUnit() {
        return sponsorUnit;
    }

    public void setSponsorUnit(String sponsorUnit) {
        this.sponsorUnit = sponsorUnit;
    }

    public List<VoResourcesImg> getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(List<VoResourcesImg> imgUrls) {
        this.imgUrls = imgUrls;
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

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public VoSponsorManagement() {
    }

    public VoSponsorManagement(Integer id, String sponsorUnit, List<VoResourcesImg> imgUrls, String director, String tel, Integer idType, String idNumber, Integer num) {
        this.id = id;
        this.sponsorUnit = sponsorUnit;
        this.imgUrls = imgUrls;
        this.director = director;
        this.tel = tel;
        this.idType = idType;
        this.idNumber = idNumber;
        this.num = num;
    }
}
