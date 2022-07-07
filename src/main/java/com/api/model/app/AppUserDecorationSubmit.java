package com.api.model.app;

import java.util.Arrays;
import java.util.List;

/**
 * 装修公司提交信息
 */
public class AppUserDecorationSubmit {
    /**
     * 装修单号
     */
    private String code;
    /**
     * 装修公司
     */
    private String constructionUnit;
    /**
     * 装修人员信息集合
     */
    private List<AppUserDecorationPerson> decorationPersonList;
    /**
     * 营业执照 照片路径数组
     */
    private String[] businessLicenseUrl;
    /**
     * 资质证书 照片路径数组
     */
    private String[] qualificationCertificate;
    /**
     * 装修图纸 照片路径数组
     */
    private String[] decorationDrawings;
    /**
     * 装修申请表 照片路径数组
     */
    private String[] decorationApplicationForm;
    /**
     * 装修承诺书 照片路径数组
     */
    private String[] decorationCommitment;

    @Override
    public String toString() {
        return "AppUserDecorationSubmit{" +
                "code='" + code + '\'' +
                ", constructionUnit='" + constructionUnit + '\'' +
                ", decorationPersonList=" + decorationPersonList +
                ", businessLicenseUrl=" + Arrays.toString(businessLicenseUrl) +
                ", qualificationCertificate=" + Arrays.toString(qualificationCertificate) +
                ", decorationDrawings=" + Arrays.toString(decorationDrawings) +
                ", decorationApplicationForm=" + Arrays.toString(decorationApplicationForm) +
                ", decorationCommitment=" + Arrays.toString(decorationCommitment) +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getConstructionUnit() {
        return constructionUnit;
    }

    public void setConstructionUnit(String constructionUnit) {
        this.constructionUnit = constructionUnit;
    }

    public List<AppUserDecorationPerson> getDecorationPersonList() {
        return decorationPersonList;
    }

    public void setDecorationPersonList(List<AppUserDecorationPerson> decorationPersonList) {
        this.decorationPersonList = decorationPersonList;
    }

    public String[] getBusinessLicenseUrl() {
        return businessLicenseUrl;
    }

    public void setBusinessLicenseUrl(String[] businessLicenseUrl) {
        this.businessLicenseUrl = businessLicenseUrl;
    }

    public String[] getQualificationCertificate() {
        return qualificationCertificate;
    }

    public void setQualificationCertificate(String[] qualificationCertificate) {
        this.qualificationCertificate = qualificationCertificate;
    }

    public String[] getDecorationDrawings() {
        return decorationDrawings;
    }

    public void setDecorationDrawings(String[] decorationDrawings) {
        this.decorationDrawings = decorationDrawings;
    }

    public String[] getDecorationApplicationForm() {
        return decorationApplicationForm;
    }

    public void setDecorationApplicationForm(String[] decorationApplicationForm) {
        this.decorationApplicationForm = decorationApplicationForm;
    }

    public String[] getDecorationCommitment() {
        return decorationCommitment;
    }

    public void setDecorationCommitment(String[] decorationCommitment) {
        this.decorationCommitment = decorationCommitment;
    }

    public AppUserDecorationSubmit() {
    }

    public AppUserDecorationSubmit(String code, String constructionUnit, List<AppUserDecorationPerson> decorationPersonList, String[] businessLicenseUrl, String[] qualificationCertificate, String[] decorationDrawings, String[] decorationApplicationForm, String[] decorationCommitment) {
        this.code = code;
        this.constructionUnit = constructionUnit;
        this.decorationPersonList = decorationPersonList;
        this.businessLicenseUrl = businessLicenseUrl;
        this.qualificationCertificate = qualificationCertificate;
        this.decorationDrawings = decorationDrawings;
        this.decorationApplicationForm = decorationApplicationForm;
        this.decorationCommitment = decorationCommitment;
    }
}
