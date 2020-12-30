package com.api.vo.operationManagement;

import com.api.vo.resources.VoResourcesImg;

import java.util.List;

/**
 * 主办方管理 Vo findById 回显
 */
public class VoFindByIdSponsorManagement {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 主办方单位
     */
    private String sponsorUnit;
    /**
     * 照片资源
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
     * 证件类型（1.身份证）
     */
    private Integer idType;
    /**
     * 证件号码
     */
    private String idNumber;

    @Override
    public String toString() {
        return "VoFindByIdSponsorManagement{" +
                "id=" + id +
                ", sponsorUnit='" + sponsorUnit + '\'' +
                ", imgUrls=" + imgUrls +
                ", director='" + director + '\'' +
                ", tel='" + tel + '\'' +
                ", idType=" + idType +
                ", idNumber='" + idNumber + '\'' +
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

    public VoFindByIdSponsorManagement() {
    }

    public VoFindByIdSponsorManagement(Integer id, String sponsorUnit, List<VoResourcesImg> imgUrls, String director, String tel, Integer idType, String idNumber) {
        this.id = id;
        this.sponsorUnit = sponsorUnit;
        this.imgUrls = imgUrls;
        this.director = director;
        this.tel = tel;
        this.idType = idType;
        this.idNumber = idNumber;
    }
}
