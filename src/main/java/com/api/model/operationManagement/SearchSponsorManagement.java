package com.api.model.operationManagement;

/**
 * 主办方管理搜索条件
 */
public class SearchSponsorManagement {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 主办方单位
     */
    private String sponsorUnit;
    /**
     * 联系人（负责人）
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

    @Override
    public String toString() {
        return "SearchSponsorManagement{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", sponsorUnit='" + sponsorUnit + '\'' +
                ", director='" + director + '\'' +
                ", tel='" + tel + '\'' +
                ", idType=" + idType +
                ", idNumber='" + idNumber + '\'' +
                '}';
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getSponsorUnit() {
        return sponsorUnit;
    }

    public void setSponsorUnit(String sponsorUnit) {
        this.sponsorUnit = sponsorUnit;
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

    public SearchSponsorManagement() {
    }

    public SearchSponsorManagement(int pageNum, int size, String sponsorUnit, String director, String tel, Integer idType, String idNumber) {
        this.pageNum = pageNum;
        this.size = size;
        this.sponsorUnit = sponsorUnit;
        this.director = director;
        this.tel = tel;
        this.idType = idType;
        this.idNumber = idNumber;
    }
}
