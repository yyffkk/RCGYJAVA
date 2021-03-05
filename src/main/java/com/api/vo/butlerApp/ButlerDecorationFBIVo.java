package com.api.vo.butlerApp;

import java.util.Date;

/**
 * 装修信息 Vo findById 回显
 */
public class ButlerDecorationFBIVo {
    /**
     * 装修主键id
     */
    private Integer id;
    /**
     * 装修房屋名称
     */
    private String roomName;
    /**
     * 申请人名称（业主或租户，用户表）
     */
    private String residentName;
    /**
     * 申请人电话
     */
    private String residentTel;
    /**
     * 装修公司
     */
    private String constructionUnit;
    /**
     * 装修负责人
     */
    private String director;
    /**
     * 装修负责人联系电话
     */
    private String directorTel;
    /**
     * 实际开始时间（开始装修）
     */
    private Date actualBegin;
    /**
     * 检查跟踪人（物业表）
     */
    private Integer tracker;

    @Override
    public String toString() {
        return "ButlerDecorationFBIVo{" +
                "id=" + id +
                ", roomName='" + roomName + '\'' +
                ", residentName='" + residentName + '\'' +
                ", residentTel='" + residentTel + '\'' +
                ", constructionUnit='" + constructionUnit + '\'' +
                ", director='" + director + '\'' +
                ", directorTel='" + directorTel + '\'' +
                ", actualBegin=" + actualBegin +
                ", tracker=" + tracker +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getResidentName() {
        return residentName;
    }

    public void setResidentName(String residentName) {
        this.residentName = residentName;
    }

    public String getResidentTel() {
        return residentTel;
    }

    public void setResidentTel(String residentTel) {
        this.residentTel = residentTel;
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

    public Date getActualBegin() {
        return actualBegin;
    }

    public void setActualBegin(Date actualBegin) {
        this.actualBegin = actualBegin;
    }

    public Integer getTracker() {
        return tracker;
    }

    public void setTracker(Integer tracker) {
        this.tracker = tracker;
    }

    public ButlerDecorationFBIVo() {
    }

    public ButlerDecorationFBIVo(Integer id, String roomName, String residentName, String residentTel, String constructionUnit, String director, String directorTel, Date actualBegin, Integer tracker) {
        this.id = id;
        this.roomName = roomName;
        this.residentName = residentName;
        this.residentTel = residentTel;
        this.constructionUnit = constructionUnit;
        this.director = director;
        this.directorTel = directorTel;
        this.actualBegin = actualBegin;
        this.tracker = tracker;
    }
}
