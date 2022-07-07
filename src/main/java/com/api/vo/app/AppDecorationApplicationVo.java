package com.api.vo.app;

import java.util.Date;

/**
 * 申请装修信息Vo 回显
 */
public class AppDecorationApplicationVo {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 装修公司【装修最开始填入信息】
     */
    private String constructionUnit;
    /**
     * 装修负责人【装修最开始填入信息】
     */
    private String director;
    /**
     * 装修负责人联系电话【装修最开始填入信息】
     */
    private String directorTel;
    /**
     * 紧急联系人【装修最开始填入信息】
     */
    private String emergencyContact;
    /**
     * 紧急联系人电话【装修最开始填入信息】
     */
    private String tel;
    /**
     * 预计开始时间【装修最开始填入信息】
     */
    private Date expectedBegin;
    /**
     * 预计结束时间【装修最开始填入信息】
     */
    private Date expectedEnd;

    @Override
    public String toString() {
        return "AppDecorationApplicationVo{" +
                "id=" + id +
                ", constructionUnit='" + constructionUnit + '\'' +
                ", director='" + director + '\'' +
                ", directorTel='" + directorTel + '\'' +
                ", emergencyContact='" + emergencyContact + '\'' +
                ", tel='" + tel + '\'' +
                ", expectedBegin=" + expectedBegin +
                ", expectedEnd=" + expectedEnd +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConstructionUnit() {
        return constructionUnit;
    }

    public void setConstructionUnit(String constructionUnit) {
        this.constructionUnit = constructionUnit;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDirectorTel() {
        return directorTel;
    }

    public void setDirectorTel(String directorTel) {
        this.directorTel = directorTel;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getExpectedBegin() {
        return expectedBegin;
    }

    public void setExpectedBegin(Date expectedBegin) {
        this.expectedBegin = expectedBegin;
    }

    public Date getExpectedEnd() {
        return expectedEnd;
    }

    public void setExpectedEnd(Date expectedEnd) {
        this.expectedEnd = expectedEnd;
    }

    public AppDecorationApplicationVo() {
    }

    public AppDecorationApplicationVo(Integer id, String constructionUnit, String director, String directorTel, String emergencyContact, String tel, Date expectedBegin, Date expectedEnd) {
        this.id = id;
        this.constructionUnit = constructionUnit;
        this.director = director;
        this.directorTel = directorTel;
        this.emergencyContact = emergencyContact;
        this.tel = tel;
        this.expectedBegin = expectedBegin;
        this.expectedEnd = expectedEnd;
    }
}
